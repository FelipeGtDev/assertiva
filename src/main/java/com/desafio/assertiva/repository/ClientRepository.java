package com.desafio.assertiva.repository;

import com.desafio.assertiva.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT c.* FROM client c " +
            "JOIN phone p ON c.id = p.client_id " +
            "WHERE p.ddd = :areaCode ", nativeQuery = true)
    List<Client> findClientByAreaCode(String areaCode);

    @Query(value = "SELECT c.* FROM client c " +
            "WHERE lower(c.name) like lower(concat('%', :name, '%')) ", nativeQuery = true)
    List<Client> findByNameIgnoreCase(String name);

    @Query(value = "SELECT * FROM client c WHERE c.id = :id", nativeQuery = true)
    Client findById(int id);


//    @Query(value = "SELECT * FROM client", countQuery = "SELECT COUNT(*) FROM client", nativeQuery = true)
//    @Query(value = "SELECT * FROM client", nativeQuery = true)
//    Page<ClientModel> findAllWithPagination(Pageable pageable);

    @Query(value = "SELECT * FROM client", nativeQuery = true)
    List<Client> findAll();
}
