package me.valizadeh.practices.supahands.deduplicationchallenge;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solution {
    public static void main(String args[]) throws Exception {
        Set<String> uniquePhoneNumbers = new HashSet<>();

        Scanner in = new Scanner(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int countofPhoneNumbers = in.nextInt();
        while (countofPhoneNumbers-- > 0) {
            String phoneNumber = in.nextLine();
            if (!uniquePhoneNumbers.contains(phoneNumber)) {
                uniquePhoneNumbers.add(phoneNumber);
                out.write(phoneNumber);
                out.newLine();
            }
        }
        out.close();
    }
}
