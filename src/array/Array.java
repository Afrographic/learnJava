package array;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // System.out.println(arr[a]);
        // int[] sorted = insertionSort(arr);
        // System.out.println(Arrays.toString(sorted));

        int[] arr = new int[10];
        Arrays.fill(arr, 10);
        int[] b = Arrays.copyOf(arr,arr.length);

        b[1] = 15;
        System.out.println("value of arr "+arr[1]);
        System.out.println("value of b "+b[1]);
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
        int[][] matrix = new int[10][10];
        matrix[0][1]=10;
        System.out.println(matrix[0][1]);
    }
}
