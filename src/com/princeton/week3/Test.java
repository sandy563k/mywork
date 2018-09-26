package com.princeton.week3;

import java.util.Arrays;

public class Test {

    public static void main(String[] args){

        /*Point p1 = new Point(5, 2);
        Point p2 = new Point(4, 12);
        Point p3 = new Point(7, 12);
        Point p4 = new Point(5, 12);
        Point point = new Point(0, 0);
        Point[] points = new Point[5];
        points[0] = p3;
        points[1] = point;
        points[2] = p2;
        points[3] = p4;
        points[4] = p1;
        Arrays.sort(points);
        for(Point p: points){
            System.out.println(p.toString());
        }*/

        for(int i=0; i< 5 ;i++)
            for(int j=i+1;j< 5;j++)
                System.out.println(i+ "  "+j);



    }
}
