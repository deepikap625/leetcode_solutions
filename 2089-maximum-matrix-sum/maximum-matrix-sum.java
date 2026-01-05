class Solution {
    public static long maxMatrixSum(int[][] matrix) {
//        int[]arr=new int[4];
        long sum=0,negativeNos=0,min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int cur=matrix[i][j];
                if(cur<0)negativeNos++;
                sum+=Math.abs(cur);
                min=Math.min(min,Math.abs(cur));
            }
        }
        return ((negativeNos&1)!=0)?sum-=2L*min:sum;
    }
}