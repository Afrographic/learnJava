package array;

import java.util.Arrays;

import javax.crypto.IllegalBlockSizeException;

public class Array {
    public static void main(String[] args) throws IllegalBlockSizeException {
        int[][] a = new int[2][2];
        a[0][0] = 2;
        a[0][1] = 1;
        a[1][0] = 2;
        a[1][1] = 10;
        int[][] b = new int[2][2];
        b[0][0] = 3;
        b[0][1] = 11;
        b[1][0] = 45;
        b[1][1] = 4;
        int[][] c = multiplyMatrix(a, b);
        printIntMatrix(c);
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
