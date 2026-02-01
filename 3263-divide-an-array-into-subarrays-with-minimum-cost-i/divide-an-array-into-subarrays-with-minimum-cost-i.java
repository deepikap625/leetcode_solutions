class Solution {
    public int minimumCost(int[] nums) {

        int jor = nums[0];
        int m = Integer.MAX_VALUE;
        int i1 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < m) {
                i1 = i;
                m = nums[i];
            }
        }
        jor += nums[i1];
        nums[i1] = Integer.MAX_VALUE;
        m = Integer.MAX_VALUE;
        
        for (int i = 1; i < nums.length; i++) {
            m = Math.min(m, nums[i]);
        }
        jor += m;
        
        return jor;
    }
}