package me.valizadeh.practices.booking.deltaencoding;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * Created by valizadeh on 19/07/2018.
 */
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] array = {25626, 25757, 24367, 24267, 16, 100, 2, 7277};
        int[] ints = delta_encode(array);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);

        }
    }

    /*
     * Complete the delta_encode function below.
     */
    static int[] delta_encode(int[] array) {
        Integer[] arrMid = new Integer[array.length * 2];
        int j = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (i == 0) {
                arrMid[j++] = array[i];
            }
            int delta = array[i + 1] - array[i];
            if (delta >= -127 && delta <= 127) {
                arrMid[j++] = delta;
            } else {
                arrMid[j++] = -128;
                arrMid[j++] = delta;
            }

        }
        int[] arrRes = new int[j];
        for (int i = 0; i < arrRes.length; i++) {
            arrRes[i] = arrMid[i];

        }
        return arrRes;
    }
}
