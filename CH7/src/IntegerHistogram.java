
public class IntegerHistogram {
	public static void main(String args[]) {
		int[] hundredInts;
		hundredInts = new int[100];
		int[] counts;
		counts = new int[10];
		
		// generate 100 random integers 0-9
		for (int i = 0; i < 100; i++) {
			hundredInts[i] = (int)(Math.random() * 10);
		}
		
		// count frequency of ints
		for (int i = 0; i < 100; i++) {
			counts[hundredInts[i]] += 1;
		}
		
		// print 100 ints
		System.out.println("---- 100 random ints 0-9 ----");
		for (int i = 0; i < 100; i++) {
			System.out.println(hundredInts[i]);
		}
		
		// print frequencies
		System.out.println("---- frequency of ints ----");
		for (int i = 0; i < 10; i++) {
			System.out.println(Integer.toString(i) + ": " + counts[i]);
		}
	}
}
