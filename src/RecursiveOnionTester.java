/*Assignment Two
 * RecursiveOnionTester.java
 * Stephen Shea and Abigail Zajac
 * 10-11-19
 * CS208
 * 
 * This class tests recursion from RecursiveOnion
 * User must input secret binary number in odd number of digits in 0s & 1s
 * Program must print out the decoded & flipped binary number
 * This goes on continuously in a while loop until user enters "exit"
 */
import java.util.Scanner;
public class RecursiveOnionTester {
	public static void main(String[] args) {
		//initiate variable and scanner for user input
		Scanner scan = new Scanner(System.in);
		String message;
		//flag to continue while loop as false & true for exit
		boolean exitFlag = false;
		//while loop to repeat the recursive class
		while(!exitFlag) {
			//looking for errors as even number of binary digits or digits not 0 and/or 1
			try {
				//asks user input
				System.out.println("Enter an odd number of binary digits to continue or 'exit' to end program: ");
				message = scan.next();
				//changes flag to true to end loop when user enters "exit"
				if(message.equals("exit")) {
					exitFlag = true;
					scan.close();
				}
				else{
					//checking for any even amount of binary digits which prints exception
					if(message.length() % 2 == 0) {
						scan.close();
						Exception e1 = new Exception("This is an even number of digits. Unacceptable!");
						throw e1;
					}
					//checking for any non-binary digit which prints exception
					for(int i = 0; i < message.length(); i++) {
						if(message.charAt(i) != '0' && message.charAt(i) != '1') {
							scan.close();
							Exception e2 = new Exception("A digit is not binary. Unacceptable!");
							throw e2;
						}
					}
					//if no exceptions then create RecursiveOnion object
					RecursiveOnion onion1 = new RecursiveOnion(message);
					//outputs decoded & flipped binary number
					System.out.println(onion1.toString());
				}
			}
			//will catch any exception to then print out exception message
			catch(Exception e) {
				System.out.println(e.getMessage());
				exitFlag = true;
			}
		}
	}
}
