package stredniPriklad;

public class Model {

    private Double firstNumber;
    private Double secondNumber;
    private double result;

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getResult(Action action, Double firstNumber, Double secondNumber) {
        setFirstNumber(firstNumber);
        setSecondNumber(secondNumber);
        switch (action) {
            case ADDITION:
                return formateResult(addition());
            case SUBTRACTION:
                return formateResult(subtraction());
            case MULTIPLICATION:
                return formateResult(multiplication());
            case DIVISION:
                return formateResult(division());
            default:
                return null;
        }
    }

    private Double addition() {
        return getFirstNumber() + getSecondNumber();
    }

    private Double subtraction() {
        return getFirstNumber() - getSecondNumber();
    }

    private Double multiplication() {
        return getFirstNumber() * getSecondNumber();
    }

    private Double division() {
        if (getSecondNumber() != 0) {
            return getFirstNumber() / getSecondNumber();
        }
        return null;
    }

    private String formateResult(Double countFunction) {
        if (countFunction != null) {
            if (countFunction - countFunction.intValue() == 0) {
                return "" + countFunction.intValue();
            } else {
                return "" + countFunction;
            }
        }
        return "NaN";
    }
}
