package exercices.exo1;

public class Exo1main {
    public static void main(String[] args) {
        try {
            lol(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Don't try buffer overflow attacks in Java!");
        }

    }

    public static void lol(int a) {
        if (a == 0) {
            throw new IllegalArgumentException("Fuck it");
        }

        System.out.println("You look smart bitch!");
    }
}
