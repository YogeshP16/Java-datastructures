public class OO1_Triangle_Recursion {
    public static void main(String[] args) {
        // Top-to-bottom triangle
        triangleTopToBottom(4, 0);
        System.out.println();

        // Bottom-to-top triangle
        triangleBottomToTop(4, 0);
    }

    /**
     * Prints a triangle pattern top-to-bottom
     * Example:
     * ****
     * ***
     * **
     * *
     * @param rows - remaining rows to print
     * @param cols - current column index
     */
    static void triangleTopToBottom(int rows, int cols) {
        if (rows == 0) return; // Base case: no rows left to print

        if (cols < rows) {
            System.out.print("*");
            triangleTopToBottom(rows, cols + 1); // Print next column
        } else {
            System.out.println();
            triangleTopToBottom(rows - 1, 0); // Move to next row
        }
    }

    /**
     * Prints a triangle pattern bottom-to-top
     * Example:
     * *
     * **
     * ***
     * ****
     * @param rows - remaining rows to print
     * @param cols - current column index
     */
    static void triangleBottomToTop(int rows, int cols) {
        if (rows == 0) return; // Base case: no rows left to print

        if (cols < rows) {
            triangleBottomToTop(rows, cols + 1); // Process next column first
            System.out.print("*");
        } else {
            triangleBottomToTop(rows - 1, 0); // Move to next row
            System.out.println();
        }
    }
}
