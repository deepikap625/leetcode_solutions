class Solution {
    public int sumFourDivisors(int[] nums) {
        int max=0;
        for(int val:nums)if(val>max)max=val;
        int[]arr=new int[max+1];
        Arrays.fill(arr,-1);
        int sum=0;
        for(int val:nums){
            sum+=helper(val,arr);
        }
        return sum;
    }
    public static int helper(int val,int []dp){
        if(val<=3)return 0;
        if(dp[val]!=-1)return dp[val];
        int divis=2,cursum=1+val;
        for(int i=2;i*i<=val;i++){
            if(val%i==0){
                int curDiv=val/i;
                if(i==curDiv){
                    divis+=1;
                    cursum+=i;
                }else{
                    divis+=2;
                    cursum+=i+curDiv;
                }
                if(divis>4) {
                    dp[val]=0;
                    return 0;
                }
            }
        }
        dp[val]=divis==4?cursum:0;
        return dp[val];
    }
}