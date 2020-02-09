package demo.code.trees;

import demo.code.problems.TreeNode;

import java.util.*;

public class CheckBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }
    private static boolean isValidBST(TreeNode treeNode) {
        List<Integer> vals = traverse(treeNode);
        boolean valid = true;
        for (int i = 0; i < vals.size() - 1; i++) {

            if (vals.get(i) > vals.get(i + 1)) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    static List<Integer> traverse(TreeNode root) {
        List<Integer> ints = new ArrayList<>();
        if(root != null) {
            if(root.left != null) {
                ints.addAll(traverse(root.left));
            }
            ints.add(root.getVal());
            if(root.right != null) {
                ints.addAll(traverse(root.right));
            }
        }
        return ints;
    }

}
