class Solution {
    int []x={-1,1,0,0};
    int []y={0,0,-1,1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r=heights.length;
        int c=heights[0].length;
        boolean [][]p=new boolean[r][c];
        boolean [][]a=new boolean[r][c];
        for(int i=0;i<c;i++)
            dfs(heights,0,i,p);
        for(int i=0;i<r;i++)
            dfs(heights,i,0,p);
        for(int i=0;i<c;i++)
            dfs(heights,r-1,i,a);
        for(int i=0;i<r;i++)
            dfs(heights,i,c-1,a);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(p[i][j]&&a[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    public void dfs(int [][]heights, int row, int col, boolean [][]v){
        v[row][col]=true;
        for(int k=0;k<4;k++)
        {
            int r=row+x[k];
            int c=col+y[k];
            if(valid(r,c,heights.length,heights[0].length) && v[r][c]==false && heights[r][c]>=heights[row][col])
                dfs(heights,r,c,v);
        }
    }
    boolean valid(int i,int j,int m,int n)
    {
        if(i<0||i>=m||j<0||j>=n)
            return false;
        return true;
    }
}