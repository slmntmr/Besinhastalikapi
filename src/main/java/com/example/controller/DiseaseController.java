package com.example.controller;


import com.example.entity.Food;
import com.example.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diseases") // Base URL
public class DiseaseController {

    private final DiseaseService diseaseService;

    @GetMapping("/{name}/recommended-foods")
    public List<Food> getRecommendedFoods(@PathVariable String name) {
        return diseaseService.getRecommendedFoods(name);
    }
}
