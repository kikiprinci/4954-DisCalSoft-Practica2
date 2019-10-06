package mastermind.mvc;

import mastermind.mvc.controllers.Controller;
import mastermind.mvc.controllers.ControllerVisitor;

public abstract class View implements ControllerVisitor{
    public abstract void interact(Controller controller);
}