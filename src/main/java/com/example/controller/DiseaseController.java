package com.example.controller;


import com.example.dto.FoodDTO;
import com.example.entity.Food;
import com.example.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diseases")
public class DiseaseController {

    private final DiseaseService diseaseService;

    @GetMapping("/{name}/recommended-foods") // http://localhost:8080/api/diseases/Migren/recommended-foods
    public List<FoodDTO> getRecommendedFoods(@PathVariable String name) {
        return diseaseService.getRecommendedFoods(name);
    }
}
