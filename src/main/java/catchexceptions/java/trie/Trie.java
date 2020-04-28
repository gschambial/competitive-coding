/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package catchexceptions.java.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0, 17-Aug-2018
 * @author gschambial
 */
public class Trie {

    private class TrieNode {

        private Map<Character, TrieNode> children;
        private boolean                  endOfWord;

        TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void testOperations() {
        System.out.println("Inserting best");
        insertTrie(root, "best");
        System.out.println("Inserting rest");
        insertTrie(root, "rest");
        System.out.println("Inserting load");
        insertTrie(root, "load");
        System.out.println("Finding best: " + searchTrie(root, "best"));
        System.out.println("Finding rest: " + searchTrie(root, "rest"));
        System.out.println("Finding load: " + searchTrie(root, "load"));
        System.out.println("Deleting best");
        deleteTrie(root, "best");
        System.out.println("Finding best: " + searchTrie(root, "best"));
    }

    public void insertTrie(TrieNode current, String word) {
        insertRecursiveTrie(current, word, 0);
    }

    public void insertRecursiveTrie(TrieNode current, String word, int index) {
        if (word.length() == index) {
            current.endOfWord = true;
            return;
        }
        Character ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        TrieNode nextNode = null;
        if (null == node) {
            nextNode = new TrieNode();
            current.children.put(ch, nextNode);
        } else {
            nextNode = node;
        }
        insertRecursiveTrie(nextNode, word, index + 1);
    }

    public boolean searchTrie(TrieNode current, String word) {
        return searchRecursiveTrie(current, word, 0);
    }

    public boolean searchRecursiveTrie(TrieNode current, String word, int index) {
        if (word.length() == index) {
            if (current.endOfWord) {
                return true;
            }
            return false;
        }
        Character ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        TrieNode nextNode = null;
        if (null == node) {
            return false;
        } else {
            nextNode = node;
        }
        return searchRecursiveTrie(nextNode, word, index + 1);
    }
    
    public void deleteTrie(TrieNode current, String word) {
        deleteRecursiveTrie(current, word, 0);
    }

    public boolean deleteRecursiveTrie(TrieNode current, String word, int index) {
        if (word.length() == index) {
            if(!current.endOfWord) {
                return false;
            }
            current.endOfWord = false;
            return current.children.size() == 0;
        }
        Character ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        TrieNode nextNode = null;
        if (null == node) {
            return false;
        } else {
            nextNode = node;
        }
        boolean shouldDelete = deleteRecursiveTrie(nextNode, word, index+1);
        if(shouldDelete) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }
    
    public static void main(String []args) {
        Trie trie = new Trie();
        trie.testOperations();
    }

}
