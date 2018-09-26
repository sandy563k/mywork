package com.princeton.week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {

    private final List<LineSegment> segments = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {

        // finds all line segments containing 4 points
        if (null == points) {
            throw new IllegalArgumentException();
        }

        if (points.length < 4) {
            return;
        }

        // check for null points
        for (int a = 0; a < points.length; a++) {
            if (null == points[a]) {
                throw new IllegalArgumentException();
            }
        }

        // Arrays.sort(points);
       // Point[] buffer = new Point[points.length];
        LinkedList<Point> collinear = new LinkedList<>();


        for (Point pivot : points) {
            System.out.print(pivot.toString()+":");
            Point[] buffer = Arrays.copyOf(points, points.length);
            System.out.println("buffer:"+printArray(buffer));
            Arrays.sort(buffer, pivot.slopeOrder());
            System.out.print("sortedbuffer:"+printArray(buffer));
            String sortedBuffer = printArray(buffer);
            int i = 0;
            double prevSlope = 0.0;
            double presentSlope=0.0;
            int repeatCount = 0;
            for (Point p : buffer) {
                i++;
                //System.out.print(p+",");
                if (repeatCount > 1) {
                    throw new IllegalArgumentException();
                }
               // System.out.println(pivot.slopeTo(p));
                presentSlope = pivot.slopeTo(p);
                if (presentSlope != prevSlope) {

                    // collinear.add(p);
                    if (collinear.size() >= 3) {
                        //System.out.println(collinear);
                        collinear.add(pivot);
                        Collections.sort(collinear);
                        System.out.println(collinear);
                        if (pivot == collinear.getFirst()) {
                            segments.add(new LineSegment(collinear.getFirst(), collinear.getLast()));
                        }

                    }
                    collinear.clear();

                }
                collinear.add(p);
                if (i == buffer.length && prevSlope == presentSlope) {

                    // collinear.add(p);
                    if (collinear.size() >= 3) {
                        //System.out.println(collinear);
                        collinear.add(pivot);
                        Collections.sort(collinear);
                        System.out.println(collinear);
                        if (pivot == collinear.getFirst()) {
                            segments.add(new LineSegment(collinear.getFirst(), collinear.getLast()));
                        }

                    }
                    collinear.clear();

                }
                prevSlope = presentSlope;

                if (prevSlope == Double.NEGATIVE_INFINITY) {
                    repeatCount++;
                }
            }
            System.out.println();
        }


    }

    /*public FastCollinearPoints(Point[] points) {

        // finds all line segments containing 4 points
        if (null == points) {
            throw new IllegalArgumentException();
        }

        if (points.length < 4) {
            return;
        }

        // check for null points
        for (int a = 0; a < points.length; a++) {
            if (null == points[a]) {
                throw new IllegalArgumentException();
            }
        }

        for (Point pivot : points) {
            Point[] copy = copy(points);

            Arrays.sort(copy, pivot.slopeOrder());

            int j = 0;
            double previous = 0.0;
            LinkedList<Point> collinear = new LinkedList<Point>();
            for(Point p : copy) {
                if (j == 0 || p.slopeTo(pivot) != previous) {
                    if (collinear.size() >= 3) {
                        collinear.add(pivot);
                        Collections.sort(collinear);
                        if (pivot == collinear.getFirst()) segments.add(new LineSegment(collinear.getFirst(), collinear.getLast()));;
                    }
                    collinear.clear();
                }
                collinear.add(p);

                previous = p.slopeTo(pivot);
                j++;
            }
        }



    }*/


    private static Point[] copy(Point[] points) {
        Point[] copy = new Point[points.length];
        for (int i = 0; i < points.length; i++) copy[i] = points[i];

        return copy;
    }

    public int numberOfSegments() {
        // the number of line segments
        return segments.size();

    }

    public LineSegment[] segments() {
        LineSegment[] lineSegments = new LineSegment[segments.size()];
        int i = 0;
        for (LineSegment seg : segments) {
            lineSegments[i++] = seg;
        }

        return lineSegments;

    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In("/Users/sandeepkothapally/Documents/code/mygitrepo/princetonsolutions/week3/collineartest/rs1423.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        System.out.println(collinear.numberOfSegments());
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    public String printArray(Point[] points){
        StringBuilder str = new StringBuilder();
        for(Point p: points){
           str.append(p);
        }
        return str.toString();
    }

}


