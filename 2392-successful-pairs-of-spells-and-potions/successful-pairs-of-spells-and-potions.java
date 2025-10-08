class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            // Minimum potion required for success
            double required = (double) success / spell;
            
            // Binary search for the first potion >= required
            int idx = lowerBound(potions, required);
            
            ans[i] = m - idx; // all potions from idx to end are successful
        }
        return ans;
    }

    private int lowerBound(int[] arr, double target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}