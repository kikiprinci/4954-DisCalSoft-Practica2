package mastermind.mvc.models;

public class Result {
    private int blacks = 0;
	private int whites = 0;

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	public int getBlacks() {
        return this.blacks;
    }
    
    public int getWhites() {
        return this.whites;
    }

	boolean isWinner() {
		return this.blacks == Combination.getWidth();
	}

	void writeln() {
		Message.RESULT.writeln(this.blacks, this.whites);
	}

}