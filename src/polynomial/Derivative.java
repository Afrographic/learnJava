package polynomial;

import java.util.ArrayList;

public class Derivative {
    public static void main(String[] args) {
        BasicPolynomial[] derivative = computeCompleteDerivative("7x");
        printDerivative(derivative);
    }

    public static void printDerivative(BasicPolynomial[] derivative) {
        StringBuilder output = new StringBuilder("0");
        if (BasicPolynomial.totalPoly > 0) {
            output.deleteCharAt(0);
            for (int i = 0; i <= BasicPolynomial.totalPoly - 1; i++) {
                output.append(derivative[i].toString());
            }
        }

        System.out.println("\n\nResult :" + output);
        System.out.println("****************************\n\n");

    }

    public static BasicPolynomial derivatePolynomial(BasicPolynomial polynomial) {
        double coef = polynomial.getCoef() * polynomial.getDegree();
        int degree = polynomial.getDegree() - 1;
        polynomial.setDegree(degree);
        polynomial.setCoef(coef);
        System.out.println("Derivate Sub polynomial : " + polynomial.toString());
        System.out.println("-------------------------------");
        return polynomial;
    }

    public static BasicPolynomial[] computeCompleteDerivative(String polynomial) {
        System.out.println("\nPolynomial : " + polynomial);
        System.out.println("==============================\n");

        BasicPolynomial[] polymomial = new BasicPolynomial[1000];
        int countPoly = 0;

        if (isNumber(polynomial)) {
            return polymomial;
        }

        StringBuilder strB = new StringBuilder(polynomial);
        for (int i = 0; i <= strB.length() - 1; i++) {
            if (strB.charAt(i) == 'x') {
                String coef = getCoefFromPol(strB, i);
                String degree = getDegreeFromPol(strB, i);

                System.out.println("-------------------------------");
                System.out.println("Sub polynomial : " + coef + "x^" + degree);
                // parse to a polynomail
                BasicPolynomial basicPol = new BasicPolynomial(Double.parseDouble(coef), Integer.parseInt(degree));
                // Derivate the basic polynomial
                derivatePolynomial(basicPol);

                // Add it the Basic polynomial array
                polymomial[countPoly] = basicPol;
                countPoly++;
            }
        }
        BasicPolynomial.totalPoly = countPoly;
        return polymomial;
    }

    public static String getCoefFromPol(StringBuilder pol, int index) {
        StringBuilder coef = new StringBuilder();
        int k = index - 1;
        while (k >= 0) {
            if (pol.charAt(k) == '-' || pol.charAt(k) == '+') {
                if (pol.charAt(k) == '-') {
                    coef.append(pol.charAt(k));
                }
                break;
            }
            coef.append(pol.charAt(k));
            k--;

        }
        return coef.length() == 0 ? "1" : coef.reverse().toString();
    }

    public static String getDegreeFromPol(StringBuilder pol, int index) {
        StringBuilder degree = new StringBuilder();
        int j = index + 1;
        while (j <= pol.length() - 1) {

            if (pol.charAt(j) == '-' || pol.charAt(j) == '+') {
                break;
            }

            degree.append(pol.charAt(j));
            j++;

        }

        if (degree.length() > 0 && degree.charAt(0) == '^') {
            degree.deleteCharAt(0);
        }

        return degree.length() == 0 ? "1" : degree.toString();
    }

    public static Boolean checkValidPolynomial(String pol) {
        return pol.matches("(((-?|\\+?)[\\d.]+x\\^[\\d.]+|(-?|\\+?)[\\d.]+x?))*");
    }

    public static Boolean isNumber(String pol) {
        return pol.matches("[-+\\d]+");
    }
}
