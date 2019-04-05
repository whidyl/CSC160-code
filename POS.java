import java.util.Scanner; 

public class POS {
	public static void main(String Args[]) {
		
		/* POS (Point-of-Sale) System Requirements:  
		 * To create a system that creates a sales receipts at the point-of-sale for a business
		 * and reports daily sales based on the user, total number of items sold, total sales (without sales tax) and total sales tax.
		 * */
		
		/* Each sale should:
		 * 1.  Welcome the user
		 * 2.  Take in the user/clerk name
		 * 3.  Display a menu of 10 choices
		 * 4.  Provide interactions to accept items to be purchased
		 * 5.  Total the items
		 * 6.  Total the number of items in the sale
		 * 7.  Generate a tax amount for the sale
		 * 8.  Generate a grand total for the sale
		 * 9.  Print a receipt that includes:
           	  a.  a company name 
           	  b.  the name of the user/clerk
           	  c.  the itemized details of the sale
		 * 10.  Re-set itself for next sale
		 */
		// localDate.now() to get date
		
		
		while (true) {
			System.out.println();
			System.out.println("Hi, welcome to Taco Bell!");
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter your name: ");
			String name = input.next();
			printMenu();
			processUserOrder(name, input);
		}
	}
	
	public static void printMenu() {
		System.out.println("__________MENU________");
		System.out.println();
		System.out.println("         Tacos");
		System.out.println("0. Crunchy Taco: $1.19");
		System.out.println("1. Crunchy Taco Supreme: $1.69");
		System.out.println();
		System.out.println("         Burritos");
		System.out.println("2. Bean Burrito: $1.79");
		System.out.println("3. Beefy 5-Layer Burrito: $1.69");
		System.out.println("4. Combo Burrito: $2.59");
		System.out.println("5. Burrito Supreme: $3.19");
		System.out.println();
		System.out.println("         Specialties");
		System.out.println("6. Chalupa Supreme: $3.19");
		System.out.println("7. Cheese Quesadilla: $2.49");
		System.out.println("8. Quesarito: $2.59");
		System.out.println("9. Soda: $1.19");
	}
	
	public static void processUserOrder(String customerName, Scanner input) {
		System.out.println();
		System.out.println("And what would you like to order, " + customerName + "?");
		System.out.println("Enter a number 0-9 to add an item to your ticket.");
		System.out.println("Enter any non-number character to finalize your order.");
		boolean orderOver = false;
		int itemCount = 0;
		float total = 0;
		String itemizedStr = "";
		do {
			String usrInp= input.next();
			switch (usrInp) {
				case "0":
					total += 1.19;
					itemizedStr += "Crunchy Taco             $1.19 \n" ;
					break;
				case "1":
					total += 1.69;
					itemizedStr += "Crunchy Taco Supreme     $1.69\n" ;
					break;
				case "2":
					total += 1.79;
					itemizedStr += "Bean Burrito: $1.79      $1.79\n" ;
					break;
				case "3":
					total += 1.69;
					itemizedStr += "Beefy 5-Layer Burrito    $1.69\n" ;
					break;
				case "4":
					total += 2.59;
					itemizedStr += "Combo Burrito            $2.59\n";
					break;
				case "5":
					total += 3.19;
					itemizedStr += "Burrito Supreme          $3.19\n" ;
					break;
				case "6":
					total += 3.19;
					itemizedStr += "Chalupa Supreme          $3.19\n" ;
					break;
				case "7":
					total += 1.69;
					itemizedStr += "Cheese Quesadilla        $2.49\n" ;
					break;
				case "8":
					total += 1.69;
					itemizedStr += "Quesarito                $2.59\n" ;
					break;
				case "9":
					total += 1.19;
					itemizedStr += "Soda                     $1.19\n" ;
					break;
				default:
					orderOver = true;
					break;
			}
			itemCount += 1;
			if (!orderOver)
				System.out.println("Ok, anything else?");
		} while (!orderOver);
		System.out.println("Order finalized, enter any character to print receipt.");
		input.next();
		float tax = total * 0.10f;
		printReceipt(itemCount, total, tax,  itemizedStr, customerName);
	}

	private static void printReceipt(int itemCount, float total, float tax, String itemizedStr, String customerName) {
		// TODO Auto-generated method stub
		System.out.println("___________Taco Bell___________");
		System.out.println("Receipt for customer " + customerName);
		System.out.println();
		System.out.println(itemizedStr);
		System.out.printf("TAX:   $%3.2f \n" , tax);
		System.out.printf("TOTAL: $%3.2f \n" , total + tax);
		
	}
}
