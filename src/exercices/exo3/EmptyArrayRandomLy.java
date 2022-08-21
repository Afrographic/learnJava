package exercices.exo3;

import java.util.ArrayList;
import java.util.Random;

public class EmptyArrayRandomLy {
    public static void main(String[] args) {
        randomlyEmptyArray();
    }
    public static void randomlyEmptyArray() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0, 1);
        a.add(1, 2);
        a.add(2, 10);
        a.add(3, 11);
        a.add(4, 11);
        a.add(5, 11);
        a.add(6, 11);
        while (a.size() != 0) {
            int randomIndex = randomIntGenerator(0, a.size() - 1);
            System.out.println(a.get(randomIndex));
            a.remove(a.get(randomIndex));

        }

        System.out.println(a.size());
    }

    public static int randomIntGenerator(int min, int max) {
        Random rn = new Random();
        int range = max - min + 1;
        return rn.nextInt(range) + min;
    }
}
