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
    TreeNode g1first=null;
    TreeNode g1sec=null;
    TreeNode g2first=null;
    TreeNode g2sec=null;
    TreeNode prev=null;
    int g=0;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(g==1)
            swap(g1first,g1sec);
        else
            swap(g1first,g2sec);
    }
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        if(prev==null)
            prev=root;
        else{
            if(root.val<=prev.val){
                if(g==0)
                {
                    g1first=prev;
                    g1sec=root;
                    g++;
                }
                else{
                    g2first=prev;
                    g2sec=root;
                    g++;
                }
            }
            prev=root;
        }
        inorder(root.right);
    }
    public void swap(TreeNode n1, TreeNode n2){
        int temp=n1.val;
        n1.val=n2.val;
        n2.val=temp;
    }
}