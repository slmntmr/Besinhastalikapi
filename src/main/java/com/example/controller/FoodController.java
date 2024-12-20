package com.example.controller;


import com.example.entity.Disease;
import com.example.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/foods") // Base URL
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/{name}/related-diseases")
    public List<Disease> getRelatedDiseases(@PathVariable String name) {
        return foodService.getRelatedDiseases(name);
    }
}
