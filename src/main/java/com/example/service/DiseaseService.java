package com.example.service;



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

    public List<Food> getRecommendedFoods(String diseaseName) {
        // Hastalık adına göre önerilen besinleri döndürür.
        Disease disease = diseaseRepository.findByName(diseaseName)
                .orElseThrow(() -> new RuntimeException("Hastalık bulunamadı."));
        return List.copyOf(disease.getFoods());
    }
}
