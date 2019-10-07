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
				}
				else if(message.length() % 2 == 0) {
					scan.close();
					Exception e1 = new Exception("This is an even number of binary digits. Unacceptable!");
					throw e1;
				}
				else {
					for(int i = 0; i < message.length(); i++) {
						if(message.charAt(i) != '0' && message.charAt(i) != '1') {
							scan.close();
							Exception e2 = new Exception("A digit is not binary. Unacceptable!");
							throw e2;
						}
					}
				}
				if(!exitFlag) {
					RecursiveOnion onion1 = new RecursiveOnion(message);
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
