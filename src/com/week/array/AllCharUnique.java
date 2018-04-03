package com.week.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllCharUnique {
    public static void main(String[] args){
        try {
            while(true) {
                String result="unique";
                final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String text = br.readLine();
               int checker=0,val=0;

                for (int i = 0; i < text.length(); i++) {
                    val=text.charAt(i);
                    //if

                }
                System.out.println(result);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
