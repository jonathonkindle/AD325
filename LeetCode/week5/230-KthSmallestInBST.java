/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode node2 = stack.pop();
                k--;
                if (k == 0) {
                    return node2.val;
                }
                node = node2.right;
            }
        }
        return 0;
    }
}