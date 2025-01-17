// Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
// Note: Each element is res[] lies inside the 32-bit integer range.
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];

        // Initialize the product variable to 1
        int product = 1;

        // Calculate left product for each element and store it in res
        for (int i = 0; i < n; i++) {
            res[i] = product;
            product *= arr[i];
        }

        // Reset product variable to 1
        product = 1;

        // Calculate right product for each element and multiply with the left product
        // in res
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= product;
            product *= arr[i];
        }

        return res;
    }
}
