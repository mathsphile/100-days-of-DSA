// You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
// Note: pairs should have elements of distinct indexes. 
class Solution {

    int countPairs(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                if (arr[left] == arr[right]) {
                    // If both elements are the same, count all combinations
                    int occurrences = right - left + 1;
                    count += (occurrences * (occurrences - 1)) / 2;
                    break;
                } else {
                    // Count pairs between arr[left] and arr[right]
                    int leftCount = 1, rightCount = 1;

                    // Count duplicates on the left side
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        left++;
                        leftCount++;
                    }

                    // Count duplicates on the right side
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        right--;
                        rightCount++;
                    }

                    // Add all combinations of leftCount and rightCount
                    count += leftCount * rightCount;

                    // Move pointers inward
                    left++;
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
