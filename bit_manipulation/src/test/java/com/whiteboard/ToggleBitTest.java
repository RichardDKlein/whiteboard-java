package com.whiteboard;

import org.junit.jupiter.api.Test;

class ToggleBitTest {
    @Test
    void toggleBitTest() {
        System.out.println();
        System.out.println("Test ToggleBit:");
        System.out.println("===============");

        int[] expected1 = {
                0b00000000000000000000000000000001,
                0b00000000000000000000000000000011,
                0b00000000000000000000000000000111,
                0b00000000000000000000000000001111,
                0b00000000000000000000000000011111,
                0b00000000000000000000000000111111,
                0b00000000000000000000000001111111,
                0b00000000000000000000000011111111,
                0b00000000000000000000000111111111,
                0b00000000000000000000001111111111,
                0b00000000000000000000011111111111,
                0b00000000000000000000111111111111,
                0b00000000000000000001111111111111,
                0b00000000000000000011111111111111,
                0b00000000000000000111111111111111,
                0b00000000000000001111111111111111,
                0b00000000000000011111111111111111,
                0b00000000000000111111111111111111,
                0b00000000000001111111111111111111,
                0b00000000000011111111111111111111,
                0b00000000000111111111111111111111,
                0b00000000001111111111111111111111,
                0b00000000011111111111111111111111,
                0b00000000111111111111111111111111,
                0b00000001111111111111111111111111,
                0b00000011111111111111111111111111,
                0b00000111111111111111111111111111,
                0b00001111111111111111111111111111,
                0b00011111111111111111111111111111,
                0b00111111111111111111111111111111,
                0b01111111111111111111111111111111,
                0b11111111111111111111111111111111
        };

        int[] expected2 = {
                0b11111111111111111111111111111110,
                0b11111111111111111111111111111100,
                0b11111111111111111111111111111000,
                0b11111111111111111111111111110000,
                0b11111111111111111111111111100000,
                0b11111111111111111111111111000000,
                0b11111111111111111111111110000000,
                0b11111111111111111111111100000000,
                0b11111111111111111111111000000000,
                0b11111111111111111111110000000000,
                0b11111111111111111111100000000000,
                0b11111111111111111111000000000000,
                0b11111111111111111110000000000000,
                0b11111111111111111100000000000000,
                0b11111111111111111000000000000000,
                0b11111111111111110000000000000000,
                0b11111111111111100000000000000000,
                0b11111111111111000000000000000000,
                0b11111111111110000000000000000000,
                0b11111111111100000000000000000000,
                0b11111111111000000000000000000000,
                0b11111111110000000000000000000000,
                0b11111111100000000000000000000000,
                0b11111111000000000000000000000000,
                0b11111110000000000000000000000000,
                0b11111100000000000000000000000000,
                0b11111000000000000000000000000000,
                0b11110000000000000000000000000000,
                0b11100000000000000000000000000000,
                0b11000000000000000000000000000000,
                0b10000000000000000000000000000000,
                0b00000000000000000000000000000000
        };

        int n = 0;
        BitTestUtils.printBits(n);

        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggleBit(n, i);
            assert(n == expected1[i]);
            BitTestUtils.printBits(n);
        }
        for (int i = 0; i < Integer.SIZE; ++i) {
            n = ToggleBit.toggleBit(n, i);
            assert(n == expected2[i]);
            BitTestUtils.printBits(n);
        }
    }
}
