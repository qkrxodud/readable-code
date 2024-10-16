package cleancode.studycafe.study.model;


import cleancode.studycafe.study.io.InputHandler;
import cleancode.studycafe.study.io.OutputHandler;

public class StudyCafeLockerPass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private boolean lockerPassActive;

    private StudyCafeLockerPass(StudyCafePassType passType, int duration, int price) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.lockerPassActive = false;
    }

    public static StudyCafeLockerPass of(StudyCafePassType passType, int duration, int price) {
        return new StudyCafeLockerPass(passType, duration, price);
    }

    public int getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public String display() {
        if (passType.isHourly()) {
            return String.format("%s시간권 - %d원", duration, price);
        }
        if (passType.isWeekly()) {
            return String.format("%s주권 - %d원", duration, price);
        }
        if (passType.isFixed()) {
            return String.format("%s주권 - %d원", duration, price);
        }
        return "";
    }

    public boolean isMatchingPassType(final StudyCafePassType passType, final int duration) {
        return (this.passType == passType && this.duration == duration);
    }

    public void promptAndSaveLockerPassChoice(OutputHandler outputHandler, InputHandler inputHandler) {
        promptForLockerPassSelection(outputHandler);
        updateLockerPassStatus(inputHandler);
    }

    private void promptForLockerPassSelection(OutputHandler outputHandler) {
        outputHandler.askLockerPass(this);
    }

    public void updateLockerPassStatus(InputHandler inputHandler) {
        lockerPassActive = inputHandler.getLockerSelection();
    }

    public boolean isLockerPassActive() {
        return lockerPassActive;
    }
}
