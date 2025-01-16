// public Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s. 
class Solution {
    public int maxLen(int[] arr) {
        // HashMap to store prefix sum and its first occurrence index
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0; // To store the maximum length of subarray
        int prefixSum = 0; // To calculate prefix sum

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Replace 0 with -1 to handle the equal number of 0s and 1s
            if (arr[i] == 0) {
                prefixSum += -1;
            } else {
                prefixSum += 1;
            }

            // If prefixSum is 0, we found a subarray from the start to index `i`
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            // If this prefixSum has been seen before
            if (map.containsKey(prefixSum)) {
                // Update the maxLength
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            } else {
                // Store the first occurrence of this prefixSum
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
    

