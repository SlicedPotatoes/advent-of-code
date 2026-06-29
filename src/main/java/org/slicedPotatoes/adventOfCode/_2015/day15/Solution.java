package org.slicedPotatoes.adventOfCode._2015.day15;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static final int MAX_INGREDIENT = 100;
    public static final int CALORIES_EXPECTED = 500;

    /**
     * Créer les différentes combinaisons de cookie.
     * <br>
     * Profondeur de récursion maximale = nombre d'ingrédients différent.
     * <br>
     * Nombre total d'ingrédients dans le cookie {@link Solution#MAX_INGREDIENT}
     * <br>
     * En part2, on cherche le cookie optimal avec {@link Solution#CALORIES_EXPECTED}
     *
     * @param ingredients       Liste des ingrédients
     * @param current           Préparation courante
     * @param ingredientIndex   Ingrédient courant qui va être ajouté a la préparation
     * @param totalIngredient   Nombre total d'ingrédients utilisé actuellement
     * @param isPart1           FLAG part1 ou part2
     */
    public static int bestCookie(Ingredient[] ingredients, Map<Ingredient, Integer> current, int ingredientIndex, int totalIngredient, boolean isPart1) {
        // Si le cookie est complet, calcul du score
        if (totalIngredient == MAX_INGREDIENT) {
            Cookie c = new Cookie(Map.copyOf(current));

            // Part2
            if(!isPart1 && c.calories() != CALORIES_EXPECTED) {
                return 0;
            }

            return c.score();
        }
        // S'il manque un seul ingrédiant, ont rempli le cookie avec l'ingrédiant manquant
        if(ingredientIndex == ingredients.length - 1) {
            current.put(ingredients[ingredientIndex], MAX_INGREDIENT - totalIngredient);
            int score = bestCookie(ingredients, current, ingredientIndex + 1, MAX_INGREDIENT, isPart1);
            current.remove(ingredients[ingredientIndex]);
            return score;
        }

        int best = Integer.MIN_VALUE;

        for (int i = 0; i < MAX_INGREDIENT - totalIngredient; i++) {
            current.put(ingredients[ingredientIndex], i);

            best = Math.max(best, bestCookie(ingredients, current, ingredientIndex + 1, totalIngredient + i, isPart1));

            current.remove(ingredients[ingredientIndex]);
        }

        return best;
    }

    public static void main(String[] args) throws IOException {
        List<String> content = ReadFile.getLines("_2015/day15/input.txt");

        Ingredient[] ingredients = new Ingredient[content.size()];

        // Parsing
        for (int i = 0; i < ingredients.length; i++) {
            String[] splitedLine = content.get(i).split(": ");
            String[] properties = splitedLine[1].split(", ");


            String name = splitedLine[0];
            int capacity = Integer.parseInt(properties[0].split(" ")[1]);
            int durability = Integer.parseInt(properties[1].split(" ")[1]);
            int flavor = Integer.parseInt(properties[2].split(" ")[1]);
            int texture = Integer.parseInt(properties[3].split(" ")[1]);
            int calories = Integer.parseInt(properties[4].split(" ")[1]);

            ingredients[i] = new Ingredient(name, capacity, durability, flavor, texture, calories);
        }

        int part1 = bestCookie(ingredients, new HashMap<>(), 0, 0, true);
        int part2 = bestCookie(ingredients, new HashMap<>(), 0, 0, false);

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
