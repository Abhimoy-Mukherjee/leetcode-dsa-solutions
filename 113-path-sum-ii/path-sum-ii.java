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
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list=new ArrayList<>();
        path(root,0,targetSum,list);
        return res;
    }
    public void path(TreeNode root,int sum,int target,List<Integer> list){
        if(root==null)
            return;
        sum+=root.val;
        list.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(sum==target)
                res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return ;
        }
        path(root.left,sum,target,list);
        path(root.right,sum,target,list);
        list.remove(list.size()-1);
    }
}