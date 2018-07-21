package me.valizadeh.practices.transferwize.romanizer;

/**
 * @author valizadeh
 */
public class Solution {

    private static char[] signs = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private static int[] steps = {1, 5, 10, 50, 100, 500, 1000};

    private static String romanize(int number) {
        StringBuilder romanizeStr = new StringBuilder();
        if(number == 0) {
            return "";
        }
        for (int i = 0; i < steps.length; i++) {
            if (number == steps[i]) {
                romanizeStr.append(signs[i]);
                break;
            } else if (number > steps[i]) {
                continue;
            } else {
                if (i % 2 == 0 && i >= 2) {//Number which are
                    if ((steps[i] - number) <= steps[i - 2]) {
                        romanizeStr.append(signs[i - 2])
                                .append(signs[i])
                                .append(romanize(number - (steps[i] - steps[i - 2])));
                    } else {
                        romanizeStr.append(signs[i - 1]).append(romanize(number - steps[i - 1]));
                    }
                } else {
                    if ((steps[i] - number) <= steps[i - 1]) {
                        romanizeStr.append(signs[i - 1])
                                .append(signs[i])
                                .append(romanize(number - (steps[i] - steps[i - 1])));
                    } else {
                        romanizeStr.append(signs[i - 1]).append(romanize(number - steps[i - 1]));
                    }
                }
                break;
            }


        }
        return romanizeStr.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            if ((i - 1) % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + " : " + romanize(i) + "\t");


        }
    }
}
