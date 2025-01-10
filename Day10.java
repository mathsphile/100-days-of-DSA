// Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int distinctCount = 0;

        // Initialize the first window
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) == 1) {
                distinctCount++;
            }
        }
        result.add(distinctCount);

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Remove the element going out of the window
            int outgoingElement = arr[i - k];
            map.put(outgoingElement, map.get(outgoingElement) - 1);
            if (map.get(outgoingElement) == 0) {
                distinctCount--;
                map.remove(outgoingElement);
            }

            // Add the new element coming into the window
            int incomingElement = arr[i];
            map.put(incomingElement, map.getOrDefault(incomingElement, 0) + 1);
            if (map.get(incomingElement) == 1) {
                distinctCount++;
            }

            result.add(distinctCount);
        }

        return result;
    }
}
