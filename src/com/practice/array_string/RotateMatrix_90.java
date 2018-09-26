package com.practice.array_string;

public class RotateMatrix_90 {

    public static void main(String[] args){
        int [][]A = new int[][]{ {1,2,3},
                                 {4,5,6},
                                 {7,8,9}  };

        rotateMatrix(A);
    }

    //A(i,j) moves to A(j,maxl-i)

    public static boolean rotateMatrix(int[][] matrix){
        if(matrix.length==0||matrix.length!=matrix[0].length) return false;
        int n = matrix.length;
        for(int layer =0;layer <n/2;layer++){
            int first = layer;
            int last = n-1-layer;
        }


return false;
    }
}
