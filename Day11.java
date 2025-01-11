// Given a string s, find the length of the longest substring with all distinct characters. 
class Solution {
    public int longestUniqueSubstr(String s) {
        // Use fully qualified names for the Set and HashSet
        java.util.Set<Character> set = new java.util.HashSet<>();

        int maxLength = 0; // To store the maximum length of the substring
        int left = 0; // Left pointer for the sliding window

        // Iterate through the string using a right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the set, shrink the window
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(currentChar);

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
