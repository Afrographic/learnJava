package array;

import java.util.Arrays;

import javax.crypto.IllegalBlockSizeException;

public class Array {
    public static void main(String[] args) {
        fibo(15);
    }

    public static void fibo(int n) {

        int result = 0;
        int[] temp = new int[2];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.println(0);
                temp[0] = 0;
                temp[1] = 0;
            } else if (i == 1) {
                System.out.println(1);
                temp[0] = 0;
                temp[1] = 1;

            } else {
                result =temp[0]+temp[1];
                System.out.println(result + ",");
                temp[0] = temp[1];
                temp[1] = result;
            }

        }
    }

    public static void recursiveReverse(int[] a, int thisItemIndex, int toThatItemIndex) {
        if (thisItemIndex < toThatItemIndex) {
            int temp = a[thisItemIndex];
            a[thisItemIndex] = a[toThatItemIndex];
            a[toThatItemIndex] = temp;
            recursiveReverse(a, thisItemIndex + 1, toThatItemIndex - 1);
        }
    }

    public static int recursiveSum(int[] a, int starterIndex) {
        if (starterIndex <= a.length - 1) {
            return a[starterIndex] + recursiveSum(a, starterIndex + 1);
        } else {
            return 0;
        }
    }

    public static boolean binarySearch(int low, int high, int target, int[] array) {
        int mid = (low + high) / 2;
        if (low == high) {
            return array[mid] == target;
        }
        if (array[mid] < target) {
            return binarySearch(mid + 1, high, target, array);
        } else {
            return binarySearch(low, mid - 1, target, array);
        }
    }

    public static int[][] addMatrix(int[][] a, int[][] b) throws IllegalBlockSizeException {
        if (a.length != b.length)
            throw new IllegalBlockSizeException("Arrays must be the same size");
        int[][] c = new int[a.length][a.length];
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = 0; j <= a.length - 1; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    public static int[][] multiplyMatrix(int[][] a, int[][] b) throws IllegalBlockSizeException {
        if (a.length != b.length)
            throw new IllegalBlockSizeException("Arrays must be the same size");
        int[][] c = new int[a.length][a.length];
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = 0; j <= a.length - 1; j++) {
                c[i][j] = a[i][j] * b[i][j];
            }
        }

        return c;
    }

    public static void printIntMatrix(int[][] a) {
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = 0; j <= a.length - 1; j++) {
                System.out.println(a[i][j]);
            }
        }
    }

    public static int findFiveRepeatedInteger() {
        int[] a = new int[8];
        a[0] = 2;
        a[1] = 1;
        a[2] = 1;
        a[3] = 1;
        a[4] = 1;
        a[5] = 1;
        a[6] = 7;
        a[7] = 7;
        for (int i = 0; i <= a.length - 1; i++) {
            int count = 1;
            for (int j = i + 1; j <= a.length - 1; j++) {
                if (a[i] == a[j]) {
                    count++;
                    if (count == 5) {
                        return a[i];
                    }
                }
            }
        }
        return -1;
    }

    public static int findRepeatedInteger() {
        int[] a = new int[4];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 3;
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = i + 1; j <= a.length - 1; j++) {
                if (a[i] == a[j]) {
                    return a[i];
                }
            }
        }
        return -1;
    }

    public static void copyArray() {
        int[] arr = new int[10];
        Arrays.fill(arr, 10);
        int[] b = Arrays.copyOf(arr, arr.length);

        b[1] = 15;
        System.out.println("value of arr " + arr[1]);
        System.out.println("value of b " + b[1]);
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
        matrix[0][1] = 10;
        System.out.println(matrix[0][1]);
    }

}
