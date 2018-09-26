package com.princeton.week3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

    private final List<LineSegment> segments = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {
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
        double slope1, slope2, slope3;
        Point p, q, r, s;
        Arrays.sort(points);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int m = k + 1; m < points.length; m++) {
                        p = points[i];
                        q = points[j];
                        r = points[k];
                        s = points[m];
                        slope1 = p.slopeTo(q);
                        slope2 = q.slopeTo(r);
                        slope3 = r.slopeTo(s);

                        // check for repeated points
                        if (slope1 == Double.NEGATIVE_INFINITY || slope2 == Double.NEGATIVE_INFINITY || slope3 == Double.NEGATIVE_INFINITY) {
                            throw new IllegalArgumentException();
                        }

                        if (slope1 == slope2 && slope2 == slope3) {
                            segments.add(new LineSegment(p, s));
                        }

                    }
                }
            }
        }


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
        In in = new In(args[0]);
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}


