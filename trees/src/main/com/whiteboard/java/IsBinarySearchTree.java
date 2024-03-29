package com.whiteboard.java;

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
        List<Integer> inOrderList = traverseTreeInOrder(root);
        return isAscending(inOrderList);
    }

    static List<Integer> traverseTreeInOrder(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        // base case
        if (root == null) {
            return result;
        }
        // recursive step
        result.addAll(traverseTreeInOrder(root.left));
        result.add(root.data);
        result.addAll(traverseTreeInOrder(root.right));
        return result;
    }

    private static boolean isAscending(List<Integer> list) {
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
