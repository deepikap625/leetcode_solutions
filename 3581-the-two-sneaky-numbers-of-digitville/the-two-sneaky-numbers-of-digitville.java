class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int []arr=new int[2];
        int i=0;
        for(int val:nums){
            if(set.contains(val)&&arr[0]!=val)arr[i++]=val;
            else set.add(val);
            if(i==2)break;
        }
        return arr;
    }
}