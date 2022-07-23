// Java implementation of QuickSort
/*
* Time taken by QuickSort, in general, can be written as following.

 T(n) = T(k) + T(n-k-1) + \theta          (n)

The first two terms are for two recursive calls, the last term is for the partition process. k is
the number of elements which are smaller than pivot.
The time taken by QuickSort depends upon the input array and partition strategy. Following are three
cases.

Worst Case:
The worst case occurs when the partition process always picks greatest or smallest element as pivot.
If we consider above partition strategy where last element is always picked as pivot, the worst case
would occur when the array is already sorted in increasing or decreasing order. Following is
recurrence for worst case.

 T(n) = T(0) + T(n-1) + \theta          (n)which is equivalent to  T(n) = T(n-1) + \theta (n)

The solution of above recurrence is               (n2).

Best Case:
The best case occurs when the partition process always picks the middle element as pivot.
 Following is recurrence for best case.

 T(n) = 2T(n/2) + \theta(n)

The solution of above recurrence is (nLogn). It can be solved using case 2 of Master Theorem.

Average Case:
To do average case analysis, we need to consider all possible permutation of array and calculate
time taken by every permutation which doesn’t look easy.
We can get an idea of average case by considering the case when partition puts O(n/9) elements in
one set and O(9n/10) elements in other set. Following is recurrence for this case.

 T(n) = T(n/9) + T(9n/10) + \theta          (n)

The solution of above recurrence is also O(nLogn):

Although the worst case time complexity of QuickSort is O(n2) which is more than many other sorting
algorithms like Merge Sort and Heap Sort, QuickSort is faster in practice, because its inner loop
can be efficiently implemented on most architectures, and in most real-world data. QuickSort can be
implemented in different ways by changing the choice of pivot, so that the worst case rarely occurs
for a given type of data. However, merge sort is generally considered better when data is huge and
stored in external storage.
*
* */

class QuickSort {

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
    the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
    to left of pivot and all greater elements to right
    of pivot */
    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
        arr[] --> Array to be sorted,
        low --> Starting index,
        high --> Ending index
    */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to print an array
    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
