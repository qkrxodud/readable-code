package cleancode.studycafe.study.mock;

import cleancode.studycafe.study.io.InputHandler;
import cleancode.studycafe.study.model.StudyCafePass;
import cleancode.studycafe.study.model.StudyCafePassType;

import java.util.List;
import java.util.Scanner;

public class FakeInputHandlerImpl implements InputHandler {

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
        return true;
    }

}
