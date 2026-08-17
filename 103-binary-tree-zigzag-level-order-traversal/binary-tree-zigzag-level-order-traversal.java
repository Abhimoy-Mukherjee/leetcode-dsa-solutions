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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Deque<TreeNode> queue=new ArrayDeque<>();
        List<List<Integer>> result=new ArrayList<>();
        int lefttoright=1;
        queue.addLast(root);
        while(!queue.isEmpty())
        {
            int levelsize=queue.size();
            List<Integer> list = new ArrayList<>();
            while((levelsize--)>=1)
            {
                TreeNode temp=queue.removeFirst();
                list.add(temp.val);
                if(temp.left!=null)
                    queue.addLast(temp.left);
                if(temp.right!=null)
                    queue.addLast(temp.right);
            }
            if(lefttoright==0)
                Collections.reverse(list);//yaad krlo aise reverse krte hai list ko
            lefttoright=1-lefttoright;
            result.add(list);
        }
        return result;
    }
}