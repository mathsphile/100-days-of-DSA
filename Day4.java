// Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.
class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        // Iterate through each element as the first element of the triplet
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1; // Start pointer for the second element
            int k = n - 1; // End pointer for the third element

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == target) {
                    // If sum matches, count all combinations of duplicate values
                    if (arr[j] == arr[k]) {
                        int num = k - j + 1; // Number of identical elements
                        count += (num * (num - 1)) / 2; // Choose 2 out of num elements
                        break; // Move on to the next `i`
                    } else {
                        int leftCount = 1, rightCount = 1;

                        // Count duplicates for arr[j]
                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            leftCount++;
                            j++;
                        }

                        // Count duplicates for arr[k]
                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            rightCount++;
                            k--;
                        }

                        // Add the combinations of duplicates to the total count
                        count += leftCount * rightCount;

                        // Move both pointers
                        j++;
                        k--;
                    }
                } else if (sum < target) {
                    j++; // Move the second pointer to increase the sum
                } else {
                    k--; // Move the third pointer to decrease the sum
                }
            }
        }

        return count;
    }
}
