import java.util.ArrayList;

public class DecimalToHex {
	private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	public static void main(String args[]) {
		System.out.println(dec2Hex(15));
		System.out.println(dec2Hex(81832));
		System.out.println(dec2Hex(120));
		System.out.println(dec2Hex(256));
		System.out.println(dec2Hex(1938483779));
	}
	
	public static String dec2Hex(int value) {
		/* 
		 * Returns the hexadecimal equivalent to value
		 * EX: dec2Hex(25) returns "19"
		 * 1. Write down the remainder (in hex)
		 * 2. Divide by 16.
		 * 3. Repeat 1-2 until quotient is 0.
		 * 4. The hex value is the digit sequence of the remainders from last to first.
		*/
		ArrayList<Character> digits = new ArrayList<Character>(); // see if we can calculate the length of this
		int remainder = value%16;
		digits.add(0, hexDigits[remainder]);
		int quotient = value/16;
		if (quotient == 0) {
			return Character.toString(digits.get(0)) + "h";
		} else {
			return dec2Hex(quotient, digits);
		}
	}
	
	public static String dec2Hex(int value, ArrayList<Character> digits) {
		/* 
		 * Returns the hexadecimal equivalent to value given a list of digits.
		*/
		int remainder = value%16;
		digits.add(0, hexDigits[remainder]);
		int quotient = value/16;
		if (quotient == 0) {
			String output = "";
			for (Character hexChar: digits) {
				output+=Character.toString(hexChar);
			}
			output += "h";
			return output;
		} else {
			return dec2Hex(quotient, digits);
		}
	}

}
