package mastermind.mvc.controllers;

import mastermind.mvc.models.State;
import mastermind.mvc.models.Game;
import mastermind.mvc.models.ProposedCombination;

public class ProposedCombinationController extends Controller {

    public ProposedCombinationController(Game game, State state) {
        super(game, state);
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.game.getProposedCombinations().add(proposedCombination);
    }

    public void addResult(ProposedCombination proposedCombination) {
        this.game.getResults().add(this.game.getResult(proposedCombination));
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}