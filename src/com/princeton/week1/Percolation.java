package com.princeton.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private boolean[][] grid;
    private int gridSideLength;
    private int totalBlocks;
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private int noOpenSites;


    public Percolation(int n) {
        // create n-b
        // y-n grid, with all sites blocked
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        grid = new boolean[n][n];
        gridSideLength = n;
        totalBlocks = n * n;
        weightedQuickUnionUF = new WeightedQuickUnionUF(totalBlocks);
        noOpenSites = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }

        }
    }

    public void open(int row, int col) {
        // open site (row, col) if it is not open already
        if (row <= 0 || col <= 0 || row > gridSideLength || col > gridSideLength) {
            throw new IllegalArgumentException();
        }
        int p = row - 1;
        int q = col - 1;
        if (grid[p][q]) {
            return;
        }
        grid[p][q] = true;
        noOpenSites++;

        //if top block open , perform union
        if ((p - 1 >= 0) && isOpen(row - 1, col)) {
            weightedQuickUnionUF.union(gridSideLength * (p - 1) + q, gridSideLength * (p) + q);
        }

        //if bottom block open , perform union
        if ((p + 1 <= gridSideLength - 1) && isOpen(row + 1, col)) {
            weightedQuickUnionUF.union(gridSideLength * (p + 1) + q, gridSideLength * (p) + q);
        }

        //if left block open , perform union
        if ((q - 1 >= 0) && isOpen(row, col - 1)) {
            weightedQuickUnionUF.union(gridSideLength * p + (q - 1), gridSideLength * (p) + q);
        }

        //if right block open , perform union
        if ((q + 1 <= gridSideLength - 1) && isOpen(row, col + 1)) {
            weightedQuickUnionUF.union(gridSideLength * p + (q + 1), gridSideLength * (p) + q);
        }


    }

    public boolean isOpen(int row, int col) {
        if (row <= 0 || col <= 0 || row > gridSideLength || col > gridSideLength) {
            throw new IllegalArgumentException();
        }
        // is site (row, col) open?
        return grid[row - 1][col - 1] == true;
    }

    public boolean isFull(int row, int col) {
        if (row <= 0 || col <= 0 || row > gridSideLength || col > gridSideLength) {
            throw new IllegalArgumentException();
        }
        // is site (row, col) full?
        return grid[row - 1][col - 1] == false;
    }

    public int numberOfOpenSites() {
        // number of open sites

        return this.noOpenSites;
    }


    public boolean percolates() {
        // does the system percolate?
        for (int col1 = 0; col1 < gridSideLength; col1++) {
            for (int col2 = 0; col2 < gridSideLength; col2++) {
                if (weightedQuickUnionUF.connected(col1, (gridSideLength * (gridSideLength - 1)) + col2)) {
                    return true;
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        // test client (optional)
        System.out.println("Percolation class main");
    }
}