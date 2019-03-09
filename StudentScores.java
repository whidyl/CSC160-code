import java.util.Scanner;

public class StudentScores {
	public static void main(String args[]) {
		// initialize student info
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the number of students: ");
		int numStudents = input.nextInt();
		
		String highestStudentName = "Unset";
		float highestStudentScore = 0;
		String secondHighestStudentName = "Unset";
		float secondHighestStudentScore = 0;
		
		for (int i = 0; i < numStudents; i++) {
			// get specific student score and name, then update highest/second highest
			System.out.printf("%nPlease enter student %d's name: ", i+1);
			String name = input.next();
			System.out.printf("Please enter %s's test score: ", name);
			float score = input.nextFloat();
			
			// update student variables
			if (score > highestStudentScore) {
				//move previous high score to second
				secondHighestStudentName = highestStudentName;
				secondHighestStudentScore = highestStudentScore;
				
				highestStudentName = name;
				highestStudentScore = score;
			}
			else if ((score > secondHighestStudentScore) && (highestStudentName != name)) {
				secondHighestStudentName = name;
				secondHighestStudentScore = score;
			}
		}
		
		System.out.printf("%s had the highest score with %4.4f %n", highestStudentName, highestStudentScore);
		System.out.printf("%s had the second highest score with %4.4f", secondHighestStudentName, secondHighestStudentScore);
	}
}
