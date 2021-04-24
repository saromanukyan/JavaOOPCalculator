package model;

public class SquareRoot extends UnaryOperation {
    @Override
    double getUnaryOperationResult(double currentOperand) {
        return Math.sqrt(currentOperand);
    }

    @Override
    public String setText(String currentValue) {
        return "√(" + currentValue + ")";
    }
}
