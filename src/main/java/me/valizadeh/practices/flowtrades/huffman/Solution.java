package me.valizadeh.practices.flowtrades.huffman;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by valizadeh on 05/07/2018.
 */
public class Solution {

    static String decode(Map<String, Character> symbolByEncoding, String encodedText) {
        StringBuilder decodedText = new StringBuilder();
        StringBuilder convertedCode = new StringBuilder();
        for (String s1 : symbolByEncoding.keySet()) {
            for (String s : symbolByEncoding.keySet()) {
                if(encodedText.startsWith(s)) {
                    encodedText = encodedText.replace(s, "");
                    convertedCode.append(s);
                    decodedText.append(symbolByEncoding.get(s));
                }
            }
        }
        System.out.println(convertedCode.toString());
        return decodedText.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfEncodings = Integer.parseInt(in.nextLine());
        Map<String, Character> symbolByEncoding = new HashMap<>(numberOfEncodings);
        for(int i = 0; i < numberOfEncodings; i++) {
            String line = in.nextLine();
            char symbol = line.startsWith("[newline]")
                    ? '\n'
                    : line.charAt(0);
            String[] parts = line.split("\\s");
            String encoding = parts[parts.length - 1];
            symbolByEncoding.put(encoding, symbol);
        }

        String encodedText = in.nextLine();
        String decodedText = decode(symbolByEncoding, encodedText);
        bw.write(decodedText);
        bw.newLine();
        bw.close();

    }
}
