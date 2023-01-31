import java.util.HashSet;
import java.util.Set;

/*

Write a method & algorithm that any 0 present will have its column and row set to 0 as well

Example:
Given a two dimensional array, such as:

 3 2 1 4 6
 7 5 0 1 0
 5 2 3 8 2
 0 1 6 9 5

The output would be:

 0 2 0 4 6
 0 0 0 0 0
 0 2 0 8 2
 0 0 0 0 0

 Do it IN PLACE

*/
public class MakeZeroColumnAndRow {

    private static int[][] makeZeroColumnAndRow(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        Set<String> tempSet = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (arr[i][j] == 0) {
                    tempSet.add("row:" + i);
                    tempSet.add("column:" + j);
                }
            }
        }

        for (String str : tempSet) {
            String[] strArr = str.split(":");

            if (strArr[0].startsWith("row")) {
                int row1 = Integer.parseInt(strArr[1]);
                int j = 0;
                while (j < column) {
                    arr[row1][j] = 0;
                    j++;
                }
            }
            if (strArr[0].startsWith("column")) {
                int column1 = Integer.parseInt(strArr[1]);
                int j = 0;
                while (j < row) {
                    arr[j][column1] = 0;
                    j++;
                }
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 2, 1, 4, 6},
            {7, 5, 0, 1, 0},
            {5, 2, 3, 8, 2},
            {0, 1, 6, 9, 5}};
        int[][] returnedOutput = makeZeroColumnAndRow(arr);
        for (int i = 0; i < returnedOutput.length; i++) {
            for (int j = 0; j < returnedOutput[0].length; j++) {
                System.out.print(returnedOutput[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
