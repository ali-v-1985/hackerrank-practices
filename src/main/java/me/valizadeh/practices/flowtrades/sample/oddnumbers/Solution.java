package me.valizadeh.practices.flowtrades.sample.oddnumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valizadeh on 05/07/2018.
 */
public class Solution {

    static int[] oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = l; i <= r; i++) {
            if(i % 2 != 0) {
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        int j = 0;
        for (Integer integer : list) {
            arr[j++] = integer;
        }
        return arr;
    }
}
