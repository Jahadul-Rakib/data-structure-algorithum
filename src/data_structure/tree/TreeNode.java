package data_structure.tree;

public class TreeNode {
    Integer data;
    TreeNode left, right;

    public TreeNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
