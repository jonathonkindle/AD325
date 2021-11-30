class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode previous = null;
        TreeNode node = root;
        while (node != null) {
            if (node.val == key) {
                break;
            }
            previous = node;
            if (node.val > key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node == null) {
            return root;
        }
        if (previous == null) {
            return delete(node);
        }
        if (previous.left == node) {
            previous.left = delete(node);
        } else {
            previous.right = delete(node);
        }
        return root;
    }

    private TreeNode delete(TreeNode node) {
        if (node.left == null && node.right == null) {
            return null;
        }
        if (node.left == null) {
            return node.right;
        }
        if (node.right == null) {
            return node.left;
        }
        TreeNode previous = node;
        TreeNode current = node.right;
        while (current.left != null) {
            previous = current;
            current = current.left;
        }
        node.val = current.val;
        if (previous.left == current) {
            previous.left = current.right;
        } else {
            previous.right = current.right;
        }
        return node;
    }
}