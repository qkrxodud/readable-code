package cleancode.studycafe.study.io;

import cleancode.studycafe.study.model.StudyCafeLockerPass;
import cleancode.studycafe.study.model.StudyCafePass;

import java.util.List;

public class OutputHandler {

    private static final String TITLE = "*** 프리미엄 스터디카페 ***";
    private static final String STORAGE_CABINET_ANNOUNCEMENT = "* 사물함은 고정석 선택 시 이용 가능합니다. (추가 결제)";
    private static final String OPEN_EVENT_ANNOUNCEMENT = "* !오픈 이벤트! 2주권 이상 결제 시 10% 할인, 12주권 결제 시 15% 할인! (결제 시 적용)";
    private static final String ASK_PASS_TYPE = "사용하실 이용권을 선택해 주세요.";
    private static final String ASK_PASS_TYPE_LIST = "1. 시간 이용권(자유석) | 2. 주단위 이용권(자유석) | 3. 1인 고정석";
    private static final String LOCKER_PASS_ASK_MESSAGE = "\n사물함을 이용하시겠습니까? ";
    private static final String LOCKER_PASS_SELECTION = "1. 예 | 2. 아니오";
    private static final String USAGE_HISTORY_TITLE = "\n이용 내역";
    private static final String PASS_TYPE_LABEL = "이용권: ";
    private static final String EMPTY_LINE = "\n";

    public void showWelcomeMessage() {
        displayMessage(TITLE);
    }

    public void showAnnouncement() {
        displayMessage(STORAGE_CABINET_ANNOUNCEMENT);
        displayMessage(OPEN_EVENT_ANNOUNCEMENT);
        printEmptyLine();
    }

    public void askPassTypeSelection() {
        displayMessage(ASK_PASS_TYPE);
        displayMessage(ASK_PASS_TYPE_LIST);
    }

    public void showPassListForSelection(List<StudyCafePass> passes) {
        displayMessage(EMPTY_LINE + "이용권 목록");
        for (int index = 0; index < passes.size(); index++) {
            displayMessage(String.format("%d. %s", index + 1, passes.get(index).display()));
        }
    }

    public void askLockerPass(StudyCafeLockerPass lockerPass) {
        displayMessage(LOCKER_PASS_ASK_MESSAGE + lockerPass.display());
        displayMessage(LOCKER_PASS_SELECTION);
    }

    public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
        displayMessage(USAGE_HISTORY_TITLE);
        displayMessage(PASS_TYPE_LABEL + selectedPass.display());

        if (lockerPass != null && lockerPass.islockerPassActive()) {
            displayMessage("사물함: " + lockerPass.display());
        }

        int discountPrice = calculateDiscount(selectedPass);
        if (discountPrice > 0) {
            displayMessage("이벤트 할인 금액: " + discountPrice + "원");
        }

        int totalPrice = calculateTotalPrice(selectedPass, lockerPass, discountPrice);
        displayMessage("총 결제 금액: " + totalPrice + "원");
        printEmptyLine();
    }

    public void showSimpleMessage(String message) {
        displayMessage(message);
    }

    private int calculateDiscount(StudyCafePass pass) {
        return (int) (pass.getPrice() * pass.getDiscountRate());
    }

    private int calculateTotalPrice(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass, int discountPrice) {
        return selectedPass.getPrice() - discountPrice + (lockerPass != null ? lockerPass.getPrice() : 0);
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
