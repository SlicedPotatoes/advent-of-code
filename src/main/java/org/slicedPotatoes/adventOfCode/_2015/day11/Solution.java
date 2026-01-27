package org.slicedPotatoes.adventOfCode._2015.day11;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * Incrémenter une chaine de caractère de 1<br><br>
     *
     * Interprète la chaine de caractère comme un nombre en base 26<br>
     * Dans ce contexte, 'z' est le dernier chiffre (équivalant de '9' en base 10).<br>
     * Donc si une chaine se termine par un ou plusieurs 'z', ils sont remplacé par des 'a' (équivalant de '0' en base 10).<br>
     * Le prochain caractère qui n'est pas 'z' est alors incrémenté.<br><br>
     *
     * Gère le cas d'une chaine rempli de 'z', elle sera de longeur n+1 et remplis exclusivement de 'a'.
     *
     * @param s La chaine à incrémenter
     * @return La chaine incrémentais
     */
    public static String increment(String s) {
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;

        // Gère le cas de l'incrémentation d'une chaine se terminant par des 'z'
        while(i >= 0 && s.charAt(i) == 'z') {
            sb.append('a');
            i--;
        }

        if(i >= 0) {
            // Incrémente le caractère qui n'est pas 'z'
            sb.append( Character.toChars(s.charAt(i--) + 1) );
            // Copie les autres caractères
            for(; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
        }
        // Cas d'une chaine remplis de 'z'
        else {
            sb.append('a');
        }

        return sb.reverse().toString();
    }

    /**
     * Permet de vérifier si une chaine correspond à un mot de passe valide.<br><br>
     *
     * Un mot de passe est dit valide s'il respecte les conditions suivantes :<br>
     * - Ne contient pas les lettres 'i', 'o', 'l'.<br>
     * - Contient une séquence de trois lettres consécutives, comme 'abc', 'bcd', jusqu'à 'xyz'.<br>
     * - Contient au moins deux séquences distinctes de deux lettres identiques, comme 'aa', 'bb', etc.
     *
     * @param s La chaine à vérifier
     * @return true ou false en fonction de si la chaine respecte les conditions
     */
    public static boolean isValidPassword(String s) {
        Set<Character> illegal = Set.of('i', 'o', 'l');

        char[] previous = {' ', ' '};

        boolean increasingSequence = false;
        Set<String> pair = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Ne contient pas les lettres 'i', 'o', 'l'
            if(illegal.contains(c)) {
                return false;
            }

            // Séquence de trois lettres consécutives
            if(previous[0] == previous[1] - 1 && previous[0] == c - 2) {
                increasingSequence = true;
            }

            // Paire de lettre identiques
            if(previous[1] == c) {
                pair.add(String.valueOf(c) + c);
            }

            previous[0] = previous[1];
            previous[1] = c;
        }

        return increasingSequence && pair.size() >= 2;
    }

    /**
     * Pour un mot de passe donnée, renvoie le mot de passe suivant valide.
     *
     * @param s Mot de passe courant
     * @return Le prochain mot de passe valide
     */
    public static String nextValidPassword(String s) {
        do {
            s = increment(s);
        } while (!isValidPassword(s));

        return s;
    }

    public static void main(String[] args) throws IOException {
        String input = ReadFile.getFullFile("_2015/day11/input.txt");

        String part1 = nextValidPassword(input);
        String part2 = nextValidPassword(part1);

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
