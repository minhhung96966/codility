package trees.iterative_dfs.maximum_depth_of_binary_tree;

import java.util.Map;
import java.util.Stack;

public class IterativeDfsSolution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<NodeAndDepth> stack = new Stack<>();
        stack.push(new NodeAndDepth(root, 1));

        int res = 1;

        while (!stack.empty()) {
            NodeAndDepth nodeAndDepth = stack.pop();
            TreeNode node = nodeAndDepth.treeNode;
            int depth = nodeAndDepth.depth;

            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new NodeAndDepth(node.left, depth + 1));
                stack.push(new NodeAndDepth(node.right, depth + 1));
            }
        }

        return res;
    }

    class NodeAndDepth {
        TreeNode treeNode;
        int depth;

        NodeAndDepth(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));

        System.out.println(new IterativeDfsSolution().maxDepth(treeNode));
    }
}
