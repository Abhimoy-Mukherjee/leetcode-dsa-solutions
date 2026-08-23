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
    HashMap<Integer,Integer> map=new HashMap<>();
    int idx=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
            idx=postorder.length-1;
        return make(postorder,0,inorder.length-1);
    }
    public TreeNode make(int[] post,int low,int high){
        if(low>high || idx<0)
            return null;
        TreeNode node = new TreeNode(post[idx]);
        idx--;
        int id=map.get(node.val);
        node.right=make(post,id+1,high);
        node.left=make(post,low,id-1);
        return node;
    }
}