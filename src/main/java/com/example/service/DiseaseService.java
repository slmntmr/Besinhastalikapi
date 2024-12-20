package com.example.service;



import com.example.dto.FoodDTO;
import com.example.entity.Disease;
import com.example.entity.Food;
import com.example.repository.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public List<FoodDTO> getRecommendedFoods(String diseaseName) {
        Disease disease = diseaseRepository.findByName(diseaseName)
                .orElseThrow(() -> new RuntimeException("Hastalık bulunamadı."));
        return disease.getFoods().stream()
                .map(food -> new FoodDTO(food.getName(), food.getDescription()))
                .toList(); // Besinleri DTO'ya dönüştürerek döndür.
    }
}

