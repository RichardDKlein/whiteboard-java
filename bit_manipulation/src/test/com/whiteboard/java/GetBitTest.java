package com.whiteboard.java;

import org.junit.Test;

public class GetBitTest {
    @Test
    public void getBitTest() {
        System.out.println();
        System.out.println("Test GetBit:");
        System.out.println("============");

        int n = 0xAAAAAAAA;
        BitTestUtils.printBits(n);
        for (int i = 0; i < Integer.SIZE; ++i) {
            int bit = GetBit.getBit(n, i);
            assert(bit == i % 2);
            System.out.println("Bit " + i + " = " + bit);
        }
    }
}
