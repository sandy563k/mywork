/*
package com.princetonAlgos2.week1;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;

import java.util.Map;

public class WordNet {

    private Map<String, Integer> wordToId;
    Digraph digraph;


    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        In synsetsInput = new In(synsets);
        In hypernymsInput = new In(hypernyms);
        int vertexCount = 0;
        while (synsetsInput.hasNextLine()) {
            String line = synsetsInput.readLine();
            String[] commasepToken = line.split(",");
            int id = Integer.valueOf(commasepToken[0]);
            String[] words = commasepToken[1].split("\\\\s+");
            for (int i = 0; i < words.length; i++) {
                wordToId.put(words[i], id);
            }
            vertexCount++;

        }

        digraph = new Digraph(vertexCount);
        while (hypernymsInput.hasNextLine()) {
            String[] vertices = hypernymsInput.readLine().split(",");
            int source = Integer.valueOf(vertices[0]);
            for (int j = 1; j < vertices.length; j++) {
                digraph.addEdge(source, Integer.valueOf(vertices[j]));
            }
        }










    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return wordToId.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return wordToId.containsKey(word);

    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (wordToId.containsKey(nounA) && wordToId.containsKey(nounB)) {
            int a = wordToId.get(nounA);
            int b = wordToId.get(nounB);







        } else {
            throw new IllegalArgumentException();
        }

    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (wordToId.containsKey(nounA) && wordToId.containsKey(nounB)) {
            int a = wordToId.get(nounA);
            int b = wordToId.get(nounB);






        } else {
            throw new IllegalArgumentException();
        }
    }

    // do unit testing of this class
    public static void main(String[] args) {

    }
}*/
