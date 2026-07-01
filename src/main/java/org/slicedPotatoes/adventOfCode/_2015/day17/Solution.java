package org.slicedPotatoes.adventOfCode._2015.day17;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.List;

public class Solution {
    public static final int NEED_TO_STORE = 150;

    /**
     * Parcours de manière récursif chaque combinaison unique de container
     * <br>
     * Comptabilise les combinaisons ou la somme des containers vaux needToStore
     *
     * @param containers    Liste des containers
     * @param needToStore   Quantité exacte souhaité
     * @param currValue     Quantité actuelle
     * @param depth         Nombre de container
     * @param lastIndex     Index du dernier container
     * @param result        Résultats
     */
    private static void _process(int[] containers, int needToStore, int currValue, int depth, int lastIndex, Result result) {
        // Condition d'arrêt quand on a une liste de container qui permette de stocker exactement la quantité souhaitée
        if (currValue == needToStore) {
            result.part1++;

            if (result.minNbContainer > depth) {
                result.minNbContainer = depth;
                result.part2 = 0;
            }
            if (result.minNbContainer == depth) {
                result.part2++;
            }

            return;
        }

        // Condition d'arrêt quand la quantité actuelle dépasse la quantité souhaitée
        if (currValue > needToStore) {
            return;
        }

        for(int i = lastIndex + 1; i < containers.length; i++) {
            _process(containers, needToStore, currValue + containers[i], depth + 1, i, result);
        }
    }

    public static Result process(int[] containers, int needToStore) {
        Result result = new Result();

        _process(containers, needToStore, 0, 0, -1, result);

        return result;
    }

    public static void main(String[] args) throws IOException {
        List<String> content = ReadFile.getLines("_2015/day17/input.txt");

        int[] containers = content.stream().mapToInt(Integer::parseInt).toArray();

        Result result = process(containers, NEED_TO_STORE);

        System.out.println("Part 1: " + result.part1);
        System.out.println("Part 2: " + result.part2);
    }
}
