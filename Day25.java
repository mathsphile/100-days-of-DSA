// Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.
class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> uniquePermutations = new HashSet<>(); // To avoid duplicates
        char[] chars = s.toCharArray();
        generatePermutations(chars, 0, uniquePermutations);
        result.addAll(uniquePermutations);
        Collections.sort(result); // Sorting for a consistent order
        return result;
    }

    private void generatePermutations(char[] chars, int index, HashSet<String> uniquePermutations) {
        if (index == chars.length) {
            uniquePermutations.add(new String(chars)); // Add the current permutation
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index); // Swap characters
            generatePermutations(chars, index + 1, uniquePermutations); // Recurse
            swap(chars, i, index); // Backtrack
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
