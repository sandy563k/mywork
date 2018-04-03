package com.week.trees;

import java.util.ArrayList;
import java.util.List;

public class Tries {

    public static void main(String[] args) {
        final List<String> setOfStrings = new ArrayList<>();
        setOfStrings.add("pqrs");
        setOfStrings.add("pprt");
        setOfStrings.add("psst");
        setOfStrings.add("qqrs");
        setOfStrings.add("pqrs");

        final Trie trie = new Trie();
        setOfStrings.forEach(trie::insert);
        System.out.println(trie.query("psst"));
        trie.update("qqrs", "psst");
        System.out.println(trie.query("qqrs"));
        System.out.println(trie.query("psst"));
    }
}

class Trie {
    final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public int query(String s) {
        TrieNode current = root.next(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (current == null) {
                return 0;
            }

            current = current.next(s.charAt(i));

        }
        return current.terminating;
    }

    public void insert(String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if (null == current.trieNodes[s.charAt(i) - 'a']) {
                current.trieNodes[s.charAt(i) - 'a'] = new TrieNode();
            }

            current = current.next(s.charAt(i));
        }
        current.terminating++;
    }


    public void delete(final String s) {
        TrieNode current = root;
        for (int i = 0; i < s.length(); i++) {
            if (current == null) {
                throw new RuntimeException();
            }
            current = current.next(s.charAt(i));
        }
        if (current.terminating != 0) {
            current.terminating--;
        } else {
            throw new RuntimeException();
        }

    }

    public void update(final String old, final String newString) {
        delete(old);
        insert(newString);
    }
}


class TrieNode {
    int terminating;
    final TrieNode[] trieNodes = new TrieNode[26];

    public TrieNode next(final char c) {
        return trieNodes[c - 'a'];
    }
}


