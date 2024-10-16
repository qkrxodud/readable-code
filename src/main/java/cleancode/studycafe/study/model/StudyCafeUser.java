package cleancode.studycafe.study.model;

import cleancode.studycafe.study.io.InputHandler;
import cleancode.studycafe.study.io.OutputHandler;

import java.util.Objects;

public class StudyCafeUser {
    private final StudyCafePass studyCafePass;
    private final StudyCafeLockerPass studyCafeLockerPass;
    public StudyCafeUser(StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
        this.studyCafePass = studyCafePass;
        this.studyCafeLockerPass = studyCafeLockerPass;
    }

    public void promptAndSaveLockerPassChoice(OutputHandler outputHandler, InputHandler inputHandler) {
        if (Objects.isNull(studyCafeLockerPass)) {
            return;
        }
        studyCafeLockerPass.promptAndSaveLockerPassChoice(outputHandler, inputHandler);
    }

    public void showPassOrderSummary(OutputHandler outputHandler) {
        outputHandler.showPassOrderSummary(studyCafePass, studyCafeLockerPass);
    }
}
