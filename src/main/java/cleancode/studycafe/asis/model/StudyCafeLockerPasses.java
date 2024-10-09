package cleancode.studycafe.asis.model;


import java.util.List;

public class StudyCafeLockerPasses {
    private final List<StudyCafeLockerPass> studyCafeLockerPassList;

    public StudyCafeLockerPasses(List<StudyCafeLockerPass> studyCafeLockerPasses) {
        this.studyCafeLockerPassList = studyCafeLockerPasses;
    }

    public StudyCafeLockerPass findMatchingLockerPass(StudyCafePass selectedPass) {
        return studyCafeLockerPassList.stream()
                .filter(studyCafeLockerPass -> studyCafeLockerPass.isMatchingPassType(selectedPass.getPassType(), selectedPass.getDuration()))
                .findFirst()
                .orElse(null);
    }
}
