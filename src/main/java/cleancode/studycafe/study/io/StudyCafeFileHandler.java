package cleancode.studycafe.study.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import cleancode.studycafe.study.model.StudyCafeLockerPass;
import cleancode.studycafe.study.model.StudyCafePass;
import cleancode.studycafe.study.model.StudyCafePassType;

public class StudyCafeFileHandler {
    private static final String STUDY_CAFE_PASS_PATH = "src/main/resources/cleancode/studycafe/pass-list.csv";
    private static final String STUDY_LOCKER_PASS_PATH = "src/main/resources/cleancode/studycafe/locker.csv";
    private static final String FILE_READ_EXCEPTION_MSG = "파일을 읽는데 실패했습니다.";

    public List<StudyCafePass> readStudyCafePasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(STUDY_CAFE_PASS_PATH));
            List<StudyCafePass> studyCafePasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);
                double discountRate = Double.parseDouble(values[3]);

                StudyCafePass studyCafePass = StudyCafePass.of(studyCafePassType, duration, price, discountRate);
                studyCafePasses.add(studyCafePass);
            }

            return studyCafePasses;
        } catch (IOException e) {
            throw new RuntimeException(FILE_READ_EXCEPTION_MSG, e);
        }
    }

    public List<StudyCafeLockerPass> readLockerPasses() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(STUDY_LOCKER_PASS_PATH));
            List<StudyCafeLockerPass> lockerPasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);

                StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(studyCafePassType, duration, price);
                lockerPasses.add(lockerPass);
            }

            return lockerPasses;
        } catch (IOException e) {
            throw new RuntimeException(FILE_READ_EXCEPTION_MSG, e);
        }
    }

}
