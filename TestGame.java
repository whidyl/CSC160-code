/*
Math Quizzer Requirements:  To create a system that allows a user to interact with 6 various math operations "quizzes" 
and receive reports on their performance based on the user, total number of times the activity is repeated, highest, lowest and average scores.

For each "quiz" the system should:

1.  Welcome the user
2.  Use arrays to:
                 -  randomly generated problems
                 -  track users, scores
3.  Report user performance

The performance report should include:
1.  Date
2.  User Name
3.  Tracked data for 10 interactions and all 6 "quizzes" areas
 */

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Date;
import java.util.Random;


public class TestGame {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		// get number of user's and initialize data accordingly.
		System.out.println("Welcome to Math Quizer! How many user's are going to play?");
		int numUsers = input.nextInt();
		int[] scoreTotals = new int[numUsers];
		String[] names = new String[numUsers];
		
		Date date = new Date();
		char[] operators = {'*','/','+','-','^','%'};
		
		//quiz each user, keep track of their name and scores.
		for (int i = 0; i < numUsers; i++) {
			int[] scores = new int[6];
			System.out.println("Player " + Integer.toString(i + 1) + " is up!, what's your name?");
			String userName = input.next();
			System.out.println("Okay " + userName + ", do your best to answer the following 30 questions.");
			System.out.println();
			//run through each operator quiz and add score data to scores
			for (char operator: operators) {
				switch (operator) {
					case '*':
						scores[0] = runMultiplicationQuiz(input, rand);
						System.out.println();
						break;
					case '/':
						scores[1] = runDivisionQuiz(input, rand);
						System.out.println();
						break;
					case '+':
						scores[2] = runAdditionQuiz(input, rand);
						System.out.println();
						break;
					case '-':
						scores[3] = runSubtractionQuiz(input, rand);
						System.out.println();
						break;
					case '^':
						scores[4] = runPowerQuiz(input, rand);
						System.out.println();
						break;
					case '%':
						scores[5] = runModuloQuiz(input, rand);
						System.out.println();
						break;
					default:
						throw new RuntimeException("Illegal char to represent operation.");
				}
			}
			// Print report and add scored to database before moving on to next player
			printReport(date, userName, scores, operators);
			names[i] = userName;
			scoreTotals[i] = IntStream.of(scores).sum();
		}
		// Print out final scores, average scores, and who had the lowest and highest scores
		int maxUserIndex = 0;
		int minUserIndex = 0;
		for (int i = 0; i < numUsers; i++) {
			if (scoreTotals[i] > scoreTotals[maxUserIndex])
				maxUserIndex = i;
			if (scoreTotals[i] < scoreTotals[minUserIndex])
				minUserIndex = i;
			String playerNum = Integer.toString(i + 1);
			System.out.println(names[i] + " had a score of " + Integer.toString(scoreTotals[i]));
		}
		double averageScore = (float)IntStream.of(scoreTotals).sum()/(float)(numUsers);
		System.out.println("The average score was " + Double.toString(averageScore));
		System.out.println();
		System.out.println(names[maxUserIndex] + " had the highest score.");
		System.out.println(names[minUserIndex] + " had the lowest score.");
		System.out.println("Thanks for playing.");
		
		
	}

	private static int runMultiplicationQuiz(Scanner input, Random rand) {
		// ask the user 5 randomly generated multiplication questions, return the # correct answers
		System.out.println("Your first set of questions are multiplication problems. Enter the correct integer value for the next 5 '*' operations.");
		int score = 0;
		for (int i = 0; i < 5; i++) {
			int num1 = rand.nextInt(15);
			int num2 = rand.nextInt(15);
			System.out.println("What is " + Integer.toString(num1) + "*" + Integer.toString(num2) + "?");
			int answer = input.nextInt();
			if (answer == (num1*num2)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect, the correct answer is " + Integer.toString(num1*num2));
			}
		}
		return score;
	}
	
	private static int runDivisionQuiz(Scanner input, Random rand) {
		// ask the user 5 randomly generated division questions, return the # correct answers
		System.out.println("Your next set of questions are division problems. Enter the correct integer value for the next 5 '/' operations.");
		int score = 0;
		for (int i = 0; i < 5; i++) {
			// get an evenly divisible pair of integers.
			int num1 = 0;
			int num2 = 0;
			boolean evenlyDivisible = false;
			while (!evenlyDivisible) {
				num1 = rand.nextInt(50) + 1;
				num2 = rand.nextInt(15) + 1;
				if ((num1%num2) == 0) {
					evenlyDivisible = true;
				}
			}
			
			System.out.println("What is " + Integer.toString(num1) + "/" + Integer.toString(num2) + "?");
			int answer = input.nextInt();
			if (answer == (num1/num2)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect, the correct answer is " + Integer.toString(num1/num2));
			}
		}
		return score;
	}
	
	private static int runAdditionQuiz(Scanner input, Random rand) {
		// ask the user 5 randomly generated addition questions, return the # correct answers
		System.out.println("Your next set of questions are addition problems. Enter the correct integer value for the next 5 '+' operations.");
		int score = 0;
		for (int i = 0; i < 5; i++) {
			int num1 = rand.nextInt(100);
			int num2 = rand.nextInt(100);
			
			System.out.println("What is " + Integer.toString(num1) + "+" + Integer.toString(num2) + "?");
			int answer = input.nextInt();
			if (answer == (num1+num2)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect, the correct answer is " + Integer.toString(num1+num2));
			}
		}
		return score;
	}
	
	private static int runSubtractionQuiz(Scanner input, Random rand) {
		// ask the user 5 randomly generated subtraction questions, return the # correct answers
		System.out.println("Your next set of questions are subtraction problems. Enter the correct integer value for the next 5 '-' operations.");
		int score = 0;
		for (int i = 0; i < 5; i++) {
			int num1 = rand.nextInt(100);
			int num2 = rand.nextInt(100);
			// make sure largest number is num1.
			if (num2>num1) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			
			System.out.println("What is " + Integer.toString(num1) + "-" + Integer.toString(num2) + "?");
			int answer = input.nextInt();
			if (answer == (num1-num2)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect, the correct answer is " + Integer.toString(num1-num2));
			}
		}
		return score;
	}
	
	private static int runPowerQuiz(Scanner input, Random rand) {
		// ask the user 5 randomly generated power questions, return the # correct answers
		System.out.println("Your next set of questions are power problems. Enter the correct integer value for the next 5 '^' operations.");
		System.out.println("TIP: 5^2 means 5 to the power of 2.");
		int score = 0;
		for (int i = 0; i < 5; i++) {
			int num1 = rand.nextInt(10);
			int num2 = rand.nextInt(2)+2;
			
			System.out.println("What is " + Integer.toString(num1) + "^" + Integer.toString(num2) + "?");
			int answer = input.nextInt();
			if (answer == ((int)Math.pow(num1, num2))) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect, the correct answer is " + Integer.toString((int)Math.pow(num1, num2)));
			}
		}
		return score;
	}
	
	private static int runModuloQuiz(Scanner input, Random rand) {
		// ask the user 5 randomly generated multiplication questions, return the # correct answers
		System.out.println("Your next set of questions are on modulo problems. Enter the correct integer value for the next 5 '%' operations.");
		System.out.println("TIP: 10%3 is the remainder of 10/3 (which is 1)");
		int score = 0;
		for (int i = 0; i < 5; i++) {
			int num1 = rand.nextInt(50) + 1;
			int num2 = rand.nextInt(10) + 1;
			// make sure largest number is num1.
			if (num2>num1) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			
			System.out.println("What is " + Integer.toString(num1) + "%" + Integer.toString(num2) + "?");
			int answer = input.nextInt();
			if (answer == (num1%num2)) {
				System.out.println("Correct!");
				score++;
			} else {
				System.out.println("Incorrect, the correct answer is " + Integer.toString(num1%num2));
			}
		}
		return score;
	}
	
	private static void printReport(Date date, String name, int[] scores, char[] operators) {
		// neatly prints out quiz data to user.
		System.out.println("_______SCORE SHEET_______");
		System.out.println("DATE: " + date);
		System.out.println("NAME: " + name);
		int operatorIndex = 0;
		int totalScore = 0;
		for (int score: scores) {
			System.out.println("'" + operators[operatorIndex] +  "' SCORE: " + Integer.toString(score) + " out of 5");
			operatorIndex++;
			totalScore+=score;
		}
		System.out.println("TOTAL SCORE: " + Integer.toString(totalScore) + " out of 30.");
		System.out.println();
	}
}
