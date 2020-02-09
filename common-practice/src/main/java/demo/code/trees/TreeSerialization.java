package demo.code.trees;

import java.util.Stack;

public class TreeSerialization {

    static class Node {
        String val;
        Node left;
        Node right;

        Node(String val) {
            this.val = val;
        }
    }

    /*
                                  root
                  ┌─────────────┴─────────────┐
                left                        right
           ┌──────┴──────┐
       left.left    left.right
     */
    public static void main(String[] args) {
        Node root = new Node("root");
        root.left = new Node("left");
        root.right = new Node("right");

        root.left.left = new Node("left.left");
        root.left.right = new Node("left.right");

        String s = serialize(root);
        System.out.println(s);
        Node node = deserialize(s);
    }

    static String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        sb.append("Node(").append("'").append(root.val).append("'");
        if (root.left != null) {
            sb.append(", ").append(serialize(root.left));
        }
        if (root.right != null) {
            sb.append(", ").append(serialize(root.right));
        }
        sb.append(")");
        return sb.toString();
    }

    static Node deserialize(String s) {
        Stack<String> tokens = new Stack<>();
        Stack<Node> nodes = new Stack<>();
        for (String token : s.split(", ")) {
            if (token.endsWith(")")) {
                if (token.endsWith("))")) {
                    // create right
                    // then create root
                    Node right = toNode(token);
                    Node root = toNode(tokens.pop());
                    root.left = nodes.pop();
                    root.right = right;
                    nodes.push(root);
                } else {
                    // left node
                    nodes.push(toNode(token));
                }
            } else {
                tokens.push(token);
            }
        }
        return nodes.pop();
    }

    private static Node toNode(String str) {
        String val = str.substring(6, str.lastIndexOf('\''));
        return new Node(val);
    }
}
