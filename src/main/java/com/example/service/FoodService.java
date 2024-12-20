package com.example.service;



import com.example.dto.DiseaseDTO;
import com.example.entity.Disease;
import com.example.entity.Food;
import com.example.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public List<DiseaseDTO> getRelatedDiseases(String foodName) {
        Food food = foodRepository.findByName(foodName)
                .orElseThrow(() -> new RuntimeException("Besin bulunamadı."));
        return food.getDiseases().stream()
                .map(disease -> new DiseaseDTO(disease.getName(), disease.getDescription()))
                .toList(); // Hastalıkları DTO'ya dönüştürerek döndür.
    }
}

