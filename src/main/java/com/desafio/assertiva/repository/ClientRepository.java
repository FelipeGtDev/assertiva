package com.desafio.assertiva.repository;

import com.desafio.assertiva.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    @Query(value = "SELECT c.* FROM client c " +
            "JOIN phone p ON c.id = p.client_id " +
            "WHERE p.ddd = :areaCode ", nativeQuery = true)
    List<ClientModel> findClientByAreaCode(String areaCode);

    @Query(value = "SELECT c.* FROM client c " +
            "WHERE lower(c.name) like lower(concat('%', :name, '%')) ", nativeQuery = true)
    List<ClientModel> findByNameIgnoreCase(String name);

    @Query(value = "SELECT * FROM client c WHERE c.id = :id", nativeQuery = true)
    ClientModel findById(int id);


//    @Query(value = "SELECT * FROM client", countQuery = "SELECT COUNT(*) FROM client", nativeQuery = true)
//    @Query(value = "SELECT * FROM client", nativeQuery = true)
//    Page<ClientModel> findAllWithPagination(Pageable pageable);

    @Query(value = "SELECT * FROM client", nativeQuery = true)
    List<ClientModel> findAll();
}
