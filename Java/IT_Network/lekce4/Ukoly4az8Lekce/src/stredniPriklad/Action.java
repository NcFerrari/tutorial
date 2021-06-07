package stredniPriklad;

public enum Action {

    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION;

    public static Action getActionBySymbol(String symbol) {
        switch (symbol) {
            case "+":
                return Action.ADDITION;
            case "-":
                return Action.SUBTRACTION;
            case "*":
                return Action.MULTIPLICATION;
            case "/":
                return Action.DIVISION;
            default:
                return null;
        }
    }
}
