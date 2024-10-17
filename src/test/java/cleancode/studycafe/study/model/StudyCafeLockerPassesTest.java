package cleancode.studycafe.study.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class StudyCafeLockerPassesTest {

    @Test
    @DisplayName("스터디카페락커페스의 여러 데이터 중 스터디카패 패스가 일치하는값만 찾는다")
    public void 락커패스의_여러데이터_중_패스가일치하는_값만_찾는다()  {
        //given
        StudyCafeLockerPass studyCafeLockerPass_1 = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);
        StudyCafeLockerPass studyCafeLockerPass_2 = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 10000);
        StudyCafeLockerPass studyCafeLockerPass_3 = StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 12, 10000);

        List<StudyCafeLockerPass> studyCafeLockerPasses = new ArrayList<>();
        studyCafeLockerPasses.add(studyCafeLockerPass_1);
        studyCafeLockerPasses.add(studyCafeLockerPass_2);
        studyCafeLockerPasses.add(studyCafeLockerPass_3);

        StudyCafeLockerPasses studyCafeLockerPasses1 = new StudyCafeLockerPasses(studyCafeLockerPasses);

        //when
        StudyCafePass studyCafePass = StudyCafePass.of(StudyCafePassType.WEEKLY, 12, 100000, 0.1);
        StudyCafeLockerPass matchingLockerPass = studyCafeLockerPasses1.findMatchingLockerPass(studyCafePass);

        //then
        Assertions.assertThat(matchingLockerPass).isEqualTo(studyCafeLockerPass_3);
    }

}