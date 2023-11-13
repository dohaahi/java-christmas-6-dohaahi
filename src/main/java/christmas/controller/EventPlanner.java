package christmas.controller;

import christmas.domain.OrderRecord;
import christmas.domain.order.Order;
import christmas.domain.promotion.PromotionRecord;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;

    public EventPlanner(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void preview() {
        Order order = inputView.readOrder();

        OrderRecord orderRecord = processTo(order);

        outputView.printOrderRecord(orderRecord);
    }

    private OrderRecord processTo(Order order) {
        PromotionRecord promotionRecord = order.discount();
        OrderRecordMapper orderRecordMapper = new OrderRecordMapper(order, promotionRecord);
        return orderRecordMapper.toOrderRecord();
    }
}