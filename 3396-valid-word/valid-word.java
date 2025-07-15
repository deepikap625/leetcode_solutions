public class Solution {

    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false; // invalid character
            }

            if (isVowel(c)) {
                hasVowel = true;
            } else if (Character.isLetter(c)) {
                hasConsonant = true;
            }
        }

        return hasVowel && hasConsonant;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isValid("234Adas")); // true
        System.out.println(sol.isValid("b3"));      // false
        System.out.println(sol.isValid("a3$e"));    // false
        System.out.println(sol.isValid("ae2"));     // false (no consonant)
        System.out.println(sol.isValid("123"));     // false (no vowel or consonant)
    }
}
