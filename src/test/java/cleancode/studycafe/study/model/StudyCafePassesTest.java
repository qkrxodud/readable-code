package cleancode.studycafe.study.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class StudyCafePassesTest {

    @Test
    @DisplayName("스터디카페패스의 여러데이터중 시간사용패스만 찾는다")
    public void 스터디카페패스의_어러데이터중_시간사용패스만_찾는다 () {
        //given
        StudyCafePass studyCafePass_1 = StudyCafePass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);
        StudyCafePass studyCafePass_2 = StudyCafePass.of(StudyCafePassType.HOURLY, 2, 100000, 0.1);
        StudyCafePass studyCafePass_3 = StudyCafePass.of(StudyCafePassType.FIXED, 2, 100000, 0.1);
        StudyCafePass studyCafePass_4 = StudyCafePass.of(StudyCafePassType.HOURLY, 2, 100000, 0.1);

        ArrayList<StudyCafePass> studyCafePassList = new ArrayList<>();
        studyCafePassList.add(studyCafePass_1);
        studyCafePassList.add(studyCafePass_2);
        studyCafePassList.add(studyCafePass_3);
        studyCafePassList.add(studyCafePass_4);

        //when
        StudyCafePasses studyCafePasses = new StudyCafePasses(studyCafePassList);
        //then
        Assertions.assertThat(studyCafePasses.getHourlyPasses().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("스터디카페패스의 여러데이터중 주간사용패스만 찾는다")
    public void 스터디카페패스의_여러데이터중_주간사용패스만_찾는다 () {
        //given
        StudyCafePass studyCafePass_1 = StudyCafePass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);
        StudyCafePass studyCafePass_2 = StudyCafePass.of(StudyCafePassType.HOURLY, 2, 100000, 0.1);
        StudyCafePass studyCafePass_3 = StudyCafePass.of(StudyCafePassType.FIXED, 2, 100000, 0.1);
        StudyCafePass studyCafePass_4 = StudyCafePass.of(StudyCafePassType.FIXED, 2, 100000, 0.1);
        StudyCafePass studyCafePass_5 = StudyCafePass.of(StudyCafePassType.FIXED, 2, 100000, 0.1);
        StudyCafePass studyCafePass_6 = StudyCafePass.of(StudyCafePassType.HOURLY, 2, 100000, 0.1);

        ArrayList<StudyCafePass> studyCafePassList = new ArrayList<>();
        studyCafePassList.add(studyCafePass_1);
        studyCafePassList.add(studyCafePass_2);
        studyCafePassList.add(studyCafePass_3);
        studyCafePassList.add(studyCafePass_4);
        studyCafePassList.add(studyCafePass_5);
        studyCafePassList.add(studyCafePass_6);

        //when
        StudyCafePasses studyCafePasses = new StudyCafePasses(studyCafePassList);
        //then
        Assertions.assertThat(studyCafePasses.getWeeklyPasses().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("스터디카페패스의 여러데이터중 고정사용패스만 찾는다")
    public void 스터디카페패스의_여러데이터중_고정사용패스만_찾는다 () {
        //given
        StudyCafePass studyCafePass_1 = StudyCafePass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);
        StudyCafePass studyCafePass_2 = StudyCafePass.of(StudyCafePassType.HOURLY, 2, 100000, 0.1);
        StudyCafePass studyCafePass_3 = StudyCafePass.of(StudyCafePassType.FIXED, 2, 100000, 0.1);
        StudyCafePass studyCafePass_4 = StudyCafePass.of(StudyCafePassType.FIXED, 2, 100000, 0.1);
        StudyCafePass studyCafePass_5 = StudyCafePass.of(StudyCafePassType.FIXED, 2, 100000, 0.1);
        StudyCafePass studyCafePass_6 = StudyCafePass.of(StudyCafePassType.HOURLY, 2, 100000, 0.1);

        ArrayList<StudyCafePass> studyCafePassList = new ArrayList<>();
        studyCafePassList.add(studyCafePass_1);
        studyCafePassList.add(studyCafePass_2);
        studyCafePassList.add(studyCafePass_3);
        studyCafePassList.add(studyCafePass_4);
        studyCafePassList.add(studyCafePass_5);
        studyCafePassList.add(studyCafePass_6);

        //when
        StudyCafePasses studyCafePasses = new StudyCafePasses(studyCafePassList);
        //then
        Assertions.assertThat(studyCafePasses.getFixedPasses().size()).isEqualTo(3);
    }
}