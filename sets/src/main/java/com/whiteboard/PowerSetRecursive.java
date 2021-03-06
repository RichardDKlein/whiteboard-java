package com.whiteboard;

import java.util.*;

/**
 * Compute the power set of a set, i.e. the set of all subsets of
 * that set, using a recursive approach.
 */
public final class PowerSetRecursive {
    private PowerSetRecursive() {
    }

    public static <E> Set<Set<E>> powerSetRecursive(Set<E> set) {
        Set<Set<E>> result = new HashSet<>();
        // base case
        if (set.isEmpty()) {
            Set<E> emptySet = new HashSet<>();
            result.add(emptySet);
            return result;
        }
        // recursive step
        List<E> setList = new ArrayList<>(set);
        E firstElement = setList.remove(0);
        Set<E> remainderSet = new HashSet<>(setList);
        Set<Set<E>> remainderPowerSet = powerSetRecursive(remainderSet);
        for (Set<E> remainderSubset : remainderPowerSet) {
            Set<E> remainderSubsetCopy = new HashSet<>(remainderSubset);
            result.add(remainderSubsetCopy);
            remainderSubset.add(firstElement);
            result.add(remainderSubset);
        }
        return result;
    }
}
