package algorithm;

import java.util.ArrayList;

class KadanesAlgorithm {

    public static int maxSubArray(int[] nums, ArrayList<Integer> subarray) {
        int maxSumSoFar = Integer.MIN_VALUE, maxEndHere = 0;
        int startIndexSubArray = 0;
        for (int i = 0; i < nums.length; i++) {
            maxEndHere += nums[i];

            if (maxEndHere > maxSumSoFar) {
                subarray.clear();
                maxSumSoFar = maxEndHere;
                subarray.add(startIndexSubArray);
                subarray.add(i);
            }
            if (maxEndHere < 0) {
                //Reset sum for subarray
                maxEndHere = 0;
                //i+1 because i is not incremented yet as loop is not finished.
                //Reset start index of sub array
                startIndexSubArray = i + 1;

            }
        }

        return maxSumSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        ArrayList<Integer> subarray = new ArrayList<>();
        int lon = maxSubArray(arr, subarray);
        System.out.println("The longest subarray with maximum sum is " + lon);
        System.out.println("The subarray is ");
        for (int i = subarray.get(0); i <= subarray.get(1); i++) {
            System.out.print(arr[i] + " ");
        }

    }
}