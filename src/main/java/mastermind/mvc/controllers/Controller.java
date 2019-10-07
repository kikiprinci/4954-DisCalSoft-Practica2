package mastermind.mvc.controllers;

import java.util.List;

import mastermind.mvc.models.Game;
import mastermind.mvc.models.Result;
import mastermind.mvc.models.State;
import mastermind.mvc.models.Color;

public abstract class Controller {
    protected final Game game;
    protected final State state;

    public Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public abstract void accept(ControllerVisitor controllerVisitor);

    public int getSecretCombinationLength() {
        return this.game.getSecretCombinationLength();
    }

    public int getAttemps() {
        return this.game.getAttemps();
    }

    public List<Color> getColorsByAttemp(int index) {
        return this.game.getColorsByAttemp(index);
    }

    public int getAttemptsByGame() {
        return this.game.getAttemps();
    }

    public Result getResultProposeCombination(int index) {
        List<Result> lstResults = this.game.getResults();
        return lstResults.get(index);
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public boolean isMaxAttemp() {
        return this.game.isMaxAttemp();
    }
}