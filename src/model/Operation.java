package model;

public abstract class Operation implements DisplayText {
    private double preservedOperand;  // preserved
    private double currentOperand; // current

    public double getPreservedOperand() {
        return preservedOperand;
    }

    public void setPreservedOperand(double preservedOperand) {
        this.preservedOperand = preservedOperand;
    }

    public double getCurrentOperand() {
        return currentOperand;
    }

    public void setCurrentOperand(double currentOperand) {
        this.currentOperand = currentOperand;
    }

    abstract double execute();
}

