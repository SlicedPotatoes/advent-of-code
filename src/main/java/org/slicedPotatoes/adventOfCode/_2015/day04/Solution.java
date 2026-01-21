package org.slicedPotatoes.adventOfCode._2015.day04;

import org.slicedPotatoes.adventOfCode.utils.ReadFile;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Solution {

    /**
     * Renvoie la représentation hexadécimale d'un octet
     *
     * @param i Un octet
     * @return Représentation hexadécimale de i
     */
    public static String byteToHex(byte i) {
        String values = "0123456789abcdef";

        int a = i & 0b00001111;
        int b = (i & 0b11110000) >> 4;

        return "" + values.charAt(b) + values.charAt(a);
    }

    /**
     * Renvoie une chaine représentant le hash MD5 d'un String
     *
     * @param value Valeur a hashé
     * @return Hash de value
     * @throws NoSuchAlgorithmException
     */
    public static String getMd5String(String value) throws NoSuchAlgorithmException {
        byte[] bytes = value.getBytes();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = md.digest(bytes);

        StringBuilder stb = new StringBuilder();

        for(byte b : md5Bytes) {
            stb.append(byteToHex(b));
        }

        return stb.toString();
    }

    /**
     * Renvoie vrai si une chaine passée en argument commence par count caractère c
     *
     * @param s Le String a testé
     * @param c Le caractère que l'on souhaite en début de chaine
     * @param count Le nombre occurrence de c
     * @return true si la chaine respecte les critères sinon false
     */
    public static boolean stringStartWith(String s, char c, int count) {
        if(s.length() < count) { return false; }

        for(int i = 0; i < count; i++) {
            if(s.charAt(i) != c) {
                return false;
            }
        }

        return true;
    }

    public static int resolve(String content, int nbStartZero) throws NoSuchAlgorithmException {
        int res = 0;

        while(true) {
            String md5 = getMd5String(content + res);

            if(stringStartWith(md5, '0', nbStartZero)) {
                break;
            }

            res++;
        }

        return res;
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String content = ReadFile.getFullFile("_2015/day04/input.txt");

        int part1 = resolve(content, 5);
        int part2 = resolve(content, 6);

        System.out.println("Part1: " + part1);
        System.out.println("Part2: " + part2);
    }
}
