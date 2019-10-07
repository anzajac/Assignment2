//Assignment 2
//Stephen Shea and Abigail Zajac
import java.util.Scanner;
public class RecursiveOnionTester {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message;
		boolean exitFlag = false;
		while(!exitFlag) {
			try {
				System.out.println("Enter an odd number of binary digits or exit to end program: ");
				message = scan.next();
				if(message.equals("exit")) {
					exitFlag = true;
					scan.close();
				}
				else{
					if(message.length() % 2 == 0) {
						scan.close();
						Exception e1 = new Exception("This is an even number of digits. Unacceptable!");
						throw e1;
					}
					for(int i = 0; i < message.length(); i++) {
						if(message.charAt(i) != '0' && message.charAt(i) != '1') {
							scan.close();
							Exception e2 = new Exception("A digit is not binary. Unacceptable!");
							throw e2;
						}
					}
					RecursiveOnion onion1 = new RecursiveOnion(message);
					System.out.println(onion1.toString());
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				exitFlag = true;
			}
		}
	}
}
