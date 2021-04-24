package model;

public enum Special implements DisplayText {
    CLEARCURRENT {
        @Override
        public String setText(String currentValue) {
            return "0";
        }
    },
    BACK {
        @Override
        public String setText(String currentValue) {
            if (currentValue.contains("impossible")) {
                return "0";
            } else if (currentValue.startsWith("=")) {
                return currentValue.substring(2);
            } else if (currentValue.length() > 1) {
                return currentValue.substring(0, currentValue.length() - 1);
            } else return "0";
        }
    },
    RESET {
        @Override
        public String setText(String currentValue) {
            return "RESET";
        }
    }
}
