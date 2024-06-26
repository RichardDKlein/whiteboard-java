package com.whiteboard.java;

import java.util.*;

public final class SumOfSquares {
    /**
     * Find all integers a, b, c, d that are in the range [0..n],
     * and that satisfy the equation a*a + b*b == c*c + d*d.
     *
     * The brute force solution is O(n*n*n*n), but we can do better.
     * First, we find all possible pairs {a,b} that satisfy each possible
     * sum of squares (a*a + b*b). Then, for each sum, we simply generate
     * all possible permutations of two of those pairs. This solution is
     * O(n*n).
     *
     * @param n The upper limit of the range containing a, b, c, and d.
     * @return A set of all possible 4-tuples {a, b, c, d} in the range
     * [0..n] that satisfy the equation a*a + b*b == c*c + d*d.
     */
    public static Set<int[]> sumOfSquares(int n) {
        Set<int[]> result = new HashSet<>();
        Map<Integer, Set<int[]>> squares = new HashMap<>();
        for (int i =0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int square = (i * i) + (j * j);
                squares.computeIfAbsent(square, k -> new HashSet<>()).add(new int[] {i, j});
            }
        }
        for (Set<int[]> pairs : squares.values()) {
            for (int[] pair1 : pairs) {
                for (int[] pair2 : pairs) {
                    result.add(new int[] {pair1[0], pair1[1], pair2[0], pair2[1]});
                }
            }
        }
        return result;
    }
}
