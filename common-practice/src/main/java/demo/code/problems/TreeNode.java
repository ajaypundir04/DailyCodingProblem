package demo.code.problems;

import demo.code.utils.TreeUtil;

public class TreeNode implements TreeUtil.PrintableNode {

    private int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int v) {
        this.val = v;
    }

    public int getVal() {
        return val;
    }

    @Override
    public TreeUtil.PrintableNode getLeft() {
        return left;
    }

    @Override
    public TreeUtil.PrintableNode getRight() {
        return right;
    }

    @Override
    public String getText() {
        return String.valueOf(getVal());
    }
}
