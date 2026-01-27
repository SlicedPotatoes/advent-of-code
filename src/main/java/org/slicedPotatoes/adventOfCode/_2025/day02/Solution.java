package org.slicedPotatoes.adventOfCode._2025.day02;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Récupérer la liste des diviseurs d'un nombre n
     *
     * @param n Nombre n
     * @return Liste des diviseurs de n.
     */
    public static List<Integer> getDivisor(int n) {
        List<Integer> divisors = new ArrayList<>();

        for(int i = n-1; i >= 1; i--) {
            if(n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    /**
     * <p>Renvoie faux, si pour une chaine donnée, découpé en sous-chaine de taille segmentSize, tous les segments sont identiques</p>
     * <p>Renvoie vrai dans le cas ou il existe un segment différent des autres OU que la chaine n'est pas divisible en segment de taille segmentSize</p>
     *
     * @param s La chaine à vérifier
     * @param segmentSize La taille d'un segment
     * @return true ou false en fonction de si la chaine respecte les conditions décrites plus haut.
     */
    public static boolean isValid(String s, int segmentSize) {
        if(s.length() % segmentSize != 0) { return true; }

        List<String> segments = new ArrayList<>();

        for(int i = 0; i < s.length(); i += segmentSize) {
            segments.add(s.substring(i, i + segmentSize));
        }

        for(String segment : segments) {
            if(!segment.equals(segments.getFirst())) {
                return true;
            }
        }

        return false;
    }

    /**
     * <p>Renvoie faux, si pour une chaine donnée, et pour au moins un découpage de celle-ci en partie de longeur égal noté n, chaque segment du découpage n sont identiques</p>
     * <p>Renvoie vrai dans le cas ou il n'existe aucun découpage en partie égal de longeur n, où chaque segment sont identiques</p>
     *
     * @param s La chaine à vérifier
     * @return true ou false en fonction de si la chaine respecte les conditions décrites plus haut.
     */
    public static boolean isValid(String s) {
        List<Integer> divisors = getDivisor(s.length());

        for(int segmentSize : divisors) {
            if(!isValid(s, segmentSize)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        String datas = ReadFile.getFullFile("_2025/day02/input.txt");

        String[] splitedDatas = datas.split(",");

        long part1 = 0;
        long part2 = 0;

        // Pour chaque plage
        for (String range : splitedDatas) {
            String[] splitedRange = range.split("-");

            // Récupération du début et fin de la plage
            long debut = Long.parseLong(splitedRange[0]);
            long fin = Long.parseLong(splitedRange[1]);

            // Itération sur la plage
            for(long i = debut; i <= fin; i++) {
                String s = String.valueOf(i);

                // Partie 1
                if(s.length() % 2 == 0 && !isValid(s, s.length() / 2)) {
                    part1 += i;
                }

                // Partie 2
                if(!isValid(s)) {
                    part2 += i;
                }
            }
        }

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
