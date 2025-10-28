class Solution {
    public int countValidSelections(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) {
                count+= helper(nums.clone(), i,-1);//nums can't be passes since its pass by ref
                count+=helper(nums.clone(),i,1);// in ava always
            }
        }
        return count;
    }
    public static int helper(int []nums,int curr,int dir){
        if(curr>=nums.length||curr<0){
            for(int val:nums)if(val!=0)return 0;
            return 1;
        }
        if(nums[curr]==0) return helper(nums,curr+dir,dir);
        if(nums[curr]>0){
            nums[curr]--;
            dir=-dir;
            return helper(nums,curr+dir,dir);
        }
        return 0;
    }
}
