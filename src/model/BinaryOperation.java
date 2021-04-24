package model;

public abstract class BinaryOperation extends Operation {
    @Override
    double execute() {
        return getBinaryOperationResult(getPreservedOperand(), getCurrentOperand());
    }

    abstract double getBinaryOperationResult(double preservedOperand, double currentOperand);
}
