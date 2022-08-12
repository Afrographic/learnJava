package array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Arrays.fill(arr, 10);
        arr[0] = 100;
        arr[1] = 1;
        int a = Arrays.binarySearch(arr, 2);
        System.out.println(a);
        // System.out.println(arr[a]);
        // int[] sorted = insertionSort(arr);
        // System.out.println(Arrays.toString(sorted));
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    break;
                }
            }
        }
        return array;
    }
}
