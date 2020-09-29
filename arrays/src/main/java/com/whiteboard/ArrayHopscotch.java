package com.whiteboard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Play a game of "array hopscotch".
 */
public class ArrayHopscotch {
    private Set<Integer> visitedIndices_ = new HashSet<>();

    /**
     * Play a game of "array hopscotch".
     *
     * The game is played as follows. Given an array 'a'
     * containing integers greater than or equal to zero,
     * and a starting index 'i', hop left and right in the
     * array by the distance contained in a[i]. Then repeat
     * the process for the new elements you land on.
     *
     * Continue in this manner until you either land on a
     * zero element (i.e. you win the game), or you realize
     * that it is not possible to land on a zero element
     * (i.e. you lose the game).
     *
     * We shall use a recursive algorithm to play the game,
     * keeping track of elements we have visited. If we land
     * on a zero, we win. If we land on an element we have
     * already visited, we are stuck in an infinite loop,
     * and we lose.
     *
     * Since each element in the array is visited at most
     * once, the execution time is O(n), worst case.
     *
     * @param a The array in which we are to play "array
     *          hopscotch". You may assume that all the
     *          elements in the array are greater than or
     *          equal to zero.
     * @param iStart The starting index for our game of
     *              hopscotch.
     * @return A list containing a winning sequence of
     * indices that led to a zero. (If no such winning
     * sequence exists, then the list will be empty.)
     */
    public List<Integer> arrayHopscotch(int[] a, int iStart) {
        List<Integer> winningHops = new ArrayList<>();
        if (iStart < 0 || iStart > a.length - 1) {
            return winningHops;
        }
        if (visitedIndices_.contains(iStart)) {
            return winningHops;
        }
        if (a[iStart] == 0) {
            winningHops.add(iStart);
            return winningHops;
        }
        visitedIndices_.add(iStart);
        int iHopLeft = iStart - a[iStart];
        List<Integer> remainingHops = arrayHopscotch(a, iHopLeft);
        if (!remainingHops.isEmpty()) {
            winningHops.add(iStart);
            winningHops.addAll(remainingHops);
            return winningHops;
        }
        int iHopRight = iStart + a[iStart];
        remainingHops = arrayHopscotch(a, iHopRight);
        if (!remainingHops.isEmpty()) {
            winningHops.add(iStart);
            winningHops.addAll(remainingHops);
            return winningHops;
        }
        return winningHops;
    }
}
