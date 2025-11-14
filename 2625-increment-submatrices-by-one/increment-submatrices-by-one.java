class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        // 1  1  0  0
        // 1  2  1  0
        // 0  1  1  0
        // 0  0  0  0

        int ans[][]=new int[n][n+1];

        for(int query[]:queries) {
            int x=query[1],y=query[3];
            int start=query[0],end=query[2];

            for(int i=start; i<=end; i++) {
                ans[i][x]++; ans[i][y+1]--;
            }
        }

        int res[][]=new int[n][n];

        for(int i=0; i<n; i++) {
            res[i][0]=ans[i][0];
            for(int j=1; j<=n; j++) {
                ans[i][j]+=ans[i][j-1];
                if(i<n && j<n)
                res[i][j]=ans[i][j];
            }
        }

        return res;
    }
} 