package mastermind.mvc;

import mastermind.mvc.controllers.*;

import mastermind.mvc.models.Game;
import mastermind.mvc.models.State;
import mastermind.mvc.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private final State state;

    private Game game;

    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.state = new State();
        this.game = new Game();

        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL,new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME,new ProposedCombinationController(this.game, this.state));
        this.controllers.put(StateValue.FINAL,new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT,null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }
}