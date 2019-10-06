package mastermind.mvc.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static final int MAX_LONG = 10;
	private SecretCombination secretCombination;
	private List<ProposedCombination> proposedCombinations;
	private List<Result> results;

	public Game() {
		this.init();
	}

	public void init() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
	}

	public boolean isFinished() {
		if (this.results.get(this.getAttemps() - 1).isWinner()) {
			Message.WINNER.writeln();
			return true;
		}
		if (this.getAttemps() == MAX_LONG) {
			Message.LOOSER.writeln();
			return true;
		}
		return false;
	}

	public int getAttemps() {
		return this.proposedCombinations.size();
	}

	public int getSecretCombinationLength() {
		return this.secretCombination.colors.size();
	}

	public List<Color> getColorsByAttemp(int index) {
		return this.proposedCombinations.get(index).colors;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public Result getResult(ProposedCombination proposedCombination) {
		return this.secretCombination.getResult(proposedCombination);
	}

	public List<ProposedCombination> getProposedCombinations() {
		return this.proposedCombinations;
	}

	public boolean isWinner() {
		return this.results.get(this.getAttemps() - 1).isWinner();
	}

	public boolean isMaxAttemp() {
		return getAttemps() == MAX_LONG;
	}
}