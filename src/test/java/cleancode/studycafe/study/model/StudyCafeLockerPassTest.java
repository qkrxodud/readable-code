package cleancode.studycafe.study.model;

import cleancode.studycafe.study.io.InputHandler;
import cleancode.studycafe.study.mock.FakeInputHandlerImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeLockerPassTest {
    @Test
    @DisplayName("초기락커패스 값을 확인한다.")
    public void 초기락커패스의_값을_확인한다() {
        //given
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);
        //when
        boolean lockerPassActive = studyCafeLockerPass.isLockerPassActive();
        int price = studyCafeLockerPass.getPrice();
        int duration = studyCafeLockerPass.getDuration();

        //then
        Assertions.assertThat(lockerPassActive)
                .isFalse();
        Assertions.assertThat(price)
                .isEqualTo(10000);
        Assertions.assertThat(duration)
                .isEqualTo(duration);
    }

    @Test
    @DisplayName("StudyCafePassType와duration이 일치하는지 확인한다.")
    public void 락커패스의_패스타입과_사용기간을_확인한다()  {
        //given
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);
        //when
        boolean matchingPassType = studyCafeLockerPass.isMatchingPassType(StudyCafePassType.FIXED, 4);

        //then
        Assertions.assertThat(matchingPassType)
                .isTrue();
    }

    @Test
    @DisplayName("락커패스 값을 업데이트 한다.")
    public void 락커패스의_값을_업데이트한다 () {
        //given
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 10000);
        InputHandler inputHandler = new FakeInputHandlerImpl();

        //when
        studyCafeLockerPass.updateLockerPassStatus(inputHandler);
        //then
        Assertions.assertThat(studyCafeLockerPass.isLockerPassActive()).isTrue();
    }
}