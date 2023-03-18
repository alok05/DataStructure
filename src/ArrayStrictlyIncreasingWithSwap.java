/*
You are given an array of non-negative integers numbers. You are allowed to choose any number from this array and swap any two digits in it. If after the swap operation the number contains leading zeros, they can be omitted and not considered (eg: 010 will be considered just 10).

Your task is to check whether it is possible to apply the swap operation at most once, so that the elements of the resulting array are strictly increasing.

Example

For numbers = [1, 5, 10, 20], the output should be solution(numbers) = true.

The initial array is already strictly increasing, so no actions are required.

For numbers = [1, 3, 900, 10], the output should be solution(numbers) = true.

By choosing numbers[2] = 900 and swapping its first and third digits, the resulting number 009 is considered to be just 9. So the updated array will look like [1, 3, 9, 10], which is strictly increasing.

For numbers = [13, 31, 30], the output should be solution(numbers) = false.

The initial array elements are not increasing.
By swapping the digits of numbers[0] = 13, the array becomes [31, 31, 30] which is not strictly increasing;
By swapping the digits of numbers[1] = 31, the array becomes [13, 13, 30] which is not strictly increasing;
By swapping the digits of numbers[2] = 30, the array becomes [13, 31, 3] which is not strictly increasing;
So, it's not possible to obtain a strictly increasing array, and the answer is false.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer numbers

An array of non-negative integers.

Guaranteed constraints:
1 ≤ numbers.length ≤ 103,
0 ≤ numbers[i] ≤ 103.

[output] boolean

Return true if it is possible to obtain a strictly increasing array by applying the digit-swap operation at most once, and false otherwise.
 */
public class ArrayStrictlyIncreasingWithSwap {
    boolean solution(int[] numbers) {
        boolean hasChanged = false;
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] > numbers[i-1]){
                continue;
            }
            if(numbers[i] < 10 && numbers[i-1] < 10){
                return false;
            }
            int before = i >= 2 ? numbers[i-2] : 0;
            if(swapNumberSuccess(before, numbers[i-1], numbers[i]) && (!hasChanged)){
                hasChanged = true;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean swapNumberSuccess(int number0, int number1, int number2){
        System.out.println(number1 + "," + number2);
        int min_1;
        if(number1 == 1000){
            min_1 = 1;
        }else if(number1/100 > 1){
            int d1 = number1/100;
            int d2 = (number1/10)%10;
            int d3 = number1%10;
            int d_min = Math.min(d1, Math.min(d2, d3));
            int d_max = Math.max(d1, Math.max(d2, d3));
            int d_mid = mid(d1, d2, d3, d_min, d_max);
            min_1 = 100 * d_min + 10 * d_mid + d_max;
            System.out.println(d_min + "," + d_mid + "," + d_max);
        }else if(number1/10 > 1){
            int d1 = number1/10;
            int d2 = number1%10;
            min_1 = Math.min(d1, d2)*10 + Math.max(d1, d2);
        }else{
            min_1 = number1;
        }
        System.out.println(min_1);
        if(min_1 < number2 && min_1 > number0){
            return true;
        }

        int max_2;
        if(number2 == 1000){
            max_2 = 1000;
        }else if(number2/100 > 1){
            int d1 = number2/100;
            int d2 = (number2/10)%10;
            int d3 = number2%10;
            int d_min = Math.min(d1, Math.min(d2, d3));
            int d_max = Math.max(d1, Math.max(d2, d3));
            int d_mid = mid(d1, d2, d3, d_min, d_max);
            max_2 = 100 * d_max + 10 * d_mid + d_min;
        }else if(number2/10 > 1){
            int d1 = number2/10;
            int d2 = number2%10;
            max_2 = Math.max(d1, d2)*10 + Math.min(d1, d2);
        }else{
            max_2 = number2;
        }
        System.out.println(max_2);
        if(max_2 > number1){
            return true;
        }
        return false;
    }

    private int mid(int n1, int n2, int n3, int d_min, int d_max){
        if(n1 < d_max && n1 > d_min){
            return n1;
        }
        if(n2 < d_max && n2 > d_min){
            return n2;
        }
        return n3;
    }

    public static void main(String[] args) {
        ArrayStrictlyIncreasingWithSwap asiwp = new ArrayStrictlyIncreasingWithSwap();
        int [] arr = {1, 5, 10, 20};
        System.out.println(asiwp.solution(arr));
        arr = new int[]{1, 3, 900, 10};
        System.out.println(asiwp.solution(arr));
        arr = new int[]{13, 31, 30};
        System.out.println(asiwp.solution(arr));
    }
}
