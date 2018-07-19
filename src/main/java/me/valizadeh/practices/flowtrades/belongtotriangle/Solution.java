package me.valizadeh.practices.flowtrades.belongtotriangle;

/**
 * Created by valizadeh on 05/07/2018.
 */
public class Solution {

    static int pointsBelongToTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int p1, int q1, int p2, int q2) {

        if((x1==x2 && x2 == x3) || (y1==y2 && y2 == y3))
            return 0;
        else {
            boolean pInTri = isInTri(x1, y1, x2, y2, x3, y3, p1, q1);
            boolean qInTri = isInTri(x1, y1, x2, y2, x3, y3, p2, q2);
            if(pInTri && !qInTri) {
                return 1;
            } else if (!pInTri && qInTri) {
                return 2;
            } else if(pInTri && qInTri) {
                return 3;
            } else {
                return 4;
            }
        }
    }

    private static boolean isInTri(int ax, int ay, int bx, int by, int cx, int cy, int px, int py) {
        return area(ax, ay, bx, by, cx, cy) == area(px,py, ax, ay, bx, by) + area(px,py, ax,ay,cx,cy) + area(px,py,bx, by, cx, cy);
    }

    private static float area(int ax, int ay, int bx, int by, int cx, int cy) {
        return Math.abs((ax*(by-cy) + bx * (cy-ay) + cx * (ay -by))/2);
    }

    public static void main(String[] args) {
        System.out.println(pointsBelongToTriangle(0,0,2,0,4,0,2,0,4,0));
        System.out.println(pointsBelongToTriangle(3,1,7,1,5,5,3,1,0,0));
        System.out.println(pointsBelongToTriangle(3,1,7,1,5,5,1,1,4,3));
        System.out.println(pointsBelongToTriangle(3,1,7,1,5,5,5,2,6,3));
        System.out.println(pointsBelongToTriangle(3,1,7,1,5,5,1,1,2,2));
    }
}
