package com.example.service;



import com.example.entity.Disease;
import com.example.entity.Food;
import com.example.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // İş mantığı katmanı.
@RequiredArgsConstructor // Final değişkenler için constructor ekler.
public class FoodService {

    private final FoodRepository foodRepository;

    public List<Disease> getRelatedDiseases(String foodName) {
        // Besin adına göre ilişkili hastalıkları döndürür.
        Food food = foodRepository.findByName(foodName)
                .orElseThrow(() -> new RuntimeException("Besin bulunamadı."));
        return List.copyOf(food.getDiseases());
    }
}
