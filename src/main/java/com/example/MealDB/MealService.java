package com.example.MealDB;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class MealService {

    private static final String API =
            "https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata";

    public Map<String, Object> getMealWithLeastIngredients() {

        RestTemplate restTemplate = new RestTemplate();

        Map response = restTemplate.getForObject(API, Map.class);

        List<Map<String, Object>> meals =
                (List<Map<String, Object>>) response.get("meals");

        Map<String, Object> leastMeal = null;
        int minIngredients = Integer.MAX_VALUE;

        for (Map<String, Object> meal : meals) {

            int count = 0;

            for (int i = 1; i <= 20; i++) {

                String ingredient = (String) meal.get("strIngredient" + i);

                if (ingredient != null && !ingredient.trim().isEmpty()) {
                    count++;
                }
            }

            if (count < minIngredients) {
                minIngredients = count;
                leastMeal = meal;
            }
        }

        return leastMeal;
    }
}