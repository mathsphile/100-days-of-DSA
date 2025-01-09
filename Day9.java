// Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.

// Note: If no such array is possible then, return [-1].
class Solution {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        Trie trie = new Trie();

        // Add all words to trie
        for (String word : words) {
            trie.addWord(word);
        }
        return trie.countPrefix(pref);
    }

    private class Trie {

        // Node class represents each character in Trie
        class Node {

            // Links to child nodes
            Node[] links;
            // Number of strings having prefix till this node
            int count;

            Node() {
                // For lowercase English letters
                links = new Node[26];
                count = 0;
            }
        }

        Node root;

        Trie() {
            root = new Node();
        }

        // Add word to trie and update prefix counts
        public void addWord(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.links[c - 'a'] == null) {
                    curr.links[c - 'a'] = new Node();
                }
                curr = curr.links[c - 'a'];
                curr.count++; // Increment count for this prefix
            }
        }

        // Return count of strings having pref as prefix
        public int countPrefix(String pref) {
            Node curr = root;
            for (int i = 0; i < pref.length(); i++) {
                char c = pref.charAt(i);
                if (curr.links[c - 'a'] == null) {
                    return 0; // Prefix not found
                }
                curr = curr.links[c - 'a'];
            }
            return curr.count; // Return count at last node
        }
    }
}