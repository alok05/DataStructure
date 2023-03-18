public class ArraySearchInSorted2DMatrix {

    /**
     *
     * @param matrix
     * @param target
     * @return boolean
     * Time complexity: O(log(m*n))
     * Space complexity: O(1)
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        if(matrix.length == 0) return false;
        int row = matrix.length;
        int column = matrix[0].length;
        int high = (row * column) - 1;

        while(low <= high) {
            int middle = (low+high)/2;

            int divRow = middle/column;
            int remCol = middle % column;

            if(matrix[divRow][remCol] == target) {
                return true;
            }
            if(matrix[divRow][remCol] < target) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 3, 4}, {5, 6, 7}, {8, 10, 15}};
        searchMatrix(a, 7);
    }
}
