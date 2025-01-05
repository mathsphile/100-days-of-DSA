// You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

// Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

// Return the final string after all such shifts to s are applied.

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftArray = new int[n + 1];

        // Populate the shiftArray based on shifts
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            // Forward shift increments, backward shift decrements
            shiftArray[start] += (direction == 1) ? 1 : -1;
            shiftArray[end + 1] += (direction == 1) ? -1 : 1;
        }

        // Apply prefix sum to calculate the net shifts for each index
        int netShift = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            netShift += shiftArray[i];

            // Normalize the shift to avoid overflow (only 26 letters in the alphabet)
            int shiftValue = (netShift % 26 + 26) % 26;

            // Shift the character
            result[i] = (char) ('a' + (result[i] - 'a' + shiftValue) % 26);
        }

        return new String(result);
    }
}
