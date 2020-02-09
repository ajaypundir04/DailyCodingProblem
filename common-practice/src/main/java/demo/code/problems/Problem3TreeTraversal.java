package demo.code.problems;

import java.util.Stack;

public class Problem3TreeTraversal {

    /**
     * 4
     * /  \
     * 2     5
     * /  \
     * 1    3
     * <p>
     * InOrder: 1 2 3 4 5
     * PreOrder: 4 2 1 3 5
     * PostOrder: 1 3 2 5 4
     *
     * @return create tree
     */
    private TreeNode createTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        return root;
    }

    public static void main(String[] args) {
        Problem3TreeTraversal t = new Problem3TreeTraversal();
        TreeNode root = t.createTree();

//        System.out.println("In Order");
//        System.out.println("=====================");
//        t.inorderTraversalRec(root);
//        System.out.println();
//        t.inorderItr(root);
//        System.out.println();

//        System.out.println("Pre Order");
//        System.out.println("=====================");
//        t.preOrderTraversalRec(root);
//        System.out.println();
//        t.preOrderItr(root);
//        System.out.println();

        System.out.println("Post Order");
        System.out.println("=====================");
        t.postOrderTraversalRec(root);
        System.out.println();
        t.postOrderItr(root);
        System.out.println();
    }

    public void inorderTraversalRec(final TreeNode treeNode) {
        if (treeNode != null) {
            inorderTraversalRec(treeNode.left);
            System.out.print(treeNode.getVal() + " ");
            inorderTraversalRec(treeNode.right);
        }
    }

    public void preOrderTraversalRec(final TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.getVal() + " ");
            preOrderTraversalRec(treeNode.left);
            preOrderTraversalRec(treeNode.right);
        }
    }

    public void postOrderTraversalRec(final TreeNode treeNode) {
        if (treeNode != null) {
            postOrderTraversalRec(treeNode.left);
            postOrderTraversalRec(treeNode.right);
            System.out.print(treeNode.getVal() + " ");
        }
    }

    public void inorderItr(TreeNode root) {
        Stack<TreeNode> stacks = new Stack<>();
        TreeNode itr = root;
        while (itr != null || !stacks.isEmpty()) {
            if (itr == null) {
                itr = stacks.pop();
                System.out.print(itr.getVal() + " ");
                itr = itr.right;
            } else {
                stacks.push(itr);
                itr = itr.left;
            }
        }
    }

    public void preOrderItr(TreeNode root) {
        Stack<TreeNode> stacks = new Stack<>();
        while (root != null || !stacks.isEmpty()) {
            if (root != null) {
                System.out.print(root.getVal() + " ");
                stacks.push(root);
                root = root.left;
            } else {
                root = stacks.pop();
                root = root.right;
            }
        }
    }

    public void postOrderItr(TreeNode root) {
        Stack<TreeNode> stacks = new Stack<>();
        while (root != null || !stacks.isEmpty()) {
            if (root == null) {
                TreeNode t = stacks.peek();
                if(t.right == null) {
                    root = stacks.pop();
                    System.out.print(root.getVal() + " ");
                    root = root.right;
                } else {
                    root = root.right;
                }
            } else {
                stacks.push(root);
                root = root.left;
            }
        }
    }
}
