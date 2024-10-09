package cleancode.studycafe.study.model;

public enum StudyCafePassType {
    HOURLY, WEEKLY, FIXED;

    private static final String HOURLY_CODE = "1";
    private static final String WEEKLY_CODE = "2";
    private static final String FIXED_CODE = "3";

    public static StudyCafePassType convertUserInputToPassType(String userInput) {
        if (HOURLY_CODE.equals(userInput)) {
            return HOURLY;
        }
        if (WEEKLY_CODE.equals(userInput)) {
            return WEEKLY;
        }
        if (FIXED_CODE.equals(userInput)) {
            return FIXED;
        }
        throw new IllegalArgumentException("Unknown input: " + userInput);
    }

    public boolean isHourly() {
        return this.equals(HOURLY);
    }

    public boolean isWeekly() {
        return this.equals(WEEKLY);
    }

    public boolean isFixed() {
        return this.equals(FIXED);
    }
}
