package demo.code.problems;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Consumer;

public class LevelOrder {
    public static void main(String[] args) {
        new LevelOrder().levelOrderTraversal(createTree());
    }

    /**
     * 4
     * /  \
     * 2     5
     * /  \   /  \
     * 1    3 9    10
     * <p>
     *
     * @return create tree
     */
    private static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;
    }

    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode element = queue.poll();
            System.out.print(element.getVal() + " ");

            ifPresent(element.left, queue::add);
            ifPresent(element.right, queue::add);
        }
    }

    private <Obj> void ifPresent(Obj object, Consumer<Obj> consumer) {
        if (object != null) {
            consumer.accept(object);
        }
    }

}
