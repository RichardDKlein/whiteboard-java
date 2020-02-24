package com.whiteboard;

/**
 * Get bit.
 */
public class GetBit {
    /**
     * Get the value (0 or 1) of the specified bit of the
     * specified int.
     *
     * @param n The int of interest.
     * @param bit The bit to get (where 0 = LSB).
     * @return The value (0 or 1) of the specified bit.
     */
    public int getBit(int n, int bit) {
        return ((n & (1 << bit)) == 0) ? 0 : 1;
    }
}
