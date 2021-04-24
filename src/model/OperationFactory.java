package model;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {
    private static final Map<String, Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("Equal", new Equal());
        operationMap.put("Addition", new Addition());
        operationMap.put("Subtraction", new Subtraction());
        operationMap.put("Multiplication", new Multiplication());
        operationMap.put("Division", new Division());
        operationMap.put("SquareRoot", new SquareRoot());
        operationMap.put("Sinus", new Sinus());
        operationMap.put("Cosinus", new Cosinus());
    }

    public static Operation getOperation(String operation) {
        return operationMap.get(operation);
    }
}

