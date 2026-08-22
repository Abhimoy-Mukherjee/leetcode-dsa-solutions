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
    public boolean isCompleteTree(TreeNode root) {
        //ArrayDeque null allow nhi krta isliye linkedlist use krna padega idhr
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return true;
        queue.add(root);
        boolean nullseen=false;
        while(!queue.isEmpty())
        {
            TreeNode t=queue.remove();
            if(t==null)
                nullseen=true;
            else{
                if(nullseen)
                    return false;
                    queue.add(t.left);
                    queue.add(t.right);
            }
        }
        return true;
    }
}