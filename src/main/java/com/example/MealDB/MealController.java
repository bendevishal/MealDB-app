package com.example.MealDB;

import com.example.MealDB.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/meals")
@CrossOrigin
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/least-ingredients")
    public Map<String, Object> getMeal() {

        return mealService.getMealWithLeastIngredients();
    }
}