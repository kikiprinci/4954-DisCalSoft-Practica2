package mastermind.mvc.views;

import mastermind.mvc.controllers.Controller;
import mastermind.mvc.utils.WithConsoleModel;
import mastermind.mvc.models.Message;

public class SecretCombinationView extends WithConsoleModel{
    private final Controller controller;

    public SecretCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void writeln() {
		for (int i = 0; i < this.controller.getSecretCombinationLength(); i++) {
			Message.SECRET.write();
		}
		Message.NEW_LINE.write();
	}
}