/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode result = stack.pop();
        TreeNode node = result.right;
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
        return result.val;
    }

    public boolean hasNext() {
        return stack.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */