package me.valizadeh.practices.supahands.deduplicationchallenge;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Random;

/**
 * Created by valizadeh on 19/07/2018.
 */
public class CreateTestData {


    public static void main(String[] args) throws IOException, URISyntaxException {
        int count = 1_000_000;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(Solution1.class.getClassLoader().getResource("testdatas/supahands/deduplicationchallenge/testData.txt").toURI()))));
        bw.write(count);
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String id = String.format("%04d", random.nextInt(10000));
            bw.newLine();
            bw.write(id);
        }
        bw.close();
    }

}
