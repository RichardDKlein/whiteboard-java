package com.whiteboard.java;

import java.util.ArrayList;
import java.util.List;

public final class SpiralTraverse2dArray {
    /**
     * Traverse a 2D array, NOT NECESSARILY SQUARE, in a spiral
     * pattern, starting at the upper-left element, and spiralling
     * in the clockwise direction.
     *
     * We shall use a straighforward iterative algorithm that
     * traverses each "shell", or layer, of the array, starting
     * with the outermost shell and proceeding inward.
     *
     * Execution time is O(n), where n is the number of elements
     * in the array.
     *
     * @param a The 2D array that is to be traversed in a spiral
     *          pattern.
     * @return A list containing the array elements in spiral order.
     */
    public static List<Integer> spiralTraverse2dArray(int[][] a) {
        List<Integer> result = new ArrayList<>();
        int numRows = a.length;
        int numCols = a[0].length;
        for (int topRow = 0, rightCol = numCols - 1, bottomRow = numRows - 1, leftCol = 0;
             topRow <= bottomRow && leftCol <= rightCol;
             topRow++, rightCol--, bottomRow--, leftCol++) {

            result.addAll(spiralTraverseShell(a, topRow, rightCol, bottomRow, leftCol));
        }
        return result;
    }

    private static List<Integer> spiralTraverseShell(int[][] a, int topRow, int rightCol,
                                                     int bottomRow, int leftCol) {
        List<Integer> result = new ArrayList<>();
        // degenerate case: row vector
        if (topRow == bottomRow) {
            for (int col = leftCol; col <= rightCol; col++) {
                result.add(a[topRow][col]);
            }
            return result;
        }
        // degenerate case: column vector
        if (leftCol == rightCol) {
            for (int row = topRow; row <= bottomRow; row++) {
                result.add(a[row][leftCol]);
            }
            return result;
        }
        // top row
        for (int col = leftCol; col < rightCol; col++) {
            result.add(a[topRow][col]);
        }
        // right column
        for (int row = topRow; row < bottomRow; row++) {
            result.add(a[row][rightCol]);
        }
        // bottom row
        for (int col = rightCol; col > leftCol; col--) {
            result.add(a[bottomRow][col]);
        }
        // left column
        for (int row = bottomRow; row > topRow; row--) {
            result.add(a[row][leftCol]);
        }
        return result;
    }
}
