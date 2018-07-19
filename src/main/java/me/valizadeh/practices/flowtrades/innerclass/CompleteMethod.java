package me.valizadeh.practices.flowtrades.innerclass;

import java.io.IOException;

/**
 * Created by valizadeh on 05/07/2018.
 */
public class CompleteMethod {

    static int err() throws Exception {
        try {
            throw new IOException("");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(err());
    }
}
