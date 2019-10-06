package mastermind.mvc.controllers;

public interface ControllerVisitor {
    void visit(StartController startController);

    void visit(ResumeController resumeController);

    void visit(ProposedCombinationController proposedCombinationController);
}