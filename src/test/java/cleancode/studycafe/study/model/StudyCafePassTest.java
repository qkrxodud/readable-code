package cleancode.studycafe.study.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafePassTest {

    @Test
    @DisplayName("스터디카페패스의 초기값이 잘 셋팅 되는지 확인한다.")
    public void 스터디카페패스_초기값 () throws Exception {
        //given
        StudyCafePass studyCafePass = StudyCafePass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);

        //when
        StudyCafePassType passType = studyCafePass.getPassType();
        int duration = studyCafePass.getDuration();
        int price = studyCafePass.getPrice();
        double discountRate = studyCafePass.getDiscountRate();

        //then
        Assertions.assertThat(passType).isEqualTo(StudyCafePassType.WEEKLY);
        Assertions.assertThat(duration).isEqualTo(2);
        Assertions.assertThat(price).isEqualTo(100000);
        Assertions.assertThat(discountRate).isEqualTo(0.1);
    }

    @Test
    @DisplayName("스터디카페패스의 초기 사용기간값이 일치하는지 확인한다.")
    public void 스터디카페패스_시간값_확인함수_체크 () throws Exception {
        //given
        //when
        StudyCafePass studyCafePass = StudyCafePass.of(StudyCafePassType.WEEKLY, 2, 100000, 0.1);

        //then
        Assertions.assertThat(studyCafePass.isWeekly()).isTrue();
        Assertions.assertThat(studyCafePass.isHourly()).isFalse();
        Assertions.assertThat(studyCafePass.isFixed()).isFalse();

    }



}