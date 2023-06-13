package com.desafio.assertiva.repository;

import com.desafio.assertiva.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT c.* FROM client c " +
            "JOIN phone p ON c.id = p.client_id " +
            "WHERE p.ddd = :areaCode ", nativeQuery = true)
    Page<Client> findClientByAreaCode(String areaCode, Pageable page);

    @Query(value = "SELECT c.* FROM client c " +
            "WHERE lower(c.name) like lower(concat('%', :name, '%'))", nativeQuery = true)
    Page<Client> findByNameIgnoreCase(String name, Pageable page);

    @Query(value = "SELECT * FROM client c WHERE c.id = :id", nativeQuery = true)
    Client findById(int id);

    @Query(value = "DELETE FROM client c WHERE c.id = :id", nativeQuery = true)
    void deleteById(int id);
}
