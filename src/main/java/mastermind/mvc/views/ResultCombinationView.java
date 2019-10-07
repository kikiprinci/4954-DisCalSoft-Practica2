package mastermind.mvc.views;

import mastermind.mvc.controllers.Controller;
import mastermind.mvc.models.Message;
import mastermind.mvc.utils.YesNoDialog;

public class ResultCombinationView {
    private final Controller controller;

    public ResultCombinationView(Controller controller) {
        this.controller = controller;
    }

    public boolean continueGame() {
        Message.RESUME.write();
        return new YesNoDialog().read();
    }

    public boolean resumeGame() {
        boolean resumed;
		Message.RESUME.write();
		resumed = new YesNoDialog().read();
		return resumed;
    }

    public void writeln() {
        Message.ATTEMPTS.writeln(this.controller.getAttemptsByGame());
        new SecretCombinationView(this.controller).writeln();
        ProposedCombinationView proposeCombinationView = new ProposedCombinationView(this.controller);
        for (int i = 0; i < this.controller.getAttemptsByGame(); i++) {
            proposeCombinationView.write(i);
        }
        this.WriteIsWinner();
        this.WriteIsLooser();
    }

    private void WriteIsWinner() {
        if (this.controller.isWinner()) 
            Message.WINNER.writeln();
    }
    
    private void WriteIsLooser() {
        if (this.controller.isMaxAttemp())
            Message.LOOSER.writeln();
    }
}