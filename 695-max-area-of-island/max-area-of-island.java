class Solution {
    int []x={-1,1,0,0};
    int []y={0,0,-1,1};
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        boolean [][]visited=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==false && grid[i][j]==1)
                {
                    int cur=dfs(grid,m,n,i,j,visited);
                    res=Math.max(res,cur);
                }
            }
        }
        return res;
    }
    public int dfs(int [][]grid,int m, int n,int i,int j,boolean [][]visited){
        int cur=1;
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int row=i+x[k];
            int col=j+y[k];
            if(valid(row,col,m,n) && grid[row][col]==1 && visited[row][col]==false){
                cur+=dfs(grid,m,n,row,col,visited);
            }
        }
        return cur;
    }
    boolean valid(int i, int j,int m,int n){
        if(i<0||i>=m||j<0||j>=n)
            return false;
        return true;
    }
}