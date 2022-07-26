package Calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        // init();
        System.out.println("Le resultat est : " + computeComplexMath("1-1+2+1+1"));
        // System.out.println(computeSimpleMath("2.0+1"));


    }

    public static void init() {
        System.out.println("--- SIMPLE CALCULATOR ---");
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez l'operation . Exple : 14/45 , 14+56 , 45-8 ..etc");
        String a = input.nextLine();
        input.close();
        a = removeBlank(a);
        if (correctOperation(a) && matchParentheses(a)) {
            System.out.println("Good maths expression");
            Operation op = splitOperation(a);
            double result = compute(op.getFirstOperand(), op.getSign(),
                    op.getSecondOperand());
            System.out.println("Le resultat est " + result);

        } else {
            System.out.println("Expression mathematique incorrecte!");
        }
    }

    public static String computeSimpleMath(String operation) {
        Operation op = splitOperation(operation);
        double result = compute(op.getFirstOperand(), op.getSign(),
                op.getSecondOperand());
        return Double.toString(result);
    }

    public static String computeComplexMath(String operation) {
        // We stop when there is nothing left to compute
        if (hasNoSign(operation)) {
            return operation;
            // System.out.println("Yes we encounter something simple");
            // return computeSimpleMath(operation);
        }

        StringBuilder operationBuilder = new StringBuilder(operation);
        for (int i = 0; i <= operationBuilder.length() - 1; i++) {
            int start = 0;
            int end = 0;
            if (operationBuilder.charAt(i) == '/' || operationBuilder.charAt(i) == '*'
                    || operationBuilder.charAt(i) == '+' || operationBuilder.charAt(i) == '-') {

                StringBuilder firstOperand = new StringBuilder();
                char sign = operationBuilder.charAt(i);
                StringBuilder secondOperand = new StringBuilder();

                // Extracting the first operand
                int j = i - 1;
                while (j >= 0 && isANumberOrDot(operationBuilder.charAt(j))) {
                    firstOperand.append(operationBuilder.charAt(j));
                    j--;
                }
                start = j + 1;

                // Extracting the second operand
                int k = i + 1;
                while (k <= operationBuilder.length() - 1 && isANumberOrDot(operationBuilder.charAt(k))) {
                    secondOperand.append(operationBuilder.charAt(k));
                    k++;
                }
                end = k - 1;

                // Compute the sub operation
                String subOperation = firstOperand.toString() + sign + secondOperand.toString();
                System.out.println("Sub operation " + subOperation);
                subOperation = computeSimpleMath(subOperation);

                // Remove the operation we just compute from the string
                operation = removePartOfString(operation, start, end + 1);
                System.out.println("Operation without the operation just compute " + operation);
                // Add the result to the string
                operation = addSubstringToString(operation, start, subOperation);
                System.out.println("Operation with the result of the previous operation " + operation);

                return computeComplexMath(operation);

            }

        }

        // Recursive call
        System.out.println("New operation we have " + operation);
        return computeComplexMath(operation);

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
        operation = removeParentheses(operation);
        String[] splitted = operation.split("[+/*-]");
        Operation op = new Operation();
        op.setFirstOperand(splitted[0]);
        op.setSign(extractSign(operation));
        op.setSecondOperand(splitted[1]);

        return op;
    }

    public static String removeParentheses(String str) {
        StringBuilder strB = new StringBuilder(str);
        if (strB.charAt(0) == '(')
            strB.deleteCharAt(0);
        if (strB.charAt(strB.length() - 1) == ')')
            strB.deleteCharAt(strB.length() - 1);

        return strB.toString();
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
        StringBuilder masterStr = new StringBuilder(str);
        int totalOpenParen = 0;
        int totalCloseParen = 0;
        for (int i = 0; i < masterStr.length(); i++) {
            if (masterStr.charAt(i) == '(') {
                totalOpenParen++;
            }
            if (masterStr.charAt(i) == ')') {
                totalCloseParen++;
            }
        }
        return totalCloseParen == totalOpenParen;
    }

    public static Boolean isANumberOrDot(char character) {
        StringBuilder str = new StringBuilder();
        str.append(character);
        String string = str.toString();
        return string.matches("[\\d.]");
    }

    public static String removePartOfString(String str, int start, int end) {
        StringBuilder strB = new StringBuilder(str);
        strB.delete(start, end);
        return strB.toString();
    }

    public static String addSubstringToString(String str, int offset, String substring) {
        StringBuilder strB = new StringBuilder(str);
        strB.insert(offset, substring);
        return strB.toString();
    }

    public static Boolean isSimpleOperation(String str) {
        return str.matches("[\\d.]+[+/*-][\\d.]+");
    }

    public static Boolean hasNoSign(String str) {
        return !str.matches(".*[+/*-].*");
    }

}
