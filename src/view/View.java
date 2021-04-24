package view;
/*
         _______________________
        |  ___________________  |
        | | 2  + 3            | |
        | |___________________| |
        | |                   | |
        | | =  5              | |
        | |___________________| |
        | | C  |sin |cos | √  | |
        | |____|____|____|____| |
        | | CE | X  | /  | ←  | |
        | |____|____|____|____| |
        | | 7  | 8  | 9  | +  | |
        | |____|____|____|____| |
        | | 1  | 2  | 3  |    | |
        | |____|____|____| =  | |
        | | 0  | .  |+/- |    | |
        | |____|____|____|____| |
        |_______________________|

 */

import viewModel.ViewModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        TextView textViewPrimary = new TextView();
        TextView textViewSecondary = new TextView();

        Button button0 = new Button("button0", "0", "NUMBER");
        Button button1 = new Button("button1", "1", "NUMBER");
        Button button2 = new Button("button2", "2", "NUMBER");
        Button button3 = new Button("button3", "3", "NUMBER");
        Button button4 = new Button("button4", "4", "NUMBER");
        Button button5 = new Button("button5", "5", "NUMBER");
        Button button6 = new Button("button6", "6", "NUMBER");
        Button button7 = new Button("button7", "7", "NUMBER");
        Button button8 = new Button("button8", "8", "NUMBER");
        Button button9 = new Button("button9", "9", "NUMBER");
        Button buttonDot = new Button("Dot", ".", "NUMBER");
        Button buttonChangeSign = new Button("ChangeSign", "+/-", "NUMBER");

        Button buttonBack = new Button("Back", "←", "SPECIAL");
        Button buttonClearCurrent = new Button("ClearCurrent", "CE", "SPECIAL");
        Button buttonReset = new Button("Reset", "C", "SPECIAL");

        Button buttonMultiplication = new Button("Multiplication", "X", "BINARY");
        Button buttonDivision = new Button("Division", "÷", "BINARY");
        Button buttonAddition = new Button("Addition", "+", "BINARY");
        Button buttonSubtraction = new Button("Subtraction", "-", "BINARY");

        Button buttonEqual = new Button("Equal", "=", "UNARY");
        Button buttonSquareRoot = new Button("SquareRoot", "√", "UNARY");
        Button buttonSinus = new Button("Sinus", "sin", "UNARY");
        Button buttonCosinus = new Button("Cosinus", "cos", "UNARY");

        ViewModel viewModel = new ViewModel(textViewPrimary, textViewSecondary);

        Map<String, Button> map = new HashMap<>();
        map.put("0", button0);
        map.put("1", button1);
        map.put("2", button2);
        map.put("3", button3);
        map.put("4", button4);
        map.put("5", button5);
        map.put("6", button6);
        map.put("7", button7);
        map.put("8", button8);
        map.put("9", button9);
        map.put(".", buttonDot);
        map.put("s", buttonChangeSign);
        map.put("+", buttonAddition);
        map.put("-", buttonSubtraction);
        map.put("/", buttonDivision);
        map.put("*", buttonMultiplication);
        map.put("x", buttonMultiplication);
        map.put("=", buttonEqual);
        map.put("q", buttonSquareRoot);
        map.put("sqrt", buttonSquareRoot);
        map.put("b", buttonBack);
        map.put("back", buttonBack);
        map.put("c", buttonClearCurrent);
        map.put("sin", buttonSinus);
        map.put("cos", buttonCosinus);
        map.put("r", buttonReset);

        Scanner s = new Scanner(System.in);
        viewModel.onClick(button0);
        boolean isMenuActive = true;
        while (isMenuActive) {
            String input = s.next();
            if ("e".equals(input)) {
                isMenuActive = false;
                System.out.println("Thank you!");
            } else {
                try {
                    viewModel.onClick(map.get(input));
                } catch (NullPointerException e) {
                    System.out.println("Try again!");
                }
            }
        }
    }

}

