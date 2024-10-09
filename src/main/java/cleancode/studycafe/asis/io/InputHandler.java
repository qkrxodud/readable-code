package cleancode.studycafe.asis.io;

import cleancode.studycafe.asis.model.StudyCafePass;
import cleancode.studycafe.asis.model.StudyCafePassType;

import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private static final String LOCKER_PASS_ACTIVE = "1";

    private static final Scanner SCANNER = new Scanner(System.in);

    public StudyCafePassType getPassTypeSelectingUserAction() {
        return StudyCafePassType.convertUserInputToPassType(SCANNER.nextLine());
    }

    public StudyCafePass getSelectPass(List<StudyCafePass> passes) {
        String userInput = SCANNER.nextLine();
        int selectedIndex = Integer.parseInt(userInput) - 1;
        return passes.get(selectedIndex);
    }

    public boolean getLockerSelection() {
        String userInput = SCANNER.nextLine();
        return LOCKER_PASS_ACTIVE.equals(userInput);
    }

}
