class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // Store: [row, column, value]
        List<int[]> nodes = new ArrayList<>();

        dfs(root, 0, 0, nodes);

        // Sort by:
        // 1. column
        // 2. row
        // 3. value
        Collections.sort(nodes, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }

            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[2] - b[2];
        });

        List<List<Integer>> result = new ArrayList<>();

        int previousColumn = Integer.MIN_VALUE;

        for (int[] node : nodes) {
            int row = node[0];
            int column = node[1];
            int value = node[2];

            // New column
            if (column != previousColumn) {
                result.add(new ArrayList<>());
                previousColumn = column;
            }

            result.get(result.size() - 1).add(value);
        }

        return result;
    }

    private void dfs(TreeNode root, int row, int column,
                     List<int[]> nodes) {

        if (root == null) {
            return;
        }

        nodes.add(new int[]{row, column, root.val});

        // Left child: row + 1, column - 1
        dfs(root.left, row + 1, column - 1, nodes);

        // Right child: row + 1, column + 1
        dfs(root.right, row + 1, column + 1, nodes);
    }
}
