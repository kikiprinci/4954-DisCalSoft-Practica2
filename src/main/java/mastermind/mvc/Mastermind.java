package mastermind.mvc;

import mastermind.mvc.controllers.Controller;
import mastermind.mvc.views.ConsoleView;

public class Mastermind {
    private Logic logic;
    private View view;

    public Mastermind() {
        logic = new Logic();
        view = new ConsoleView();
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

    public void play() {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null)
                view.interact(controller);
        } while (controller != null);
    }

}