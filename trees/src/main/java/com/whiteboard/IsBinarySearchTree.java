package com.whiteboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Determine whether a given binary tree is a binary search tree.
 */
public final class IsBinarySearchTree {
    private IsBinarySearchTree() {
    }

    /**
     * Determine whether a given binary tree is a binary search tree.
     *
     * The algorithm is to do an inorder traversal of the tree, and
     * then check whether the returned list is in ascending order.
     *
     * @param root The root of the binary tree to be checked.
     * @return 'true' if the given tree is a binary search tree,
     * 'false' otherwise.
     */
    public static boolean isBinarySearchTree(BinaryTreeNode<Integer> root) {
        List<Integer> inorderList = traverseInorder(root);
        for (int i = 0; i < inorderList.size() - 1; ++i) {
            if (inorderList.get(i) > inorderList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // declared package-private so tests can call it
    static List<Integer> traverseInorder(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        // base case
        if (root == null) {
            return result;
        }
        // recursive step
        result.addAll(traverseInorder(root.left));
        result.add(root.data);
        result.addAll(traverseInorder(root.right));
        return result;
    }
}
