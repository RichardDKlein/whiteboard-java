package com.whiteboard;

/**
 * Determine the bit difference between two ints.
 */
public final class BitDiff {
    private BitDiff() {
    }

    /**
     * Determine the bit difference between two ints, i.e.
     * the number of bits that must be toggled to transform
     * one int into the other.
     *
     * @param m One of the ints to compare.
     * @param n The other int to compare.
     * @return The bit difference.
     */
    public static int bitDiff(int m, int n) {
        return countOneBits(m ^ n);
    }

    private static int countOneBits(int n) {
        int result = 0;
        while (n != 0) {
            n = clearLeastSignificantOneBit(n);
            ++result;
        }
        return result;
    }

    private static int clearLeastSignificantOneBit(int n) {
        return n & (n - 1);
    }
}
