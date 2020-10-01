package com.whiteboard;

import com.sun.tools.javac.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

class SumPairsInUnsortedArrayTest {

    @Test
    void sumPairsInUnsortedArray() {
        System.out.println();
        System.out.println("Test SumPairsInUnsortedArray:");
        System.out.println("=============================");

        int a[] = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};

        List<Integer> list = new ArrayList<>();
        for (int integer : a) {
            list.add(integer);
        }

        Shuffle<Integer> shuffle = new Shuffle<>();
        shuffle.shuffleList(list);
        for (int i = 0; i < a.length; ++i) {
            a[i] = list.get(i);
        }

        System.out.println("unsorted array = " + Arrays.toString(a));

        int sum = 12;

        Set<Pair<Integer, Integer>> pairs =
                SumPairsInUnsortedArray.sumPairsInUnsortedArray(a, sum);

        for (Pair<Integer, Integer> pair : pairs) {
            int p1 = pair.fst;
            int p2 = pair.snd;
            assert(p1 + p2 == sum);
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}
