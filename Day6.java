// Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
// Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.
import java.util.*;

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr); // Sort the array
        List<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int complement = target - arr[i];
            int closest = findClosest(arr, i + 1, n - 1, complement);

            int currDiff = Math.abs(target - (arr[i] + closest));

            if (currDiff < minDiff) {
                // Update result when a closer pair is found
                minDiff = currDiff;
                res = Arrays.asList(arr[i], closest);
            } else if (currDiff == minDiff) {
                // Tie-breaking: choose pair with maximum absolute difference
                int prevDiff = Math.abs(res.get(1) - res.get(0));
                int newDiff = Math.abs(closest - arr[i]);
                if (newDiff > prevDiff) {
                    res = Arrays.asList(arr[i], closest);
                }
            }
        }

        return res.isEmpty() ? Arrays.asList() : res; // Return empty list if no valid pair
    }

    private int findClosest(int[] arr, int start, int end, int target) {
        int closest = arr[start];
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (Math.abs(arr[mid] - target) < Math.abs(closest - target)) {
                closest = arr[mid];
            } else if (Math.abs(arr[mid] - target) == Math.abs(closest - target)) {
                // Tie-breaking: choose the larger value
                closest = Math.max(closest, arr[mid]);
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return arr[mid]; // Exact match
            }
        }
        return closest;
    }
}
