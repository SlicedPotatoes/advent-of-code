package org.slicedPotatoes.adventOfCode._2015.day15;

import java.util.Map;

public class Cookie {
    private final Map<Ingredient, Integer> ingredients;

    public Cookie(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public int score() {
        int capacity = 0;
        int durability = 0;
        int flavor = 0;
        int texture = 0;

        for (Map.Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int count = entry.getValue();

            capacity += ingredient.capacity() * count;
            durability += ingredient.durability() * count;
            flavor += ingredient.flavor() * count;
            texture += ingredient.texture() * count;
        }

        if(capacity <= 0 || durability <= 0 || flavor <= 0 || texture <= 0) {
            return 0;
        }

        return  capacity * durability * flavor * texture;
    }

    public int calories() {
        int sum = 0;

        for (Map.Entry<Ingredient, Integer> entry : ingredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int count = entry.getValue();

            sum += ingredient.calories() * count;
        }

        return sum;
    }

    @Override
    public String toString() {
        return  "Cookie [ingredients=" + ingredients + "]";
    }
}
