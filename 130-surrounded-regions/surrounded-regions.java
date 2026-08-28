class Solution {
    int []x={-1,1,0,0};
    int []y={0,0,-1,1};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean [][]v=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0||i==(m-1)||j==0||j==(n-1)) && board[i][j]=='O'&&v[i][j]==false)
                    dfs(board,m,n,i,j,v);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'&&!v[i][j])
                    board[i][j]='X';
            }
        }
    }
    void dfs(char [][]board,int m,int n, int i,int j,boolean [][]vis){
        vis[i][j]=true;
        for(int k=0;k<4;k++)
        {
            int r=i+x[k];
            int c=j+y[k];
            if(valid(r,c,m,n)&&board[r][c]=='O'&& vis[r][c]==false)
                dfs(board,m,n,r,c,vis);
        }
        return;
    }
    boolean valid(int i,int j, int m,int n){
        if(i<0||i>(m-1)||j<0||j>(n-1))
            return false;
        return true;
    }
}