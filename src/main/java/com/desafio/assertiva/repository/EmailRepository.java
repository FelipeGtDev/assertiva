package com.desafio.assertiva.repository;

import com.desafio.assertiva.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

    @Query(
            value = "SELECT e.* FROM email e " +
                    "WHERE e.client_id = :client_id", nativeQuery = true
    )
    List<Email> findByClientId(Integer client_id);
}
