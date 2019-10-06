package mastermind.mvc.views;

import java.util.List;

import mastermind.mvc.controllers.Controller;
import mastermind.mvc.models.Color;
import mastermind.mvc.models.Message;
import mastermind.mvc.models.ProposedCombination;
import mastermind.mvc.models.Result;

public class ProposedCombinationView {
    private final Controller controller;

    public ProposedCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void writeln() {
        Message.PROPOSED_COMBINATION.write();
    }

    public ProposedCombination read() {
        ProposedCombination proposedCombination;
        List<Color> colors = new ArrayList<Color>();
		Error error;
		do {
			error = null;
			Message.PROPOSED_COMBINATION.write();
			String characters = this.console.readString();
			if (characters.length() != ProposedCombination.getWidth()) {
				error = Error.WRONG_LENGTH;
			} else {
				for (int i = 0; i < characters.length(); i++) {
					Color color = Color.getInstance(characters.charAt(i));
					if (color == null) {
						error = Error.WRONG_CHARACTERS;
					} else {
						for(int j=0; j< colors.size(); j++){
							if (color == colors.get(j)){
								error = Error.DUPLICATED;
							}
						}
						colors.add(color);
					}
				}
			}
			if (error != null) {
				while (!colors.isEmpty()){
					colors.remove(0);
				}
			}
        } while (error != null);
        proposedCombination = new ProposedCombination(colors);
        return proposedCombination;
	}


    public void writeError(Error error) {
        error.writeln();
    }

    public void write(int attemp) {
        List<Color> colorProposeCombination = this.controller.getColorsByAttemp(attemp);
        for (Color color : colorProposeCombination) {
            color.write();
        }

        Result result = this.controller.getResultProposeCombination(attemp);
        Message.RESULT.writeln(result.getBlacks(), result.getWhites());
    }
}