package me.valizadeh.practices.flowtrades.repeatedwords;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by valizadeh on 05/07/2018.
 */
public class Solution {

    static String firstRepeatedWord(String s) {
        StringTokenizer tokenizer = new StringTokenizer(s," \t,:;-.");
        List<String> words = new ArrayList<>();
        while (tokenizer.hasMoreElements()) {
            words.add(String.valueOf(tokenizer.nextToken()));
        }

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if(words.get(i).equals(words.get(j))) {
                    return words.get(j);
                }

            }

        }
        return null;
    }

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("Ali testSpace\ttestTab,testComma:testColon;Ali;testSemiColon-testDash.testDot"," \t,:;-.");
        List<String> words = new ArrayList<>();
        while (tokenizer.hasMoreElements()) {
            words.add(String.valueOf(tokenizer.nextToken()));
        }

        /*for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if(words.get(i).equals(words.get(j))) {
                    System.out.println(words.get(j));
                    break;
                }

            }

        }*/

       /* for (String word : words) {
            for (String s : words) {

            }
        }*/
        for (String word : words) {
            System.out.println(word);
        }
    }
}
