package com.example.repository;


import com.example.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {
    Optional<Disease> findByName(String name); // Hastalık adına göre arama.
}
