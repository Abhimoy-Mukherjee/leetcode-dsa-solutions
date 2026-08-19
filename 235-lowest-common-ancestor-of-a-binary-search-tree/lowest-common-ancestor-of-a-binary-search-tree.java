/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<q.val)
            LCA(root,p,q);
        else
            LCA(root,q,p);
        return ans;
    }
    public void LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return ;
        if(root==p || root==q)
        {
            ans=root;
            return;
        }
        else if(root.val<p.val)
            LCA(root.right,p,q);
        else if(root.val>q.val)
            LCA(root.left,p,q);
        else{
            ans=root;
            return;
        }
    }
}