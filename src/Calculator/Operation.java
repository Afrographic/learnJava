package Calculator;

public class Operation {
    private double firstOperand;
    private char sign;
    private double secondOperand;

    public double getFirstOperand() {
        return this.firstOperand;
    }

    public void setFirstOperand(String firstOperand) {
        this.firstOperand = Double.parseDouble(firstOperand);
    }

    public char getSign() {
        return this.sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public double getSecondOperand() {
        return this.secondOperand;
    }

    public void setSecondOperand(String secondOperand) {
        this.secondOperand = Double.parseDouble(secondOperand);

    }

    @Override
    public String toString() {
        return "{" +
                " firstOperand='" + getFirstOperand() + "'" +
                ", sign='" + getSign() + "'" +
                ", secondOperand='" + getSecondOperand() + "'" +
                "}";
    }

}
