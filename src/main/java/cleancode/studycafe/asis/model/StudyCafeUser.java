package cleancode.studycafe.asis.model;

import cleancode.studycafe.asis.io.InputHandler;
import cleancode.studycafe.asis.io.OutputHandler;

import java.util.Objects;

public class StudyCafeUser {
    private final StudyCafePass studyCafePass;
    private final StudyCafeLockerPass studyCafeLockerPass;
    public StudyCafeUser(StudyCafePass studyCafePass, StudyCafeLockerPass studyCafeLockerPass) {
        this.studyCafePass = studyCafePass;
        this.studyCafeLockerPass = studyCafeLockerPass;
    }

    public void askLockerPass(OutputHandler outputHandler, InputHandler inputHandler) {
        if (Objects.isNull(studyCafeLockerPass)) {
            return;
        }
        studyCafeLockerPass.askLockerPass(outputHandler, inputHandler);
    }

    public void showPassOrderSummary(OutputHandler outputHandler) {
        outputHandler.showPassOrderSummary(studyCafePass, studyCafeLockerPass);
    }
}
