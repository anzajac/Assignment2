//Abby Zajac
import java.util.Scanner;
public class RecursiveOnionTester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message;
		try {
			System.out.println("Enter an odd number of binary digits: ");
			message = scan.next();
			if(message.length() % 2 == 0) {
				scan.close();
				Exception e1 = new Exception("This is an even number of binary digits. Unacceptable!");
				throw e1;
			}
			for(int i = 0; i < message.length(); i++) {
				if(message.charAt(i) < 0 || message.charAt(i) > 1) {
					scan.close();
					Exception e2 = new Exception("A digit is not binary. Unacceptable!");
					throw e2;
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
