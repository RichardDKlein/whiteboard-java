package com.whiteboard.java;

import java.util.Set;

public final class SetTestUtils {
    private SetTestUtils() {
    }

    static <E> void printSet(Set<E> set) {
        System.out.print("{ ");
        for (E element : set) {
            System.out.print(element + " ");
        }
        System.out.println("}");
    }

    static <E> void printPowerSet(Set<Set<E>> powerSet) {
        System.out.println("{");
        for (Set<E> set : powerSet) {
            System.out.print("\t");
            printSet(set);
        }
        System.out.println("}");
    }
}
