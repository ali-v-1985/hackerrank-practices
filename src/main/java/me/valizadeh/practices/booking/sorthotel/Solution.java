package me.valizadeh.practices.booking.sorthotel;

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

    // Complete the sort_hotels function below.
    static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {

        String[] keywordsArr = keywords.split(" ");
        List<Integer> hotelMentionedList = new ArrayList<>();;
        for (int j = 0; j < hotel_ids.size(); j++) {
            String review = reviews.get(j);
            int hotelMentioned = 0;
            for (int i = 0; i < keywordsArr.length; i++) {
                String keyword = keywordsArr[i];

                if(review.contains(keyword)) {
                    hotelMentioned++;
                }
            }
            hotelMentionedList.add(hotelMentioned);

        }

    }
}
}
