package array;// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Your algorithm should run in O(n) complexity.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ArrayLongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums) {
            set.add(num);
        }
        
        int maxLength = 0;
        List<Integer> integerList = new ArrayList<>();
        for(int num: set) {
            if(!set.contains(num - 1)) {
                int current = num;
                int currentMax = 1;

                List<Integer> integers = new ArrayList<>();
                integers.add(num);

                while(set.contains(num + 1)) {
                    currentMax++;
                    num++;
                    integers.add(num);
                }
                if(integers.size() > integerList.size()){
                    integerList = integers;
                }
                maxLength = Math.max(maxLength, currentMax);
            }
        }
        System.out.println(Arrays.toString(integerList.toArray()));
        return maxLength;
    }

    public static void main(String[] args) {
        int arr [] = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }
}