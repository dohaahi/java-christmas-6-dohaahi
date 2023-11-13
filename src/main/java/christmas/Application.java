package christmas;

import christmas.controller.EventPlanner;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        EventPlanner promotionController = new EventPlanner(inputView, outputView);

        promotionController.preview();
    }
}