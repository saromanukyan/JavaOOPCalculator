package model;

public class Sinus extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.sin(Math.toRadians(currentOperand));
    }

    @Override
    public String setText(String currentValue) {
        return "sin(" + currentValue + ")";
    }
}
