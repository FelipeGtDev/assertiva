package com.desafio.assertiva.repository;

import com.desafio.assertiva.model.PhoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneModel, Long> {

    @Query(
            value = "SELECT p.* FROM phone p " +
                    "WHERE p.client_id = :client_id", nativeQuery = true
    )
    List<PhoneModel> findByClientId(Integer client_id);
}
