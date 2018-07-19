package me.valizadeh.practices.booking.triangle;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * Created by valizadeh on 19/07/2018.
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(triangle(100,90,200));
    }
    // Complete the triangle function below.
    static int triangle(int a, int b, int c) {

        if(a <= 0 || b <= 0 || c <= 0)
            return 0;
        if(a == b && b == c) {
            return 1;
        } else if(a + b > c && a+ c > b && c + b > a){
            return 2;
        } else {
            return 0;
        }
    }

}
