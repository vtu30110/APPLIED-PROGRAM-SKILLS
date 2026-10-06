class Solution {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            // Go as far left as possible
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Visit the node
            root = stack.pop();
            k--;

            // kth smallest found
            if (k == 0) {
                return root.val;
            }

            // Move to right subtree
            root = root.right;
        }

        return -1;
    }
}
