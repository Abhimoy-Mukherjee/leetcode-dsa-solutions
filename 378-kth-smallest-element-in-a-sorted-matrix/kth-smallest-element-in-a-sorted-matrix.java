class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int low=matrix[0][0];
        int high=matrix[m][n];
        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int ans=checkSmallest(matrix,m,n,mid);
            if(ans<k)
                low=mid+1;
            else{
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }
    public int checkSmallest(int [][]matrix,int m,int n,int mid){
        int row=m;
        int col=0;
        int count=0;
        while(row>=0 && col<=n){
            if(matrix[row][col]<=mid)
            {
                count+=row+1;
                col++;
            }
            else
                row--;
        }
        return count;
    }
}