package com.example.repository;


import com.example.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Veritabanı ile etkileşim katmanı.
public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByName(String name); // Besin adına göre arama.
}
