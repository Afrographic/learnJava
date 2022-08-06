package polynomial;

import java.util.ArrayList;

public class Derivative {
    public static void main(String[] args) {
        // ArrayList<BasicPolynomial> polynomial = new ArrayList<>();
        // BasicPolynomial pol = parserSlave("-3x");
        // System.out.println(pol.toString());

    }

    public static BasicPolynomial derivatePolynomial(BasicPolynomial polynomial) {
        int degree = polynomial.getDegree() - 1;
        int coef = polynomial.getCoef() * polynomial.getDegree();
        polynomial.setDegree(degree);
        polynomial.setCoef(coef);
        return polynomial;
    }

    public static BasicPolynomial[] parseStringToPolynomial(String polynomial) {
        BasicPolynomial[] polymomial = new BasicPolynomial[1000];
        StringBuilder strB = new StringBuilder(polynomial);
        for (int i = 0; i <= strB.length() - 1; i++) {
            if (strB.charAt(i) == 'x') {
                // get the coeficient
                StringBuilder coef = new StringBuilder();
                int k = i - 1;
                while (k >= 0) {
                    coef.append(strB.charAt(k));
                    k--;
                    if (strB.charAt(k) == '-' || strB.charAt(k) == '+') {
                        break;
                    }
                }
                // Get the degree
                StringBuilder degree = new StringBuilder();
                int j = i + 1;
                while (j <= strB.length() - 1) {
                    if (strB.charAt(j) == '^') {

                    }
                    degree.append(strB.charAt(j));
                    j++;

                    if (strB.charAt(j) == '-' || strB.charAt(j) == '+') {
                        break;
                    }
                }

                // parse to a polynomail

                // Add it the Basic polynomial array
            }
        }

        return polymomial;
    }

    public static BasicPolynomial parserSlave(String basicPolynomial) {
        BasicPolynomial pol = new BasicPolynomial(0, 0);
        String[] splittedPoly = basicPolynomial.split("x\\^?");
        pol.setCoef(Integer.parseInt(splittedPoly[0]));
        if (splittedPoly.length > 1)
            pol.setDegree(Integer.parseInt(splittedPoly[1]));
        return pol;
    }

    public static Boolean checkValidPolynomial(String pol) {
        return pol.matches("(((-?|\\+?)[\\d.]+x\\^[\\d.]+|(-?|\\+?)[\\d.]+x?))*");
    }

    public static Boolean isNumber(String pol) {
        return pol.matches("[-+\\d]+");
    }
}
