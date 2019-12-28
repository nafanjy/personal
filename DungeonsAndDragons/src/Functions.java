public class Functions{
	public static int calculateBonus(int total) {
		int bonus;
		if (total % 2 != 0 && total - 10 < 0){
			bonus = (total - 10) / 2 - 1;
		} else {
			bonus = (total - 10) / 2;
		}

		return bonus;
	}
}
