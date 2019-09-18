#pragma once

#include <climits>
#include <queue>
#include <vector>

using namespace std;

template<typename T>
struct Node {
    T data;
    Node* left;
    Node* right;
};

/*
public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;
}
*/

#include "../arrays/TestUtils.h"

void testCreateBstFromSortedArray();
void testCreateNestedFolders();
void testIsBst();
void testTraverseBstBreadthFirst();
void testTraverseBstInOrder();
void testTraverseBstPostOrder();
void testTraverseBstPreOrder();
