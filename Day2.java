// Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

class Solution {
    public int countSubarrays(int arr[], int k) {
        // Initialize a HashMap to store the prefix sum and its frequency
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int currentSum = 0;
        int count = 0;

        // Add the base case: a prefix sum of 0 has occurred once
        prefixSumCount.put(0, 1);

        // Iterate through the array
        for (int num : arr) {
            // Update the current prefix sum
            currentSum += num;

            // Check if there's a prefix sum that can form a subarray with sum k
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update the frequency of the current prefix sum in the map
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
