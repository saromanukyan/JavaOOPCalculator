package model;

public class Equal extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return currentOperand;
    }

    @Override
    public String setText(String currentValue) {
        return currentValue.startsWith("-") ? ("(" + currentValue + ")") : currentValue;
    }
}

