package demo.code.problems;

import demo.code.utils.TreeUtil;

public class TreeUsage {

    public static void main(String[] args) {
        TreeUsage t = new TreeUsage();
        t.leftView(createNode());
        System.out.println("\n Tree Height is below: ");
        System.out.println(t.treeHeight(createNode()));

        TreeNode node = createNode();
        TreeNode mirrorTree = createMirrorTree();
        TreeUtil.print(node);
        System.out.println(t.isMirror(node));
        TreeUtil.print(mirrorTree);
        System.out.println(t.isMirror(mirrorTree));
    }

    /*
                 1
               /   \
             2       3
            / \     / \
          4    5   6   7
            \
             8
            /
           9
     */
    private static TreeNode createNode() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.right = new TreeNode(8);
        root.left.left.right.left = new TreeNode(9);
        return root;
    }

    private static TreeNode createMirrorTree() {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(20);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);

        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(40);
        return root;
    }

    public void leftView(TreeNode root) {
        TreeNode tmp = root;

        while (tmp != null) {
            System.out.print(tmp.getVal() + " ");
            if (tmp.left != null) {
                tmp = tmp.left;
            } else if (tmp.right != null) {
                tmp = tmp.right;
            } else {
                tmp = null;
            }
        }
    }

    public int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        return Integer.max(leftHeight, rightHeight) + 1;
    }

    public boolean isMirror(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.getVal() == right.getVal()) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        return false;
    }
}
