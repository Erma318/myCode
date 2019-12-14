package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class MaximumScoreWordsFormedbyLetters {
    public static void main (String[] args) {
        MaximumScoreWordsFormedbyLetters machine = new MaximumScoreWordsFormedbyLetters();
        String[] words = {"add","dda","bb","ba","add"};
        char[] letters = {'a','a','a','a','b','b','b','b','c','c','c','c','c','d','d','d'};
        int[] score = {3,9,8,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(machine.maxScoreWords(words, letters, score));
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0) {
            return 0;
        }
        int[] countLetter = new int[26];
        for (char letter : letters) {
            countLetter[letter - 'a']++;
        }
        return dfs(countLetter, score, words, 0);
    }

    private int dfs (int[] countLetter, int[] score, String[] words, int index) {
        int max = 0;
        for (int i = index; i < words.length; i++) {
            int curScore = 0;
            boolean valid = true;
            for (char l : words[i].toCharArray()) {
                countLetter[l - 'a']--;
                curScore += score[l - 'a'];
                if (countLetter[l - 'a'] < 0) {
                    valid = false;
                }
            }
            if (valid) {
                curScore += dfs(countLetter, score, words, index + 1);
                max = Math.max(max, curScore);
            }
            for (char l : words[i].toCharArray()) {
                countLetter[l - 'a']++;
            }
        }
        return max;
    }
}
