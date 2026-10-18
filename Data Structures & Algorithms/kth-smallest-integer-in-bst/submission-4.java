class Solution {
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }

    public void dfs(TreeNode node, int k) {
        if (node == null) return;

        dfs(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        dfs(node.right, k);
    }
}