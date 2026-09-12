/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res=0;
    public int averageOfSubtree(TreeNode root) {
        checkavg(root);
        return res;        
    }
    public int[] checkavg(TreeNode root){
        int sum=0;
        if(root==null)
            return new int[]{0,0};
        int []a=checkavg(root.left);
        int []b=checkavg(root.right);
        sum=(a[0]+b[0]+root.val);
        int avg=sum/(a[1]+b[1]+1);
        if(avg==root.val)
            res++;
        return new int[]{sum,a[1]+b[1]+1};
    }
}