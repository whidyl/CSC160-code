
public class SalesAmount {
	public static void main(String args[]) {
		// calculate the minimum sales it would take to make 300000
		float baseSalary = 5000;
		
		// start by checking sales with an increment of 100 to save processing time
		float sales = 0;
		while ((getCommission(sales) + 5000) < 30000f) {
			sales += 100f;
		}
		
		// finish by decrementing by 1 cent to get an exact answer
		while((getCommission(sales) + 5000) < 30000f) {
			sales -= 0.01f;
		}
		
		float minimumSales = sales + 0.01f;
		System.out.println(minimumSales);
	}

	private static float getCommission(float sales) {
		// return commission based on the following commission chart:
		// 0.01 - 5,000       : 8 percent
		// 5,000.01 - 10,0000 : 10 percent
		// 10,000 +           : 12 percent
		// this is at a graduated rate.
		
		if (sales <= 5000) {
			return (sales*0.08f);
		} else if (sales <= 10000) {
			return((5000f*0.08f) + ((sales-5000f)*0.1f) );
		} else {
			return((5000f*0.08f) + (5000f*0.1f) + ((sales-10000f) * 0.12f));
		}	
	}	
}
