package com.optimum;

class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int val;
        Node left, right, parent;
        boolean color = RED;

        Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    // Public insert method
    public void insert(int val) {
        Node newNode = new Node(val);
        root = bstInsert(root, newNode);
        fixInsert(newNode);
    }

    // Standard BST insert
    private Node bstInsert(Node root, Node node) {
        if (root == null) return node;

        if (node.val < root.val) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    // Fix violations after insert
    private void fixInsert(Node node) {
        Node parent, grandparent;

        while (node != root && node.parent.color == RED) {
            parent = node.parent;
            grandparent = parent.parent;

            // Parent is left child
            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                // Case 1: Uncle is red → recolor
                if (uncle != null && uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    node = grandparent;
                } else {
                    // Case 2: Node is right child → rotate left
                    if (node == parent.right) {
                        node = parent;
                        rotateLeft(node);
                    }
                    // Case 3: Node is left child → rotate right
                    parent.color = BLACK;
                    grandparent.color = RED;
                    rotateRight(grandparent);
                }

            } else { // Parent is right child
                Node uncle = grandparent.left;

                if (uncle != null && uncle.color == RED) {
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandparent.color = RED;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        node = parent;
                        rotateRight(node);
                    }
                    parent.color = BLACK;
                    grandparent.color = RED;
                    rotateLeft(grandparent);
                }
            }
        }
        root.color = BLACK;
    }

    // Left rotation
    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null) y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    // Right rotation
    private void rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;

        if (y.right != null) y.right.parent = x;

        y.parent = x.parent;

        if (x.parent == null) root = y;
        else if (x == x.parent.right) x.parent.right = y;
        else x.parent.left = y;

        y.right = x;
        x.parent = y;
    }

    // Inorder traversal (for testing)
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + "(" + (node.color ? "R" : "B") + ") ");
        inorder(node.right);
    }

        public static void main(String[] args) {
            RedBlackTree tree = new RedBlackTree();
            int[] arr = {10, 20, 30, 15, 25, 5, 1};

            for (int n : arr) {
                tree.insert(n);
            }

            tree.inorder();  // prints values with colors
        }

}
