package polynomial;

public class BasicPolynomial {

    private int coef;
    private int degree;

    public BasicPolynomial(int coef, int degree) {
        this.coef = coef;
        this.degree = degree;
    }

    @Override
    public String toString() {
        if (coef == 0) {
            return "0";
        }
        if (degree == 0) {
            return coef + "x";
        }
        return coef + "x^(" + degree + ')';
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
