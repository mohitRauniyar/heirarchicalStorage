package resumeselector.Resume;

import java.util.*;

class Node {
    String key;
    int height;
    Node left, right;

    Node(String d) {
        key = d;
        height = 1;
    }
}

class AVLTree {
    Node root;

    // A utility function to get the height of the tree
    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, String key) {
        // 1. Perform the normal BST insertion
        if (node == null)
            return (new Node(key));

        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key);
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        // 2. Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Get the balance factor of this ancestor node to check whether this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // return the (unchanged) node pointer
        return node;
    }

    void printInorder(Node node) {
        if (node == null)
            return;

        // First recur on left child
        printInorder(node.left);

        // Then print the data of node
        System.out.print(node.key + " ");

        // Now recur on right child
        printInorder(node.right);
    }
    public static List<Map<String, Object>> convertTree(Node node) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (node != null) {
            list.add(convertNodeToMap(node));
        }
        return list;
    }

    private static Map<String, Object> convertNodeToMap(Node node) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", node.key);
        List<Map<String, Object>> children = new ArrayList<>();
        if (node.left != null) {
            children.add(convertNodeToMap(node.left));
        }
        if (node.right != null) {
            children.add(convertNodeToMap(node.right));
        }
        map.put("child", children);
        return map;
    }
}

public class Tree {
    public static List<Map<String, Object>> treefy(List<String> skills) {
        AVLTree a = new AVLTree();
        for (String skill : skills) {
            a.root = a.insert(a.root, skill);  // Update root each time
        }

        List<Map<String, Object>> result = a.convertTree(a.root);

        return result;
    }
    public static boolean searchNode(Map<String, Object> node, String key) {
        if (node.get("key").equals(key)) {
            return true;
        }
        List<Map<String, Object>> children = (List<Map<String, Object>>) node.get("child");
        for (Map<String, Object> child : children) {
            if (searchNode(child, key)) {
                return true;
            }
        }
        return false;
    }

}
