package com.whiteboard;

import java.util.*;

/**
 * Find the 'k' most frequently occurring strings in a list
 * of strings, along with the number of times they occur.
 */
public final class TopKStrings {
    private TopKStrings() {
    }

    private static class StringCountEntryComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    }

    private static List<String> strings;
    private static int k;

    private static Map<String, Integer> stringCounts = new HashMap<>();

    private static PriorityQueue<Map.Entry<String, Integer>> minHeap =
            new PriorityQueue<>(new StringCountEntryComparator());

    /**
     * Find the 'k' most frequently occurring strings in a list of
     * strings, along with the number of times they occur.
     *
     * @param strings The list of strings.
     * @param k A small (relative to the length of 'strings') integer.
     * @return The 'k' most frequently occurring strings in 'strings',
     * along with the number of times they occur.
     */
    public static List<Map.Entry<String, Integer>> topKStrings (List<String> strings, int k) {
        saveCallingParameters(strings, k);
        countStrings();
        buildMinHeap();
        return extractResults();
    }

    private static void saveCallingParameters(List<String> strings, int k) {
        TopKStrings.strings = strings;
        TopKStrings.k = k;
    }

    private static void countStrings() {
        for (String s : strings) {
            Integer count = stringCounts.get(s);
            if (count == null) {
                stringCounts.put(s, 1);
            } else {
                stringCounts.put(s, count + 1);
            }
        }
    }

    private static void buildMinHeap() {
        for (Map.Entry<String, Integer> entry : stringCounts.entrySet()) {
            int count = entry.getValue();
            if (minHeap.isEmpty() || count >= minHeap.peek().getValue()) {
                minHeap.add(entry);
                while (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }
    }

    private static List<Map.Entry<String, Integer>> extractResults() {
        LinkedList<Map.Entry<String, Integer>> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll());
        }
        return result;
    }
}
