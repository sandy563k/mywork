package com.princeton.week1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import com.princeton.week1.Percolation;

public class PercolationStats {
    private int n;
    private int trials;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.trials = trials;
        // perform trials independent experiments on an n-by-n grid
    }

    public double mean(double[] p) {
        // sample mean of percolation threshold

        return StdStats.mean(p);
    }

    public double stddev(double[] p) {
        // sample standard deviation of percolation threshold
        return StdStats.stddev(p);
    }

    public double confidenceLo(double[] p) {
        if (p.length == 0) {
            throw new IllegalArgumentException();
        }
        // low  endpoint of 95% confidence interval
        double mean = mean(p);
        double stdDev = stddev(p);
        // formula is   mean - (Z* stdDev /square root of array size)
        // Z for 95 % confidence interval is  1.96

        return (mean - ((1.96) * stdDev / Math.sqrt(p.length)));
    }

    public double confidenceHi(double[] p) {
        if (p.length == 0) {
            throw new IllegalArgumentException();
        }
        // high  endpoint of 95% confidence interval
        double mean = mean(p);
        double stdDev = stddev(p);
        // formula is   mean + (Z* stdDev /square root of array size)
        // Z for 95 % confidence interval is  1.96

        return (mean + ((1.96) * stdDev / Math.sqrt(p.length)));
    }


    public static void main(String[] args) {
        // test client (described below)
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        double totalblocks = n * n;
        PercolationStats percolationStats = new PercolationStats(n, T);
        double[] probabilityArray = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int randomNum = StdRandom.uniform(0, n * n);
                percolation.open(randomNum / n + 1, randomNum % n + 1);
            }

            double prob = percolation.numberOfOpenSites() / totalblocks;
            probabilityArray[i] = prob;
        }

        double mean = percolationStats.mean(probabilityArray);
        double stdDev = percolationStats.stddev(probabilityArray);
        double confidenceLo = percolationStats.confidenceLo(probabilityArray);
        double confidenceHigh = percolationStats.confidenceHi(probabilityArray);
        System.out.println("mean                    = " + mean);
        System.out.println("stdDev                  = " + stdDev);
        System.out.println("95% confidence interval = [ " + confidenceLo + " , " + confidenceHigh + " ]");

    }
}