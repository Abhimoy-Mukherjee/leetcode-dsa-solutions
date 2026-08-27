class Solution {
    int []x={-1,1,0,0};
    int []y={0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0,time=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    queue.add(new int[]{i,j});
                    grid[i][j]=0;
                }
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        while(!queue.isEmpty() && fresh>0)
        {
            time++;
            int s=queue.size();
            while((s--)>0){
               int []p=queue.poll();
               int r=p[0];
               int c=p[1];
               for(int k=0;k<4;k++)
               {
                    int row=r+x[k];
                    int col=c+y[k];
                    if(valid(row,col,m,n) && grid[row][col]==1)
                    {
                        queue.add(new int[]{row,col});
                        grid[row][col]=0;
                        fresh--;
                    }
               }
            }
        }
        if(fresh>0)
            return -1;
        return time;
    }
    boolean valid(int i, int j, int m, int n)
    {
        if(i<0||i>=m||j<0||j>=n)
            return false;
        return true;
    }
}