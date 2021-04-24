package model;

public class Division extends BinaryOperation {
    @Override
    double getBinaryOperationResult(double preservedOperand, double currentOperand) {
        return preservedOperand / currentOperand;
    }

    @Override
    public String setText(String currentValue) {
        if (currentValue.startsWith("-")) return "(" + currentValue + ") ÷";
        return currentValue + " ÷";
    }
}
