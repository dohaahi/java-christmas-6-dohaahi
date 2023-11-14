package christmas.controller;

import christmas.domain.dto.OrderRecord;
import christmas.domain.order.Order;
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

        OrderRecord orderRecord = order.discount();

        outputView.printOrderRecord(orderRecord);
    }
}