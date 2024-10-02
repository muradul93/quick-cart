package com.murad.quickcart.random;

import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;

            }

            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;

    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        String s = "abcabcbb";
//        String s = "dvdf";
        System.out.println(solution.lengthOfLongestSubstring(s));  // Output: 3
    }
}