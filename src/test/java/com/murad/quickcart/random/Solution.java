package com.murad.quickcart.random;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Fill the answer array with products of elements to the left of each index
        answer[0] = 1;  // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate right products and update the answer array
        int rightProduct = 1;  // There are no elements to the right of the last element
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;  // Combine left and right products
            rightProduct *= nums[i];  // Update rightProduct for the next element
        }

        return answer;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}


