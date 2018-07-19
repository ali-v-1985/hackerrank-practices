package me.valizadeh.practices.supahands.deduplicationchallenge;

import org.apache.commons.lang3.time.StopWatch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by valizadeh on 19/07/2018.
 */
public class Solution1 {

    public static void main(String args[]) throws Exception {
        Set<String> uniquePhoneNumbers = new HashSet<>();

//        Scanner in = new Scanner(System.in);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Scanner in = new Scanner(new FileInputStream(new File(Solution1.class.getClassLoader().getResource("testdatas/supahands/deduplicationchallenge/testData1.txt").toURI())));
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:\\source\\hackerrank-practices\\src\\main\\resources\\testdatas\\supahands\\deduplicationchallenge\\testResult1.txt"))));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int countOfPhoneNumbers = in.nextInt();
        while (countOfPhoneNumbers-- > 0) {
            String phoneNumber = in.nextLine();
            if (!uniquePhoneNumbers.contains(phoneNumber)) {
                uniquePhoneNumbers.add(phoneNumber);
                out.write(phoneNumber);
                out.newLine();
            }
        }
        stopWatch.stop();
        long time = stopWatch.getTime();
        String formattedTime = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(time),
                TimeUnit.MILLISECONDS.toMinutes(time) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)), // The change is in this line
                TimeUnit.MILLISECONDS.toSeconds(time) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time)));
        out.write(formattedTime);
        out.newLine();
        out.close();

    }
}
