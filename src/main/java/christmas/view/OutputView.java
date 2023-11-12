package christmas.view;

import static christmas.domain.date.Date.CURRENT_MONTH;

public class OutputView {
    public static final String PREVIEW_EVENT_MESSAGE = CURRENT_MONTH + "월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public void printPreviewEvent(final int date) {
        System.out.printf(PREVIEW_EVENT_MESSAGE, date);
    }
}