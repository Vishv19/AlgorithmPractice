import java.util.*;

public class PhoneMnemonic {
	public static void main(String[] args) {
		String number = "2276696";
		
		List<String> allMemonics = new ArrayList<String>();
		char[] partialMemonics = new char[number.length()];
		phoneMnemonic(number, 0, partialMemonics, allMemonics);
		System.out.println(allMemonics.size());
		// for(int i = 0; i < allMemonics.size(); i++) {
		// 	System.out.println(allMemonics.get(i));
		// }
	}

	public static final String mapping[] = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	public static void phoneMnemonic(String number, int index, char[] partialMemonics, List<String> allMemonics) {

		if(index == number.length()) {
			allMemonics.add(String.valueOf(partialMemonics));
		}
		else {
//			System.out.println("index: " +  index + " " + mapping[number.charAt(index) - '0'].length());
			for(int i = 0; i < mapping[number.charAt(index) - '0'].length(); i++) {
				char c = mapping[number.charAt(index) - '0'].charAt(i);
				partialMemonics[index] = c;
				phoneMnemonic(number, index+1, partialMemonics, allMemonics);
			}
		}
	}
}