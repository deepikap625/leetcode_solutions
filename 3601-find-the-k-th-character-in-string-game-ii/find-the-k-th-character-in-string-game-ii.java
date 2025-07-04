class Solution {
    public char kthCharacter(long k, int[] operations) {
        long[] lengths = new long[operations.length + 1];
        lengths[0] = 1;

        // Precompute lengths after each operation
        for (int i = 0; i < operations.length; i++) {
            lengths[i + 1] = Math.min((long) 1e15, lengths[i] * 2);
        }

        int shiftCount = 0;

        // Trace backward
        for (int i = operations.length - 1; i >= 0; i--) {
            long half = lengths[i];
            if (k > half) {
                k -= half;
                if (operations[i] == 1) {
                    shiftCount++;
                }
            }
        }

        // Apply total shift to 'a'
        char result = (char)((('a' - 'a' + shiftCount) % 26) + 'a');
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter k: ");
        long k = sc.nextLong();

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();

        int[] operations = new int[n];
        System.out.println("Enter operations (0 or 1):");
        for (int i = 0; i < n; i++) {
            operations[i] = sc.nextInt();
        }

        char result = sol.kthCharacter(k, operations);
        System.out.println("The " + k + "th character is: " + result);
    }
}
