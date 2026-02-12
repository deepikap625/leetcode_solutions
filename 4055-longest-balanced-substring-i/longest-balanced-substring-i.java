class Solution {
    public int longestBalanced(String s) {

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {

                int c = s.charAt(j) - 'a';
                freq[c]++;

                if (freq[c] == 1) distinct++;
                maxFreq = Math.max(maxFreq, freq[c]);

                int len = j - i + 1;

                if (len == distinct * maxFreq)
                    ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
