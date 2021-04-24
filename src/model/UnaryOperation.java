package model;

public abstract class UnaryOperation extends Operation {
    @Override
    double execute() {
        return getUnaryOperationResult(getCurrentOperand());
    }

    abstract double getUnaryOperationResult(double currentOperand);
}
