class Solution {
    int dirs[][]={{-1,0},{1,0},{0,1},{0,-1}};

    void bfs(int X,int Y,boolean vis[][],int heights[][]) {
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{X,Y});
        vis[X][Y]=true;

        int n=heights.length; int m=heights[0].length;
        while(!q.isEmpty()) {
            int top[]=q.remove();
            int x=top[0]; 
            int y=top[1];

            for(int i=0; i<4; i++) {
                int nx=x+dirs[i][0];
                int ny=y+dirs[i][1];

                if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==false && 
                heights[nx][ny] >= heights[x][y]) {
                    vis[nx][ny]=true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }



    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list=new ArrayList<>();
        int n=heights.length; int m=heights[0].length;
        boolean po[][]=new boolean[n][m];
        boolean ao[][]=new boolean[n][m];
        for(int i=0; i<n; i++) {
            if(po[i][0]==false) bfs(i,0,po,heights);
            if(ao[i][m-1]==false) bfs(i,m-1,ao,heights);
        }

        for(int i=0; i<m; i++) {
            if(po[0][i]==false) bfs(0,i,po,heights);
            if(ao[n-1][i]==false) bfs(n-1,i,ao,heights);
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if( po[i][j] &&  ao[i][j]) list.add(Arrays.asList(i,j));
            }
        }
        return list;
    }
}