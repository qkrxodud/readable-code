package cleancode.studycafe.study;

import cleancode.studycafe.study.exception.AppException;
import cleancode.studycafe.study.io.InputHandler;
import cleancode.studycafe.study.io.OutputHandler;
import cleancode.studycafe.study.io.StudyCafeFileHandler;
import cleancode.studycafe.study.model.*;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public void run() {
        try {
            displayWelcomeAndAnnouncement();
            StudyCafePasses studyCafePasses = new StudyCafePasses(studyCafeFileHandler.readStudyCafePasses());
            StudyCafePassType studyCafePassType = inputHandler.getPassTypeSelectingUserAction();
            handlePassSelection(studyCafePassType, studyCafePasses);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private void displayWelcomeAndAnnouncement() {
        outputHandler.showWelcomeMessage();
        outputHandler.showAnnouncement();
        outputHandler.askPassTypeSelection();
    }

    private void handlePassSelection(StudyCafePassType studyCafePassType, StudyCafePasses studyCafePasses) {
        if (studyCafePassType.isHourly()) {
            processPassSelection(studyCafePasses.getHourlyPasses(), null);
            return;
        }
        if (studyCafePassType.isWeekly()) {
            processPassSelection(studyCafePasses.getWeeklyPasses(), null);
            return;
        } if (studyCafePassType.isFixed()) {
            processFixedPassSelection(studyCafePasses.getFixedPasses());
            return;
        }
        throw new RuntimeException("사용되지 않는 타입입니다.");
    }

    private void processPassSelection(List<StudyCafePass> passes, StudyCafeLockerPass lockerPass) {
        StudyCafePass passSelection = getPassSelection(passes);
        StudyCafeUser studyCafeUser = new StudyCafeUser(passSelection, lockerPass);
        studyCafeUser.showPassOrderSummary(outputHandler);
    }

    private void processFixedPassSelection(List<StudyCafePass> fixedPasses) {
        StudyCafePass passSelection = getPassSelection(fixedPasses);

        StudyCafeLockerPasses studyCafeLockerPasses = new StudyCafeLockerPasses(studyCafeFileHandler.readLockerPasses());
        StudyCafeLockerPass lockerPass = studyCafeLockerPasses.findMatchingLockerPass(passSelection);

        StudyCafeUser studyCafeUser = new StudyCafeUser(passSelection, lockerPass);
        studyCafeUser.askLockerPass(outputHandler, inputHandler);
        studyCafeUser.showPassOrderSummary(outputHandler);
    }

    private StudyCafePass getPassSelection(List<StudyCafePass> passes) {
        StudyCafePasses statusCafePasses = new StudyCafePasses(passes);
        statusCafePasses.showPassListForSelection(outputHandler);
        return statusCafePasses.getSelectPass(inputHandler);
    }
}
