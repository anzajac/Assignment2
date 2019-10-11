/*Assignment Two
 * RecursiveOnion.java
 * Stephen Shea and Abigail Zajac
 * 10-11-19
 * CS208
 * 
 * This class contains a recursive method that takes a binary number which is secret & decodes to its flipped version
 * meaning all binary digits switched from 0 to 1 & vice versa
 * Also a helper method called reverseDigit() helps recursive method to flip the digits of a binary number
 * Otherwise the class has the regular initiation of toString(), equals(), getter & setter methods
 */
public class RecursiveOnion {
	//class attributes
	private String message;
	private String secret;
	
	//class constructors
	//default
	public RecursiveOnion(){
		message = "0";
		secret = "0";
		setMessage(recursiveReverse(message));
	}
	//with parameter
	public RecursiveOnion(String m) {
		secret = m;
		setMessage(recursiveReverse(m));
	}
	
	
	//toString and equals methods
	//toString method to return formatted info on each RecursiveOnion
	@Override
	public String toString() {
		return "Encryted message (" + secret + ") is decryted as " + message;
	}
	//equals method to ensure inputed object is RecursiveOnion object
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(null == obj) {
			return false;
		}
		if(obj instanceof RecursiveOnion) {
			RecursiveOnion onion = (RecursiveOnion) obj;
			return message.equals(onion.message) && 
					secret.equals(onion.secret);
		}
		else {
			return false;
		}
	}
	
	//getter and setter methods
	public void setMessage(String m) {
		message = m;
	}
	
	public String getSecret() {
		return secret;
	}
	
	//helper method
	private String reverseDigit(char d) {
		if(d == '0') {
			return "1";
		}
		else {
			return "0";
		}
	}
	
	//recursive method for constructor
	private String recursiveReverse(String m) {
		int len = m.length();
		String innerMessage;
		if(len == 1) {
			return reverseDigit(m.charAt(0));
		}
		else {
			innerMessage = recursiveReverse(m.substring(1, len - 1));
			return reverseDigit(m.charAt(0)) + innerMessage + reverseDigit(m.charAt(len - 1));
		}
	}
}
