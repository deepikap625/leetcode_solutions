class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];

        for (int day = 1; day <= maxDay; day++) {
            if (!travelDays.contains(day)) {
                dp[day] = dp[day - 1];
            } else {
                int cost1 = dp[Math.max(0, day - 1)] + costs[0];
                int cost7 = dp[Math.max(0, day - 7)] + costs[1];
                int cost30 = dp[Math.max(0, day - 30)] + costs[2];
                dp[day] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }

        return dp[maxDay];
        
    }

    public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        int result = solution.mincostTickets(days, costs);
        System.out.println("Minimum cost: " + result);  // Output: 11
    }
    }

}