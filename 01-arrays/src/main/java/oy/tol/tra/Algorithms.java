package oy.tol.tra;

public class Algorithms {
    public static <T extends Comparable<T>> void sort(T[] array) {
        // implementation here...
        quickSort(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> void reverse(T[] array) {
        int i = 0;
        while (i < array.length/2) {
           T temp = array[i];
           array[i] = array[array.length-i-1];
           array[array.length-i-1] = temp;
           i++;
       }
     }

    public static <E extends Comparable<E>> void fastSort(E[] array, int begin, int end) {
        quickSort(array, 0, array.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
        // implement Quicksort here...
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
        // implement partition here...
        E pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    public static <E extends Comparable<E>> void swap(E[] nums, int i, int j) {
        E temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}