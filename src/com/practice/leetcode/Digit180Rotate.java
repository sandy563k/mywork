/*
package com.practice.leetcode;

public class Digit180Rotate {


}

class Solution {
    public int rotatedDigits(int N) {
        int[] a = new int[N];
        int x,y;
        int count = 0;
        for (int i = 1;i<= N;i++){
            if(i<10){
                if(i==2 || i==5 || i==6 || i==9){
                    a[i] = 2;
                    count++;
                }else if(i==1 ||i==8){
                    a[i] = 1;
                }
            }else{

                x=a[i/10] ;
                y=a[i%10];

                if(x == 2 && y==1){
                    a[i]=2;
                    count++;
                }else if(x==2 && y==2){
                    a[i]=2;
                    count++;
                }else if(x==1 && y==2){
                    a[i]=2;
                    count++;
                }else if(x==1 && y==1){
                    a[i]=1;
                }

            }
        }
        return count;
    }
}*/
