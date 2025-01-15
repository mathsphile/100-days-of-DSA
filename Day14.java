// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.
class Solution {
    public int longestSubarray(int[] arr, int k) {
        // HashMap to store the prefix sum and its earliest occurrence index
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int maxLength = 0; // To store the length of the longest subarray
        int currentSum = 0; // To store the running sum of elements

        for (int i = 0; i < arr.length; i++) {
            // Add the current element to the running sum
            currentSum += arr[i];

            // Check if the current sum is equal to k
            if (currentSum == k) {
                maxLength = i + 1;
            }

            // If currentSum - k exists in the map, it means a subarray with sum k exists
            if (prefixSumMap.containsKey(currentSum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(currentSum - k));
            }

            // Store the current sum in the map if it is not already present
            if (!prefixSumMap.containsKey(currentSum)) {
                prefixSumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }
}
