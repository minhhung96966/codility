package trees.dfs.maximum_depth_of_binary_tree;

public class RecursiveDfsSolution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }
}
