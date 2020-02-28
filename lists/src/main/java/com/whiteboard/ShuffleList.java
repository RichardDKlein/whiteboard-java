package com.whiteboard;

import java.util.List;

/**
 * Shuffle a list.
 */
public class ShuffleList<E> {
    /**
     * Shuffle a list, as if it represented a deck of card.
     *
     * Algorithm: Iterate thru the list, swapping each element
     * with an element randomly chosen from the list elements
     * not yet visited.
     *
     * Running time: O(n)
     *
     * @param list The list to be shuffled.
     */
    public void shuffleList(List<E> list) {
        for (int i = 0; i < list.size() - 1; ++i) {
            int j = random(i + 1, list.size() - 1);
            E temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    /**
     * Return a random int in a given closed interval
     * [min, max].
     */
    public static int random(int min, int max) {
        double random0to1 = Math.random();
        double random0toMaxMinusMin = random0to1 * (max - min);
        int roundedRandom0toMaxMinusMin = (int)Math.round(random0toMaxMinusMin);
        int randomMinToMax = min + roundedRandom0toMaxMinusMin;
        return randomMinToMax;
    }
}
