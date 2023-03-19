package data_structure.tree;


import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        add(3, root);
        add(4, root);
        add(-2, root);
        add(2, root);
        add(-1, root);
        add(-3, root);
        add(45, root);
        add(7, root);

        print(root);
        remove(root, -2);
        print(root);

    }

    public static void add(Integer value, TreeNode root) {
        if (root.data <= value) {
            if (root.right == null) {
                root.right = new TreeNode(value);
            } else {
                add(value, root.right);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(value);
            } else {
                add(value, root.left);
            }
        }
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        if (root.left != null) print(root.left);
        if (root.right != null) print(root.right);
    }

    //TODO: make a method to remove data from tree
    public static void remove(TreeNode root, int value) {

    }


}
