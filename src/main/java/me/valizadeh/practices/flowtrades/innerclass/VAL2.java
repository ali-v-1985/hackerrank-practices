package me.valizadeh.practices.flowtrades.innerclass;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by valizadeh on 05/07/2018.
 */
public class VAL2 implements Comparator<VAL2> {
    int dishSize;
    @Override
    public int compare(VAL2 a, VAL2 b) {
        return b.dishSize - a.dishSize;
    }

    VAL2(int d) {
        dishSize = d;
    }

    public static void main(String[] args) {
        VAL2[] va = {new VAL2(40),new VAL2(200),new VAL2(60)};
        Arrays.sort(va,va[0]);
        int index = Arrays.binarySearch(va, new VAL2(40), va[0]);
        System.out.print(index+ " ");
        index = Arrays.binarySearch(va, new VAL2(80), va[0]);
        System.out.print(index+ " ");

    }
}
