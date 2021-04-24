package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Calculator {
    Operation operation;

    public Calculator(double preservedOperand, double currentOperand, String operator) {
        operation = OperationFactory.getOperation(operator);
        operation.setPreservedOperand(preservedOperand);
        operation.setCurrentOperand(currentOperand);
    }

    public Calculator(double currentOperand, String operator) {
        operation = OperationFactory.getOperation(operator);
        operation.setCurrentOperand(currentOperand);
    }

    public String result() {
        double result = operation.execute();
        return resultToString(result);
    }

    public String showText() {
        return operation.setText(resultToString(operation.getCurrentOperand()));
    }

    static String resultToString(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) return "impossible";

        DecimalFormat df = new DecimalFormat("#,###.##########");
        DecimalFormatSymbols sfs = new DecimalFormatSymbols();
        // sfs.setDecimalSeparator(',');
        sfs.setGroupingSeparator(' ');
        df.setDecimalFormatSymbols(sfs);
        String result = df.format(d);
        if (result.equals("-0")) return "0";

        DecimalFormat withScientificSeparator = new DecimalFormat("0.########E0");
        if (result.length() > 15) {
            //  double h = Double.parseDouble(s.replaceAll("[, ]", ""));
            double wss = Double.parseDouble(result.replaceAll("[^-0-9.]", ""));
            return withScientificSeparator.format(wss);
        }
        return result;

    }
}
