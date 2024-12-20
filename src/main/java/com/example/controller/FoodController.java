package com.example.controller;


import com.example.dto.DiseaseDTO;
import com.example.entity.Disease;
import com.example.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/{name}/related-diseases") // http://localhost:8080/api/foods/Zencefil/related-diseases
    public List<DiseaseDTO> getRelatedDiseases(@PathVariable String name) {
        return foodService.getRelatedDiseases(name);
    }
}

