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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                if(node!=null){
                    level.add(node.val);
                    if(node.left!=null)q.offer(node.left);
                    if(node.right!=null)q.offer(node.right);
                }
            }
            if(level.size()>0) traversal.add(level);
        }
        List<Integer> ans = new ArrayList<>();
        for(List<Integer> list:traversal){
            ans.add(list.get(list.size()-1));
        }
        return ans;
    }
    
}
