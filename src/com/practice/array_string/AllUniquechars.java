package com.practice.array_string;


public class AllUniquechars {

    public static  boolean allUnique(String s){
        if(s==null || "".equals(s)){
             return false;
        }
        int check = 0 ;

        for(int i=0;i<s.length();i++){
            int position = s.charAt(i)-'a';

            if((check & (1 << position)) > 0){
                return false;
            }else{
             check = check | 1 << position;
            }
        }

        return  true;

    }

    public static void main(String[] args){
        System.out.println(allUnique("abcdsefg"));
    }

}
