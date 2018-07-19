package me.valizadeh.practices.flowtrades.innerclass;

/**
 * Created by valizadeh on 05/07/2018.
 */
public final class Test4 {

    class Inner {
        void test() {
            if(Test4.this.flag) {
                sample();
            }
        }
    }
    private boolean flag = true;
    public void sample() {
        System.out.println("Sample");
    }
    public Test4() {
        (new Inner()).test();
    }

    static int x = 0;

    public static void test() {
        for (int i = 0; i < 10000000; i++) {
            x = x + 1;

        }
    }
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        System.out.println(x);

    }
}
