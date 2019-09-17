package arrays;

/**
 * Implement the "flood fill" algorithm to fill a region
 * in a 2D array, using a recursive approach.
 */
public final class FloodFillRecursive {
    private FloodFillRecursive() {}

    /**
     * Implement the "flood fill" algorithm to fill a region
     * in a 2D bitmap, using a recursive approach.
     *
     * The execution time is O(m * n) worst case, where m and
     * n are the number of rows and columns, respectively, in
     * the 2D array.
     *
     * However, the space requirements (for the call stack)
     * are also O(m * n), due to the recursive nature of the
     * algorithm. Yuck.
     *
     * For an algorithm with more modest space requirements,
     * see the FloodFillBFS class.
     *
     * @param a The 2D bitmap to be filled. An element of ' '
     *          denotes an empty pixel. An element of '@' denotes
     *          a filled pixel, which should also be interpreted
     *          as a boundary that the flood-fill algorithm is
     *          not allowed to cross. This bitmap is to be updated
     *          by the flood-fill algorithm.
     * @param x The x-coordinate of the "seed" pixel, at which
     *          the flood fill is to start.
     * @param y The y-coordinate of the seed pixel.
     */
    public static void floodFillRecursive(
            char[][] a, int x, int y) {
        int rows = a.length;
        int cols = a[0].length;
        if (x < 0 || y < 0 || x >= cols || y >= rows) {
            return;
        }
        if (a[y][x] == ' ') {
            a[y][x] = '@';
        } else {
            return;
        }
        floodFillRecursive(a, x - 1, y);
        floodFillRecursive(a, x, y - 1);
        floodFillRecursive(a, x + 1, y);
        floodFillRecursive(a, x, y + 1);
    }

    public static void test() {
        System.out.println();
        System.out.println("Test floodFillRecursive():");
        System.out.println("==========================");

        char[][] a = {
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',},
            {' ',' ',' ',' ',' ',' ',' ',' ','@','@','@','@','@','@','@',' ',},
            {' ',' ','@','@','@','@',' ',' ','@',' ',' ',' ',' ',' ','@',' ',},
            {' ',' ','@',' ',' ','@',' ',' ','@',' ',' ',' ',' ',' ','@',' ',},
            {' ',' ','@',' ',' ','@',' ',' ','@',' ',' ',' ',' ',' ','@',' ',},
            {' ',' ','@',' ',' ','@',' ',' ','@','@','@','@','@','@','@',' ',},
            {' ',' ','@',' ',' ','@',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',},
            {' ',' ','@',' ',' ','@',' ',' ',' ',' ','@',' ',' ',' ',' ',' ',},
            {' ',' ','@',' ',' ','@',' ',' ',' ','@',' ','@',' ',' ',' ',' ',},
            {' ',' ','@','@','@','@',' ',' ','@',' ',' ',' ','@',' ',' ',' ',},
            {' ',' ',' ',' ',' ',' ',' ','@',' ',' ',' ',' ',' ','@',' ',' ',},
            {' ',' ',' ',' ',' ',' ','@','@','@','@','@','@','@','@','@',' ',},
            {' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',}
        };

        int[] x = {
            1,
            4,
            12,
            8,
            10
        };
        int[] y = {
            1,
            4,
            3,
            7,
            9
        };
        int rows = a.length;
        int cols = a[0].length;
        char[][] copy = new char[rows][cols];
        for (int i = 0; i < x.length; ++i) {
            System.out.println("\nBEFORE flood fill:");
            printBitmap(a, x[i], y[i]);
            copyBitmap(a, copy);
            floodFillRecursive(copy, x[i], y[i]);
            System.out.println("\nAFTER flood fill:");
            printBitmap(copy, -1, -1);
        }
    }

    private static void copyBitmap(char[][] original, char[][] copy) {
        int rows = original.length;
        int cols = original[0].length;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                copy[row][col] = original[row][col];
            }
        }
    }

    private static void printBitmap(char[][] a, int x, int y) {
        int rows = a.length;
        int cols = a[0].length;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (row == y && col == x) {
                    System.out.print('S');
                } else {
                    System.out.print(a[row][col]);
                }
            }
            System.out.println();
        }
    }
}