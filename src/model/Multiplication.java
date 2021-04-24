package model;

public class Multiplication extends BinaryOperation {
    @Override
    double getBinaryOperationResult(double preservedOperand, double currentOperand) {
        return preservedOperand * currentOperand;
    }

    @Override
    public String setText(String currentValue) {
        if (currentValue.startsWith("-")) return "(" + currentValue + ") x";
        return currentValue + " x";
    }
}
