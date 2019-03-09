
public class PrintCharset {
	public static void main(String args[]) {
		for (int c = 33; c < 127; c++) {
			System.out.print(((char) (c)) + " " );
			if ((c-2)%10 == 0 ) {
				System.out.println();
			}
		}
	}
}
