package cleancode.studycafe.asis.model;

import cleancode.studycafe.asis.io.InputHandler;
import cleancode.studycafe.asis.io.OutputHandler;
import java.util.List;

public class StudyCafePasses {
    private final List<StudyCafePass> studyCafePassList;

    public StudyCafePasses(List<StudyCafePass> studyCafePassList) {
        this.studyCafePassList = List.copyOf(studyCafePassList);
    }

    public List<StudyCafePass> getHourlyPasses() {
        return studyCafePassList.stream()
                .filter(studyCafePass -> studyCafePass.isHourly())
                .toList();
    }

    public List<StudyCafePass> getWeeklyPasses() {
        return studyCafePassList.stream()
                .filter(studyCafePass -> studyCafePass.isWeekly())
                .toList();
    }

    public List<StudyCafePass> getFixedPasses() {
        return studyCafePassList.stream()
                .filter(studyCafePass -> studyCafePass.isFixed())
                .toList();
    }

    public void showPassListForSelection(OutputHandler outputHandler) {
        outputHandler.showPassListForSelection(studyCafePassList);
    }

    public StudyCafePass getSelectPass(InputHandler inputHandler) {
        return inputHandler.getSelectPass(studyCafePassList);
    }
}
