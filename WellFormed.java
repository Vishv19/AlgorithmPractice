import java.util.*;
import java.io.*;

public class WellFormed {
	public static void main(String[] args) throws IOException{
		//InputStreamReader ins = new InputStreamReader(System.in);
		BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
		String s = bufRead.readLine();
		// Scanner scan = new Scanner(System.in);
		// String s = scan.next();
		// int i = scan.nextInt();
		System.out.println(isWellFormed(s));
	}

	public static boolean isWellFormed(String s) {
		Deque<Character> leftChar = new LinkedList<Character>();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				leftChar.addFirst(s.charAt(i));
			}
			else {
				if(leftChar.isEmpty()) {
					return false;
				}
				if(s.charAt(i) == ')' && leftChar.peekFirst() != '(' ||
				   s.charAt(i) == '}' && leftChar.peekFirst() != '{' ||
				   s.charAt(i) == ']' && leftChar.peekFirst() != '[') {
					return false;
				}
				leftChar.removeFirst();
			}
		}
		return leftChar.isEmpty();
	}
}