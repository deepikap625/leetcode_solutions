class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int n = events.length;

        // Memoization table
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, k, events, dp);
    }

    private int dfs(int i, int k, int[][] events, int[][] dp) {
        if (i == events.length || k == 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];

        // Option 1: Skip current event
        int skip = dfs(i + 1, k, events, dp);

        // Option 2: Attend current event
        int next = findNext(events, events[i][1]);
        int take = events[i][2] + dfs(next, k - 1, events, dp);

        return dp[i][k] = Math.max(skip, take);
    }

    // Binary search to find the first event starting after current ends
    private int findNext(int[][] events, int end) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > end) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solver = new Solution();

        System.out.print("Enter number of events: ");
        int n = sc.nextInt();
        int[][] events = new int[n][3];

        System.out.println("Enter events as startDay endDay value:");
        for (int i = 0; i < n; i++) {
            events[i][0] = sc.nextInt();
            events[i][1] = sc.nextInt();
            events[i][2] = sc.nextInt();
        }

        System.out.print("Enter value of k (max events you can attend): ");
        int k = sc.nextInt();

        int maxValue = solver.maxValue(events, k);
        System.out.println("Maximum value by attending up to " + k + " events: " + maxValue);

        sc.close();
    }
}
