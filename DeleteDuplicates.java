import java.util.*;

public class DeleteDuplicates {
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(2);
		A.add(3);
		A.add(5);
		A.add(5);
		A.add(7);
		A.add(11);
		A.add(11);
		A.add(11);
		A.add(13);
		System.out.println(A);
		deleteDuplicates(A);
		System.out.println(A);
	}

	public static int deleteDuplicates(List<Integer> A) {
		if(A.size() == 0) {
			return 0;
		}

		int writeIndex = 1;
		for(int i = 1; i < A.size(); i++) {
			System.out.println("writeIndex: " + writeIndex);
			System.out.println("i: " + i);
			if(!A.get(writeIndex - 1).equals(A.get(i))) {
				// System.out.println("in condition");
				A.set(writeIndex++, A.get(i));
			}
		}
		return writeIndex;
	}
}