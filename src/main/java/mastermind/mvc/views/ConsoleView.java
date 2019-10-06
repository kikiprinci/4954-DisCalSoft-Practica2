package mastermind.mvc.views;

import mastermind.mvc.controllers.Controller;
import mastermind.mvc.controllers.StartController;
import mastermind.mvc.controllers.ProposedCombinationController;
import mastermind.mvc.controllers.ResumeController;
import mastermind.mvc.*;
import mastermind.mvc.models.*;

public class ConsoleView extends View {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startController.start();
    }

    @Override
    public void visit(ResumeController resumeController) {
        boolean newGame = new ResultCombinationView(resumeController).continueGame();
        resumeController.resume(newGame);
    }

    @Override
    public void visit(ProposedCombinationController proposedCombinationController) {
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView(proposedCombinationController);
        ProposedCombination proposedCombination;

        do  {
            proposedCombinationView.writeln();
            proposedCombination = new ProposedCombination(proposedCombinationView.read());
            proposedCombinationController.addProposedCombination(proposedCombination);
            proposedCombinationController.addResult(proposedCombination);
            //
        } while (proposedCombination.hasError());

    }

    

}