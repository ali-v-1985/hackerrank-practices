package me.valizadeh.practices.flowtrades.sample.findnumber;

/**
 * Created by valizadeh on 05/07/2018.
 */
public class Solution {

    private static String YES = "YES";
    private static String NO = "NO";
    static String findNumber(int[] arr, int k) {
        for (int i : arr) {
            if(i == k)
                return YES;
        }
        return NO;
    }

}
