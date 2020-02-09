package demo.code.trees;


import demo.code.problems.TreeNode;
import demo.code.utils.TreeUtil;

public class MaxPath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeUtil.print(root);

        System.out.println(maxPathWeight(root));


        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(-5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeUtil.print(root);

        System.out.println(maxPathWeight(root));
    }

    public static int maxPathWeight(TreeNode root) {
        return root.getVal() + maxPath(root.left) + maxPath(root.right);
    }

    private static int maxPath(TreeNode node) {
        if(node == null) {
            return 0;
        }

        return node.getVal() + Math.max(maxPath(node.left), maxPath(node.right));
    }

}
