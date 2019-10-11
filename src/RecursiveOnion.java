/*Assignment Two
 * RecursiveOnion.java
 * Stephen Shea and Abigail Zajac
 * 10-11-19
 * CS208
 * 
 * This class contains a recursive method that takes a binary number (String) which is secret & decodes to its flipped version (int)
 * meaning all binary digits switch from 0 to 1 & vice versa then changes binary number (int) from  
 * recursiveReverse() to string
 * Also a helper method called reverseDigit() helps recursive method to flip the digits of a binary number
 * Plus the class has the regular overriding of toString() & equals() 
 */
import java.lang.Math;
public class RecursiveOnion {
	//class attributes
	private String message;
	private int len;
	
	//class constructors
	//default
	public RecursiveOnion(){
		message = "0";
		int m = Integer.parseInt(message);
		len = 1;
		setBinToString(recursiveReverse(m, len));
	}
	//with parameter
	public RecursiveOnion(String m) {
		int bin = Integer.parseInt(m);
		len = m.length();
		setBinToString(recursiveReverse(bin, len));
	}
	
	
	//toString and equals methods
	//toString method to return formatted info on each RecursiveOnion
	@Override
	public String toString() {
		return message;
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
			return message.equals(onion.message);
		}
		else {
			return false;
		}
	}
	
	//main methods
	//sets any binary number that is integer to string
	public String setBinToString(int m) {
		String bin = "" + m;
		while(len > bin.length()) {
			bin = "0" + bin;
		}
		message = bin;
		return message;
	}
	
	//helper method
	private int reverseDigit(int d) {
		if(d == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	//recursive method for constructor
	private int recursiveReverse(int m, int len) {
		//constant 10
		int ten = 10;
		//final binary number
		int bin = 0;
		//leading binary digit
		int digit1 = 0;
		//trailing binary number
		int digit2 = 0;
		//base case
		if(len == 1) {
			return reverseDigit(m);
		}
		//recursive case
		else {
			digit1 = m / (int)(Math.pow(ten, len-1));
			digit2 = m % ten;
			if(digit1 == 1) {
				m-= (int)(Math.pow(ten, len-1));
			}
			m/= 10;
			bin = recursiveReverse(m, len-2);
		}
		bin*= ten;
		bin+= reverseDigit(digit2);
		bin+= reverseDigit(digit1) * (int)(Math.pow(ten, len-1));
		return bin;
	}
}
