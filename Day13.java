// Given an array of integers arr[], the task is to find the first equilibrium point in the array.

// The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements before that index is the same as the sum of elements after it. Return -1 if no such point exists. 
class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int totalSum = 0, leftSum = 0;

        // Calculate the total sum of the array.
        for (int num : arr) {
            totalSum += num;
        }

        // Traverse the array to find the equilibrium point.
        for (int i = 0; i < arr.length; i++) {
            // Subtract the current element from totalSum to get the right sum.
            totalSum -= arr[i];

            // Check if leftSum is equal to the remaining totalSum (right sum).
            if (leftSum == totalSum) {
                return i; // Return the index of the equilibrium point.
            }

            // Update leftSum to include the current element.
            leftSum += arr[i];
        }

        // If no equilibrium point is found, return -1.
        return -1;
    }
}
