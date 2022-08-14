package array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        matrix();
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

    public static void matrix() {
        int[] matrix = new int[10];
        matrix[0]=10;
        System.out.println(matrix[0]);
    }
}
