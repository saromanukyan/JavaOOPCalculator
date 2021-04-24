package model;

public class Number implements DisplayText {
    private final String pressed;
    private final String current;

    public Number(String pressed, String current) {
        this.pressed = pressed;
        this.current = current.contains("impossible") ? "0" : current;
    }

    @Override
    public String setText(String currentValue) {
        return switch (pressed) {
            case "+/-" -> changeSign(currentValue);
            case "." -> dot(currentValue);
            default -> digit(currentValue);
        };
    }

    public String showText() {
        return setText(current);
    }

    private String changeSign(String value) {
        if (value.startsWith("=")) {
            value = value.substring(2);
        }
        if (value.equals("0") || value.equals("")) return value;
        else if (value.charAt(0) == '-') {
            return value.substring(1);
        } else return "-" + value;
    }

    private String dot(String value) {
        if (value.startsWith("=")) {
            value = "";
        }
        if (value.contains(".")) return value;
        else if (value.equals("")) {
            return "0.";
        } else {
            return value + pressed;
        }
    }

    private String digit(String value) {
        if (value.startsWith("=") || value.equals("0") || value.equals("")) {
            return pressed;
        } else
            return value + pressed;
    }
}
