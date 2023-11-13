package christmas;

import christmas.controller.EventPlanner;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final EventPlanner promotionController = new EventPlanner(inputView, outputView);

        promotionController.preview();
    }
}