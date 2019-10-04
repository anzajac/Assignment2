//Abby Zajac
public class RecursiveOnion {
	private String message;
	
	public RecursiveOnion(){
		message = "0";
		setMessage(recursiveReverse(message));
		System.out.println(toString());
	}
	
	public RecursiveOnion(String m) {
		setMessage(recursiveReverse(m));
		System.out.println(toString());
	}
	
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
	
	public void setMessage(String m) {
		message = m;
	}
	
	private String reverseDigit(char d) {
		if(d == '0') {
			return "1";
		}
		else {
			return "0";
		}
	}
	
	private String recursiveReverse(String m) {
		int len = message.length();
		String innerMessage;
		if(len == 1) {
			return reverseDigit(message.charAt(0));
		}
		else {
			innerMessage = recursiveReverse(message.substring(1, len - 1));
			return reverseDigit(message.charAt(0)) + innerMessage + reverseDigit(message.charAt(len - 1));
		}
	}
}
