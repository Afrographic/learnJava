package Calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        calculator();
    }

    public static void calculator() {
        System.out.println("--- SIMPLE CALCULATOR ---");
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez l'operation . Exple : 14/45 , 14+56 , 45-8 ..etc");
        String a = input.nextLine();
        input.close();
        a = removeBlank(a);
        if (correctOperation(a)) {
            System.out.println("Good maths expression");
            // Operation op = splitOperation(a);
            // double result = compute(op.getFirstOperand(), op.getSign(),
            // op.getSecondOperand());
            // System.out.println("Le resultat est " + result);
        } else {
            System.out.println("Expression mathematique incorrecte!");
        }
    }

    public static double compute(double a, char sign, double b) {
        switch (sign) {
            case '/':
                return a / b;
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return 0;
        }
    }

    public static Operation splitOperation(String operation) {
        String[] splitted = operation.split("[+/*-]");
        Operation op = new Operation();
        op.setFirstOperand(splitted[0]);
        op.setSign(extractSign(operation));
        op.setSecondOperand(splitted[1]);

        return op;
    }

    public static String removeBlank(String str) {
        str = str.trim();
        StringBuilder strBuilder = new StringBuilder(str);
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) != ' ') {
                outputStr.append(strBuilder.charAt(i));
            }
        }
        return outputStr.toString();
    }

    public static Boolean correctOperation(String operation) {
        return operation.matches("(\\(*[.0-9+*/-]+\\)*)+");
    }

    public static char extractSign(String operation) {
        Pattern pattern = Pattern.compile(".*([+/*-]).*");
        Matcher matcher = pattern.matcher(operation);
        if (matcher.find()) {
            String sign = matcher.group(1);
            StringBuilder str = new StringBuilder(sign);
            return str.charAt(0);
        }
        return '+';
    }

    public static Boolean matchParentheses(String str) {
        Boolean matches = false;
        StringBuilder masterStr = new StringBuilder(str);
        // for(let )
        return matches;
    }

    
}
