//Assignment 2
//Stephen Shea and Abigail Zajac
//Flips the digits of a binary number
public class RecursiveOnion {
	//Attributes
	private String message;
	
	//Constructors
	public RecursiveOnion(){
		message = "0";
		setMessage(recursiveReverse(message));
	}
	public RecursiveOnion(String m) {
		setMessage(recursiveReverse(m));
	}
	
	
	//toString and equals methods
	public String toString() {
		return message;
	}
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(null == obj) {
			return false;
		}
		if(obj instanceof RecursiveOnion) {
			RecursiveOnion onion = (RecursiveOnion) obj;
			return message.equals(onion.message);
		}
		else {
			return false;
		}
	}
	
	//getter and setter methods
	public void setMessage(String m) {
		message = m;
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
	
	//recursive helper method for constructor
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
