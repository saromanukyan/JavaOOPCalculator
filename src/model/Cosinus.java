package model;

public class Cosinus extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.cos(Math.toRadians(currentOperand));
    }

    @Override
    public String setText(String currentValue) {
        return "cos(" + currentValue + ")";
    }
}
