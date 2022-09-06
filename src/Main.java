import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import implement.BoxedItem;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(printHarmonic(4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // public static int computeMatrixitems(int[][] matrix) {
        
    // }

    public static double printHarmonic(int n) {
        if (n == 1) {
            return 1;
        } else {
            return printHarmonic(n - 1) + 1.0 / n;
        }
    }

    public static void generateRandom() {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        boolean i = rand.nextBoolean();

        System.out.println(i);
    }

    // Generic helps to create methods for any object
    public static <T> T[] swap(T[] array) {
        T temp = array[0];
        array[0] = array[1];
        array[1] = temp;
        return array;
    }

    public static void fuckIt(int a) {
        if (a == 0)
            throw new IllegalArgumentException("Stupid");
        System.out.println("Yeah, i will be a billionniare in dollars");
    }

    public static Boolean isMultiple(long n, long m) {
        return n % m == 0;
    }

    public static Boolean isEven(int n) {
        if (n == 0)
            return true;
        if (n == 1)
            return false;

        while (n != 0 && n != 1) {
            n -= 2;
        }

        return n == 0;
    }

    public static int sumInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int sumOddInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                continue;
            sum += i;
        }
        return sum;
    }

    public static int sumSquareInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    public static String removePunctuation(String strArg) {
        char[] punctuations = { '\'', ',', ',', '?', ':', ';', '!', '<', '>' };
        StringBuilder str = new StringBuilder();
        StringBuilder outputStr = new StringBuilder();
        str.append(strArg);
        for (int i = 0; i < str.length(); i++) {
            if (!findCharInArray(punctuations, str.charAt(i))) {
                outputStr.append(str.charAt(i));
            }
        }
        return outputStr.toString();
    }

    public static Boolean findCharInArray(char[] chars, char character) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == character) {
                return true;
            }
        }
        return false;
    }

    public static int[] reverseIntArray(int[] arr) {
        if (arr.length == 0 || arr.length == 1)
            return arr;

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        printIntArray(arr);
        return arr;
    }

    public static void printIntArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int findSmallestInInteger(int[] arr) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        int smallest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }

        return smallest;
    }

    public static int findlargestInInteger(int[] arr) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        int largest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static Boolean checkCorrectArithmeticFormula() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the first number");
        int a = input.nextInt();
        System.out.println("Input the second number");
        int b = input.nextInt();
        System.out.println("Input the third number");
        int c = input.nextInt();
        input.close();

        Boolean canBeUsed = false;

        if (a + b == c || a == b - c || a * b == c) {
            canBeUsed = true;
            System.out.println("Yes it is OK!");
        } else {
            System.out.println("Oh no , this is impossible");
        }

        return canBeUsed;
    }

    public static Boolean haveDistinctEvenPair(int[] arr) {
        Boolean haveIt = false;
        if (arr.length == 0 || arr.length == 1)
            return false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] != arr[j] && arr[i] * arr[j] % 2 == 0) {
                    haveIt = true;
                    break;
                }
            }
            if (haveIt)
                break;
        }
        return haveIt;
    }

    public static double norm(int[] v, int p) {
        if (v.length == 0)
            return 0;

        int coordinatesSquares = 0;
        for (int coord : v) {
            coordinatesSquares += Math.pow(coord, p);
        }
        return Math.pow(coordinatesSquares, (double) 1 / p);
    }

    public static int numberOfDivisionsToGetTwo(int a) {
        if (a < 2)
            return 0;
        int totalTimes = 0;
        while (a >= 2) {
            a = a / 2;
            totalTimes++;
        }
        System.out.println("Total times ," + totalTimes);
        return totalTimes;
    }

    public static Boolean allItemsDistinct(float[] arr) {
        Boolean sameItems = false;
        if (arr.length == 0 || arr.length == 1)
            return true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    sameItems = true;
                    break;
                }
            }
            if (sameItems)
                break;
        }
        return sameItems;
    }

    public static void generateString() {
        StringBuilder str = new StringBuilder("123");
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                StringBuilder strToOutput = str;
                char temp = str.charAt(i);
                if (i != j) {
                    strToOutput.setCharAt(i, str.charAt(j));
                    strToOutput.setCharAt(j, temp);
                    System.out.println(strToOutput);
                }

            }
        }
    }

    public static int[] productArray(int[] a, int[] b, int length) {
        if (a.length < length || b.length < length)
            return new int[0];
        int[] c = new int[length];
        for (int i = 0; i < length; i++) {
            c[i] = a[i] * b[i];
        }
        return c;
    }

    public static void reverselines() {
        Scanner input = new Scanner(System.in);
        String l1 = input.nextLine();
        String l2 = input.nextLine();
        String l3 = input.nextLine();
        input.close();

        System.out.println(l3);
        System.out.println(l2);
        System.out.println(l1);
    }

    public static void printSentence() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + " - I will never spam my friends again");
        }
    }
    // Learn how to create Vs Code snippet
    // Master regular expression
}
