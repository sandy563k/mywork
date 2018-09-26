package com.practice.array_string;

public class ZeroMatrix {

    public static void main(String [] args){
       int[][] a = new int[][]{{1,0,3},
                               {1,8,0},
                               {3,3,3}

       };
       printMatrix(a);
       zerMatrix(a);
       printMatrix(a);

    }

    public static void printMatrix(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j] +",");
            }
            System.out.println();
        }
    }

    public static int[][] zerMatrix(int[][] a){
        boolean[] row = new boolean[a.length];
        boolean[] col = new boolean[a[0].length];
        for(int i=0;i<row.length;i++){
            for(int j=0;j<col.length;j++){
                if(a[i][j]==0){
                    System.out.println("row:"+i+"col:"+j);
                    row[i]=true;
                    col[j]=true;
                }
            }
        }

        nullifyCol(col,a);
        nullifyRow(row,a);
        return a;
    }


    public static void nullifyRow(boolean[] row,int[][] a){
        for(int i=0;i<row.length;i++){
            if(row[i]){
                for(int j =0;j<a[0].length;j++){
                    a[i][j]=0;
                }
            }
        }
    }

    public static void nullifyCol(boolean[] col,int[][] a){
        for(int j=0;j<col.length;j++){
            if(col[j]){
                for(int i =0;i<a.length;i++){
                    a[i][j]=0;
                }

            }
        }

    }
}
