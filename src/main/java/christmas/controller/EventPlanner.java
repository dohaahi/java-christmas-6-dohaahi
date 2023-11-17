package christmas.controller;

import static christmas.util.FunctionalInterfaces.restartIfFailure;

import christmas.domain.dto.OrderRecord;
import christmas.domain.order.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;

    public EventPlanner(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void preview() {
        final Order order = restartIfFailure(inputView::readOrder);

        final OrderRecord orderRecord = order.discount();

        outputView.printOrderRecord(orderRecord);
    }
}