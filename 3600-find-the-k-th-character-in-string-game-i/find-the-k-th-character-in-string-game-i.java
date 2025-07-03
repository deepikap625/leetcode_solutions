class Solution {

    // Helper function to get the next character (wrap from 'z' to 'a')
    private char nextChar(char c) {
        return (c == 'z') ? 'a' : (char)(c + 1);
    }

    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        // Continue building until word has at least k characters
        while (word.length() < k) {
            int len = word.length();
            for (int i = 0; i < len && word.length() < k; i++) {
                word.append(nextChar(word.charAt(i)));
            }
        }

        return word.charAt(k - 1); // k is 1-based
    }
}
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int k = 10;
        char result = sol.kthCharacter(k);
        System.out.println("The " + k + "th character is: " + result);
    }
}
