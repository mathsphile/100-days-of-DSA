// Given an array arr[] of non-negative integers, where each element arr[i] represents the height of the vertical lines, find the maximum amount of water that can be contained between any two lines, together with the x-axis.

// Note: In the case of a single vertical line it will not be able to hold water.
class Solution {

    public int maxWater(int arr[]) {
        int left = 0, right = arr.length - 1; // Initialize two pointers
        int maxArea = 0; // To store the maximum area

        while (left < right) {
            // Calculate the area formed by the lines at `left` and `right`
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = height * width;

            // Update the maximum area if the current area is larger
            maxArea = Math.max(maxArea, area);

            // Move the pointer corresponding to the shorter line
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; // Return the maximum area found
    }
}
