package trees.dfs.invert_binary_tree;
//Can use preorder or postorder
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //swap
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));

        TreeNode reversed = new Solution().invertTree(treeNode) ;
        reversed.inorder(reversed);
        System.out.println("\n");
        reversed.preorder(reversed);
        System.out.println("\n");
        reversed.postorder(reversed);
    }
}
