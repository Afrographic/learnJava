package Calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        init();

    }

    public static void init() {
        System.out.println("--- SIMPLE CALCULATOR ---");
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez l'operation 😏");
        String a = input.nextLine();
        input.close();
        a = removeBlank(a);
        if (correctOperation(a) && matchParentheses(a)) {

            if (haveParentheses(a)) {
                System.out.println("Compute complex Math with parentheses");
            } else {
                System.out.println("Voici le resultat : " + computeComplexMath(a));
            }

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
        if (isSimpleOperation(operation)) {
            System.out.println("Now it becomes a simple math");
            return computeSimpleMath(operation);
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

                // When the operation starts with a minus sign
                if ((sign == '-' && i == 0) || ((sign == '-' || sign == '+') && hasMultiOrDiv(operation))) {
                    continue;
                }

                // Extracting the first operand
                int j = i - 1;
                while (j >= 0) {

                    if (isASign(operationBuilder.charAt(j))) {
                        if (operationBuilder.charAt(j) == '-') {
                            firstOperand.append(operationBuilder.charAt(j));
                            j--;
                        }
                        break;
                    }

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

                String subOperation = firstOperand.reverse().toString() + sign + secondOperand.toString();
                subOperation = computeSimpleMath(subOperation);

                // Remove the operation we just compute from the string
                operation = removePartOfString(operation, start, end + 1);
                // Add the result to the string
                operation = addSubstringToString(operation, start, subOperation);
                // Get out of the loop
                break;

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
        StringBuilder operationB = new StringBuilder(operation);

        Operation op = new Operation();
        if (splitted.length == 2) {
            op.setFirstOperand(splitted[0]);
            op.setSign(extractSign(operation));
            op.setSecondOperand(splitted[1]);
        }
        if (splitted.length == 3) {
            op.setFirstOperand(operationB.charAt(0) + splitted[1]);
            op.setSign(extractSign(operation));
            op.setSecondOperand(splitted[2]);
        }

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

    public static Boolean haveParentheses(String str) {

        StringBuilder strB = new StringBuilder(str);
        for (int i = 0; i < strB.length(); i++) {
            if (strB.charAt(i) == '(' || strB.charAt(i) == ')') {
                return true;
            }
        }
        return false;
    }

    public static String extractParentheses(String str) {
        StringBuilder strB = new StringBuilder(str);
        StringBuilder parentheses = new StringBuilder();
        for (int i = 0; i < strB.length(); i++) {
            if (strB.charAt(i) == '(' || strB.charAt(i) == ')') {
                parentheses.append(strB.charAt(i));
            }
        }

        return parentheses.toString();
    }

    public static Boolean matchParentheses(String str) {
        str = extractParentheses(str);
        System.out.println("Parentheses : " + str);
        int numberOfClosedParenthesesRemaining = 0;
        Boolean findClosedBeforeOpen = false;
        StringBuilder strB = new StringBuilder(str);

        for (int i = 0; i < strB.length(); i++) {
            if ((strB.charAt(i) == ')' && i == 0)
                    || (strB.charAt(i) == ')' && numberOfClosedParenthesesRemaining == 0)) {
                findClosedBeforeOpen = true;
                break;
            }

            if (strB.charAt(i) == '(') {
                numberOfClosedParenthesesRemaining++;
            }

            if (strB.charAt(i) == ')' && numberOfClosedParenthesesRemaining > 0) {
                numberOfClosedParenthesesRemaining--;
            }
        }

        if (findClosedBeforeOpen) {
            return false;
        } else {
            return numberOfClosedParenthesesRemaining == 0;
        }
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
        return str.matches("-?[\\d.]+[+/*-][\\d.]+");
    }

    public static Boolean hasNoSign(String str) {
        return !str.matches(".*[+/*-].*");
    }

    public static Boolean hasMultiOrDiv(String operation) {
        return operation.matches(".*[/*].*");
    }

    public static Boolean isASign(char character) {
        return character == '-' || character == '+' || character == '*' || character == '/';
    }

}
