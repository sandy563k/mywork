package com.practice.leetcode;

public class FlipImage {

    public static void main(String[] args){
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};

        new Solution().flipAndInvertImage(A);
    }
}

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        System.out.println("C:"+C);
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                System.out.println("tmp:"+tmp);

                row[i] = row[C - 1 - i] ^ 1;
                System.out.println("row[i]:"+row[i]);
                row[C - 1 - i] = tmp;
            }

        return A;
    }
}