package cleancode.studycafe.study.io;

import cleancode.studycafe.study.model.StudyCafePass;
import cleancode.studycafe.study.model.StudyCafePassType;

import java.util.List;

public interface InputHandler {
    StudyCafePassType getPassTypeSelectingUserAction();
    StudyCafePass getSelectPass(List<StudyCafePass> passes);

    boolean getLockerSelection();


}
