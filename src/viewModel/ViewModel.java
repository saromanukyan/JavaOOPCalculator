package viewModel;

import model.Calculator;
import model.Number;
import model.Special;
import view.Button;
import view.TextView;

public class ViewModel {
    TextView textViewPrimary;
    TextView textViewSecondary;

    String preservedOperator = "Equal";
    double preservedValue = 0;

    public ViewModel(TextView textViewPrimary, TextView textViewSecondary) {

        this.textViewPrimary = textViewPrimary;
        this.textViewSecondary = textViewSecondary;
    }

    void setAllToDefault() {
        textViewPrimary.setText("");
        textViewSecondary.setText("");
        preservedValue = 0;
        preservedOperator = "Equal";
    }

    static double textToDouble(String text) {
        String result = text.replaceAll("[^-0-9.E]", "");
        if (result.length() == 0) return 0;
        double d = Double.parseDouble(result);
        return d + 0;
    }

    public void onClick(Button v) {
        String pressedBtnTag = v.getTag();   // orinak  "BINARY"
        String pressedBtnText = v.getText();   // orinak  "+"
        String pressedBtnName = v.getId();   // orinak  "Addition"

        String currentTextView = textViewPrimary.getText();
        double currentValue = textToDouble(currentTextView);

        switch (pressedBtnTag) {
            case "NUMBER" -> textViewPrimary.setText(new Number(pressedBtnText, currentTextView).showText());
            case "BINARY" -> {
                if (currentTextView.contains("impossible")) {

                    preservedValue = 0;
                    Calculator calc = new Calculator(preservedValue, preservedOperator);
                    textViewSecondary.setText(calc.showText());
                    textViewPrimary.setText("");

                }

                if (currentTextView.equals("")) {
                    preservedOperator = pressedBtnName;
                    currentValue = preservedValue;
                    Calculator calc = new Calculator(currentValue, preservedOperator);
                    textViewSecondary.setText(calc.showText());
                } else {
                    Calculator calc1 = new Calculator(preservedValue, currentValue, preservedOperator);
                    String result = calc1.result();
                    if (result.equals("impossible")) {
                        preservedValue = 0;
                        preservedOperator = "Equal";
                        textViewSecondary.setText(textViewSecondary.getText().concat(" " + new
                                Calculator(currentValue, preservedOperator).result()));
                        textViewPrimary.setText("impossible");
                    } else {
                        preservedValue = textToDouble(calc1.result());
                        Calculator calc2 = new Calculator(preservedValue, pressedBtnName);
                        preservedOperator = pressedBtnName;
                        textViewSecondary.setText(calc2.showText());
                        textViewPrimary.setText("");
                    }
                }
            }
            case "UNARY" -> {
                if (currentTextView.contains("impossible")) {
                    preservedValue = 0;
                    preservedOperator = "Equal";
                    textViewSecondary.setText("");
                    textViewPrimary.setText("");
                }

                Calculator calcCurrent = new Calculator(currentValue, pressedBtnName);

                if (preservedOperator.equals("Equal")) {
                    textViewSecondary.setText(calcCurrent.showText());

                } else {
                    textViewSecondary.setText(textViewSecondary.getText().concat(" " + calcCurrent.showText()));
                }

                String result = calcCurrent.result();
                if (result.equals("impossible")) {
                    preservedValue = 0;
                    preservedOperator = "Equal";
                    textViewPrimary.setText("impossible");
                } else {
                    currentValue = textToDouble(result);
                    Calculator calc = new Calculator(preservedValue, currentValue, preservedOperator);
                    textViewPrimary.setText("= " + calc.result());
                    preservedValue = textToDouble(calc.result());
                    preservedOperator = "Equal";
                }

            }
            case "SPECIAL" -> {
                String result = Special.valueOf(pressedBtnName.toUpperCase()).setText(currentTextView);
                if (result.equals("RESET")) {
                    setAllToDefault();

                } else textViewPrimary.setText(result);

            }
        }
        System.out.println(
                //     "             { "+pressedBtnText+" }"+
                //      "\n" +
                "         _______________________\n" +
                        "        |  ___________________  |\n" +
                        "        | | " + textViewSecondary.getText() + "\n" +
                        "        | |___________________| |\n" +
                        "        | |                   | |\n" +
                        "        | | " + textViewPrimary.getText() + "\n" +
                        "        | |___________________| |\n" +
                        "        | | C  |sin |cos | √  | |\n" +
                        "        | |____|____|____|____| |\n" +
                        "        | | CE | X  | ÷  | ←  | |\n" +
                        "        | |____|____|____|____| |\n" +
                        "        | | 7  | 8  | 9  | +  | |\n" +
                        "        | |____|____|____|____| |\n" +
                        "        | | 1  | 2  | 3  |    | |\n" +
                        "        | |____|____|____| =  | |\n" +
                        "        | | 0  | .  |+/- |    | |\n" +
                        "        | |____|____|____|____| |\n" +
                        "        |_______________________|\n");
    }
}
