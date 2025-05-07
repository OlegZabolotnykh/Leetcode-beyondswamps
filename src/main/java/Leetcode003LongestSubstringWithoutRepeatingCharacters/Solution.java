package main.java.Leetcode003LongestSubstringWithoutRepeatingCharacters;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] chars = new int[95];
        int count = 0;
        int maxLength = 0;

        for (int i = 0, j = 0;j < n; j++) {
            if (chars[s.charAt(j) - 32] != 0) {
                i = Math.max(chars[s.charAt(j) - 32], i);
                chars[s.charAt(j) - 32] = j + 1;
                count = j - i + 1;
            } else {
                chars[s.charAt(j) - 32] = j + 1;
                count++;
            }
            maxLength = Math.max(count, maxLength);
        }
        return maxLength;
    }
}
