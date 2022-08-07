package polynomial;

public class BasicPolynomial {
    static int totalPoly = 0;
    private double coef;
    private int degree;

    public BasicPolynomial(double coef, int degree) {
        this.coef = coef;
        this.degree = degree;
    }

    @Override
    public String toString() {
        if (degree == 0) {
            return coef > 0 ? "+" + coef : "" + coef;
        }
        if (degree == 1) {
            return (coef > 0 ? "+" + coef : coef) + "x";
        }

        return (coef > 0 ? "+" + coef : coef) + "x^" + degree;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
