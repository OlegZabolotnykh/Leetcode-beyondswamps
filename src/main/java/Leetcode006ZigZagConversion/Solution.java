package main.java.Leetcode006ZigZagConversion;

public class Solution {
    public static void main(String[] args) {
        String result = new Solution().convert("AB", 1);

    }

    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) return s;
        int constant1 = 2 * numRows - 2;
        int constant2 = numRows - 1;
        int n = s.length();
        int numCols = n % constant1 > constant2
                ? (n - (n / constant1 + 1) * constant2)
                : (n / constant1 * constant2 + 1);
        char[][] table = new char[numRows][numCols];

        for (int i = 0; i < n; i++) {
            if (i % constant1 > constant2) {
                table[constant1 - i % constant1][i - (i / constant1 + 1) * constant2] = s.charAt(i);
            } else {
                table[i % constant1][i / constant1 * constant2] = s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (table[row][col] != 0) {
                    sb.append(table[row][col]);
                }
            }
        }
        return sb.toString();
    }
}
