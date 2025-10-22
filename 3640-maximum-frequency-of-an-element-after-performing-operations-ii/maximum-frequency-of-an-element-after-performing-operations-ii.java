class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxVal = Arrays.stream(nums).max().getAsInt() + k;
        TreeMap<Integer, Integer> diff = new TreeMap<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0; i<n; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            int left=Math.max(0,nums[i]-k);
            int right=Math.min(maxVal,nums[i]+k);

            diff.put(left,diff.getOrDefault(left,0)+1);
            diff.put(right+1,diff.getOrDefault(right+1,0)-1);

            diff.putIfAbsent(nums[i], 0);
        }

        int ans=0; int cumSum=0;
        for(int target:diff.keySet()) {
            int val=diff.get(target);
            cumSum+=val;

            int total=cumSum;
            int ownFreq=map.containsKey(target) ? map.get(target) : 0;
            int needConversion = total-ownFreq;
            int canConv=Math.min(needConversion,numOperations);

            ans=Math.max(ans,ownFreq+canConv);
        }

        return ans;
    }
}