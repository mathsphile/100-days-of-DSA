// Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. 

// A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.
import java.util.Arrays;

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // Sort the array to facilitate the two-pointer approach.
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;

        // Fix the third side of the triangle (largest side of the current triangle).
        for (int i = n - 1; i >= 2; i--) {
            int left = 0; // Pointer for the smallest side
            int right = i - 1; // Pointer for the middle side

            while (left < right) {
                // If the sum of the two smaller sides is greater than the largest side,
                // all pairs between left and right form valid triangles.
                if (arr[left] + arr[right] > arr[i]) {
                    count += (right - left);
                    right--; // Move the right pointer to the left
                } else {
                    left++; // Move the left pointer to the right
                }
            }
        }
        return count;
    }
}
