class Solution {
    public int stoneGameV(int[] a) {
        int n=a.length;
        int[][] dp=new int[n][n];
        for(int i=2;i<=n;i++){
            for(int l=0;l+i<=n;l++){
                int r=l+i-1,total=0,left=0;
                for(int j=l;j<=r;j++) 
                    total+=a[j];
                for(int k=l;k<r;k++){
                    left+=a[k];
                    int right=total-left;
                    if(left<right) 
                        dp[l][r]=Math.max(dp[l][r],left+dp[l][k]);
                    else if(left>right) 
                        dp[l][r]=Math.max(dp[l][r],right+dp[k+1][r]);
                    else 
                    dp[l][r]=Math.max(dp[l][r],left+Math.max(dp[l][k],dp[k+1][r]));
                }
            }
        }
        return dp[0][n-1];
    }
}