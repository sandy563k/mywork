package com.princeton.week2;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Permutation {

    public static void main(String[] args) {

       // int k = Integer.valueOf(args[0]);
        int k =3;
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        // String[] inputs = StdIn.readAllStrings();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            randomizedQueue.enqueue(item);
        }
        for (int i = 0; i < k; i++)
            StdOut.println(randomizedQueue.dequeue());


    }
}