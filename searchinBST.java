import java.util.*;

class BST {
    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // 🔹 Insert into BST
    Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // 🔹 Inorder Traversal
    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // 🔹 Preorder Traversal
    void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 🔹 Postorder Traversal
    void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // 🔹 Search in BST
    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // 🔹 Find Minimum
    int findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    // 🔹 Height of Tree
    int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // 🔹 Delete Node from BST
    Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            // Node with one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children
            root.data = findMin(root.right); // inorder successor
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    // 🔹 Main method to test BST
    public static void main(String[] args) {
        BST tree = new BST();

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            tree.root = tree.insert(tree.root, val);
        }

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postorder(tree.root);
        System.out.println();

        int key = 60;
        System.out.println("Search " + key + ": " + tree.search(tree.root, key));

        System.out.println("Deleting 30...");
        tree.root = tree.delete(tree.root, 30);

        System.out.print("Inorder After Deletion: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Height of Tree: " + tree.height(tree.root));
    }
}
