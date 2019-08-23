package arrays;

import com.sun.tools.javac.util.Pair;

import java.util.*;

/**
 * In an unsorted array, find pairs of array elements
 * that sum to a given value.
 */
public final class SumPairsInUnsortedArray {
    private SumPairsInUnsortedArray() {}

    /**
     * In an unsorted array, find pairs of array elements
     * that sum to a given value.
     *
     * Algorithm: Iterate thru the array, using a Set called
     * 'seen' to remember the elements we've already seen.
     *
     * For each element n, determine whether we've already
     * seen the element (sum - n). If so, then add the pair
     * (n, sum - n) to our result list.
     *
     * In any case, add the element n to our 'seen' Set.
     *
     * Running time: O(n)
     *
     * @param a The sorted array to search for pairs.
     * @param sum The value to which each pair of elements should sum.
     */
    public static List<Pair<Integer, Integer>>
    findPairs(int[] a, int sum) {
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int n : a) {
            if (seen.contains(sum - n)) {
                pairs.add(new Pair(n, sum - n));
            }
            seen.add(n);
        }
        return pairs;
    }

    public static void test() {
        System.out.println();
        System.out.println("Test sumPairsInUnsortedArray():");
        System.out.println("===============================");

        int a[] = {-2, -1, 0, 3, 5, 6, 6, 7, 9, 13, 14};

        a = ShuffleArray.shuffleArray(a);
        System.out.println("unsorted array = " + Arrays.toString(a));

        int sum = 12;

        List<Pair<Integer, Integer>> pairs =
            SumPairsInUnsortedArray.findPairs(a, sum);

        for (Pair<Integer, Integer> pair : pairs) {
            int p1 = pair.fst;
            int p2 = pair.snd;
            assert(p1 + p2 == sum);
            System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
        }
    }
}
