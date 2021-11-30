class Solution {
    Integer res = Integer.MAX_VALUE;
    Integer previous = null;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null)
            minDiffInBST(root.left);
        if (previous != null)
            res = Math.min(res, root.val - previous);
        previous = root.val;
        if (root.right != null)
            minDiffInBST(root.right);
        return res;
    }
}