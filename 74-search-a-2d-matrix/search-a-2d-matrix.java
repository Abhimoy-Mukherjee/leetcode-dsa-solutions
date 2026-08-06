class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int start = 0;
        int end = matrix.length*n-1;
        while(start<=end)
        {
            int middle = start+(end-start)/2;
            int row=middle/n;
            int col = middle%n;
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target)
                end=middle-1;
            else
                start=middle+1;
        }
        return false;
    }
}