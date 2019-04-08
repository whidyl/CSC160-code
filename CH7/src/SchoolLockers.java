
public class SchoolLockers {
	public static void main (String args[]) {
		boolean[] lockers;
		lockers = new boolean[100];
		// initiate all lockers to false
		for (int i = 0; i < 100; i++) {
			lockers[i] = true;
		}
		
		// loop through every person
		for (int i = 2; i < 100; i++) {
			// flip lockers that are divisible by locker number
			for (int j = 0; j < 100; j++) {
				if (((j+1)%(i)) == 0) {
					lockers[j] = !lockers[j];
				}
			}
		}
		
		// print the lockers
		for (int i = 0; i < 100; i++) {
			System.out.println("locker " + i + " is " + (lockers[i] ? "open" : "closed"));
		}
	}
}
