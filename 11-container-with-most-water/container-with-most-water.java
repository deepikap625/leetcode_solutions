class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int i=0,j=n-1,w=0,h=0,ans=0,area=0;

        while(i<j){
            w=j-i;
            h=Math.min(height[i],height[j]);
            area = w*h;
            ans=Math.max(ans,area);
            if(height[i]<height[j]) {
                i++;
            }else {
                j--;
            }

        }

        return ans;
    }
}