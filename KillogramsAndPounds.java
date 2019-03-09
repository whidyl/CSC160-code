
public class KillogramsAndPounds {
	public static void main(String args[]) {
		System.out.println("Kilograms         Pounds | Pounds          Kilograms");
		for (int i = 0; i < 200; i++) {
			printConversions((1 + i*2), (20 + i*5));
		}
	}

	private static void printConversions(int kilograms, int pounds) {
		// calculate kilograms to pounds
		float kilgoramsToPounds = (float)kilograms * 2.20462f;
		// calculate pounds to kilograms
		float poundsToKilograms = (float)pounds *  0.453592f;
		// print conversions
		System.out.printf("%4d              %6.1f |", kilograms, kilgoramsToPounds);
		System.out.printf("%4d              %6.2f  %n", pounds, poundsToKilograms);
	}
}
