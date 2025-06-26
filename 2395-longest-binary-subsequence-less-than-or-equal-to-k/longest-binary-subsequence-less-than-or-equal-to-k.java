class Solution {
    public int longestSubsequence(String s, int k) {
        int longestLength = 0; // Tracks the length of the subsequence
        int decimalValue = 0;  // Tracks the current decimal value of the subsequence

        // Iterate from right to left (least significant to most significant bit)
        for (int index = s.length() - 1; index >= 0; --index) {
            if (s.charAt(index) == '0') {
                // Always include zeros
                ++longestLength;
            } else if (longestLength < 30 && (decimalValue | (1 << longestLength)) <= k) {
                // Include '1' if it doesn't exceed k and length is safe (to avoid overflow)
                decimalValue |= 1 << longestLength;
                ++longestLength;
            }
            // Skip '1' if including it would exceed k or if length >= 30 (to prevent overflow)
        }
        return longestLength;
    }
}
