package com.murad.quickcart.random;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        // HashMap to store the frequency of prefix sums
        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1); // To handle subarrays that start from index 0
        
        int currentSum = 0;
        int count = 0;

        // Traverse through the array
        for (int num : nums) {
            currentSum += num; // Update the running sum

            // Check if (currentSum - k) exists in the map
            if (sumFreq.containsKey(currentSum - k)) {
                count += sumFreq.get(currentSum - k); // Add the number of occurrences
            }

            // Update the map with the current sum's frequency
            sumFreq.put(currentSum, sumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        
        int[] nums1 = {1, 1, 2,2,1,1,3,4};
        int k1 = 4;
        System.out.println(solution.subarraySum(nums1, k1));  // Output: 2
//
//        int[] nums2 = {1, 2, 3};
//        int k2 = 3;
//        System.out.println(solution.subarraySum(nums2, k2));  // Output: 2
    }
}
