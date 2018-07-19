package me.valizadeh.practices.booking.customerservicecapacity;

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
        List<List<Integer>>  callsTimes = new ArrayList<>();
        List<Integer> callTimes1 = new ArrayList<>();
        callTimes1.add(1481122000);
        callTimes1.add(1481122020);
        callsTimes.add(callTimes1);
        List<Integer> callTimes2 = new ArrayList<>();
        callTimes2.add(1481122000);
        callTimes2.add(1481122040);
        callsTimes.add(callTimes2);
        List<Integer> callTimes3 = new ArrayList<>();
        callTimes3.add(1481122030);
        callTimes3.add(1481122035);
        callsTimes.add(callTimes3);
//        List<Integer> callTimes4 = new ArrayList<>();
//        callTimes4.add(1481122031);
//        callTimes4.add(1481122045);
//        callsTimes.add(callTimes4);
        System.out.println(howManyAgentsToAdd1(1, callsTimes));
    }
    // Complete the howManyAgentsToAdd function below.
    static int howManyAgentsToAdd(int noOfCurrentAgents, List<List<Integer>> callsTimes) {
        int additionals = 0;
        int needed = 1;
        for (List<Integer> callTimes1 : callsTimes) {
            for (List<Integer> callTimes2 : callsTimes) {
                if(callTimes1.get(1) <= callTimes2.get(0)) {
                    needed++;
                }
            }
        }

        if(needed - noOfCurrentAgents > 0) {
            additionals = needed - noOfCurrentAgents;
        }
        return additionals;
    }

    // Complete the howManyAgentsToAdd function below.
    static int howManyAgentsToAdd1(int noOfCurrentAgents, List<List<Integer>> callsTimes) {
        int additionals = 0;
        int needed = 1;

        for (int i = 0; i < callsTimes.size() - 1; i++) {
            List<Integer> callTimes = callsTimes.get(i);

            List<List<Integer>> lists = callsTimes.subList(i + 1, callsTimes.size());
            int overlaped = 0;
            for (List<Integer> times : lists) {
                if(callTimes.get(1) >= times.get(0) && callTimes.get(1) <= times.get(1)) {
                    overlaped++;
                }
            }
            needed += overlaped;

        }
        if(needed - noOfCurrentAgents > 0) {
            additionals = needed - noOfCurrentAgents;
        }
        return additionals;
    }
}
