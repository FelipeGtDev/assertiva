package com.desafio.assertiva.repository;

import com.desafio.assertiva.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, Integer> {

    @Query(
            value = "SELECT e.* FROM email e " +
                    "WHERE e.client_id = :client_id", nativeQuery = true
    )
    List<EmailModel> findByClientId(Integer client_id);
}
