package com.practice.array_string;

import java.util.Arrays;
import java.util.Stack;

public class Check_Permutation {

    public static void main(String[] args) {

        String s1 = "1237376";
        //String s2 = "6737521";
        //System.out.println(checkPermutation(s1,s2));

        String s = "babdbab";



       /* String s2 = s.substring(1, s.length()) + s.substring(0, s.length() - 1);
        System.out.println("s.substring(1, s.length()):"+s.substring(1, s.length()));
        System.out.println("s.substring(0, s.length() - 1):"+s.substring(0, s.length() - 1));
        System.out.println("s2:"+s2);
        System.out.println("s2.indexOf(s) >= 0:"+(s2.indexOf(s) >= 0));*/

       System.out.println(s.indexOf('d'));
        System.out.println(s.indexOf("bd"));
        System.out.println(s.indexOf("ba",3));
        System.out.println(s.indexOf('b',3));
        System.out.println(isValid("{()}"));



    }


        public static boolean isValid(String s) {
            Stack<Character> stk = new Stack<>();
            for(int i = 0;i< s.length();i++){
                char c =s.charAt(i);
                System.out.println("c:"+c);
                switch(c){
                    case ')':
                        if(stk.isEmpty() || stk.pop() != '(')
                            return false;
                        break;
                    case ']':
                        if(stk.isEmpty() || stk.pop() != '[')
                            return false;
                        break;
                    case '}':
                        if(stk.isEmpty() || stk.pop() != '{')
                            return false;
                        break;
                    default:
                        stk.push(s.charAt(i));
                        break;
                }

            }

            return stk.isEmpty();

        }


    public static boolean checkPermutation(String s1, String s2) {

        boolean result = false;
        if(s1.length() != s2.length()){
            return result;
        }
        char [] a1 = new char[256];
        char [] a2 = new char[256];
        for (int i =0 ;i< s1.length();i++) {
            a1[s1.charAt(i)]++;
        }

        for (int j =0 ;j< s1.length();j++) {
            a2[s2.charAt(j)]++;
        }


        return Arrays.equals(a1,a2);
    }
}
