public class Dice{
	private int sides;

	Dice(int sd) {
		sides = sd;
	}

	public int roll() {
		return (int) (Math.random() * this.sides + 1);
	}
}
