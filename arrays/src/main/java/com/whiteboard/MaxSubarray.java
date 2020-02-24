package com.whiteboard;

import javafx.util.Pair;

/**
 * In an array of positive and negative integers, find
 * the subarray whose elements sum to the maximum value.
 */
public class MaxSubarray {
    /**
     * In an array of positive and negative integers, find
     * the subarray whose elements sum to the maximum value.
     *
     * We could use a brute-force approach, but that would
     * have a running time of O(n * n).
     *
     * Instead, we shall use the Kadane algorithm. Let a[]
     * be our integer array, and let S(i) be the maximum
     * subarray whose endpoint is a[i]. Note that S(i)
     * can be computed easily from S(i - 1), as follows.
     *
     * If S(i - 1) is positive (or zero), then S(i) is
     * S(i - 1) + a[i], where the '+' operator here denotes
     * concatenation. To see this, note that if we chose
     * any element other than the starting element of
     * S(i - 1), we would get a smaller sum. Why? Because
     * S(i - 1) is the maximum subarray ending at a[i - 1].
     *
     * Now suppose S(i - 1) is negative. Then S(i) is simply
     * the single element a[i]. For regardless of whether
     * a[i] is positive or negative, the sum S(i - i) + a[i]
     * will be smaller than just a[i] by itself.
     *
     * The algorithm consists of simply iterating thru a[],
     * computing a[i] from a[i - 1], and keeping track of
     * the maximum.
     *
     * The execution time is O(n).
     *
     * @param a The array whose maximum subarray is to be
     *          found.
     * @return A pair of integers containing the starting
     * and ending indices of the maximum subarray.
     */
    public Pair<Integer, Integer> maxSubarray(int[] a) {
        int start, maxStart, end, maxEnd, sum, maxSum;
        start = maxStart = end = maxEnd = 0;
        sum = maxSum = a[0];
        for (int i = 1; i < a.length; ++i) {
            end = i;
            if (sum >= 0) {
                sum += a[i];
            } else {
                start = i;
                sum = a[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxStart = start;
                maxEnd = end;
            }
        }
        return new Pair<>(maxStart, maxEnd);
    }
}