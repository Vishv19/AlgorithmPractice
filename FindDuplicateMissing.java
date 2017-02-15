import java.util.*;

public class FindDuplicateMissing {
	
	private static class DuplicateAndMissing {
		public Integer duplicate;
		public Integer missing;

		public DuplicateAndMissing(Integer duplicate, Integer missing) {
			this.duplicate = duplicate;
			this.missing = missing;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(5);
		a.add(3);
		a.add(0);
		a.add(3);
		a.add(1);
		a.add(2);
		DuplicateAndMissing d = findDuplicateMissing(a);
		System.out.println("duplicate: " + d.duplicate);
		System.out.println("missing: " + d.missing);
	}

	public static DuplicateAndMissing findDuplicateMissing(List<Integer> A) {
		// Compute XOR of all number from 0 to |A| - 1 , i.e. all enteries in A
		int missXORDup = 0;

		for(int i = 0; i < A.size(); i++) {
			missXORDup ^= A.get(i);
		}

		// We have to find a bit that is set to 1 in missXORDup. Such a bit must exist if there is
		// a single missing number and a single duplicated number in A
		// except for the least significant bit in missXorDup that's 1.

		int differBit  = missXORDup &(~(missXORDup - 1));
		int missORDup = 0;
		for(int i = 0; i < A.size(); i++) {
			if((i & differBit)!=0) {
				missORDup ^= i;
			}
			if((A.get(i) & differBit)!=0) {
				missORDup ^= A.get(i);
			}
		}

		for(int a: A) {
			if(a == missORDup) {
				return new DuplicateAndMissing(missORDup, missORDup ^ missXORDup);
			}
		}

		return new DuplicateAndMissing(missORDup ^ missXORDup, missORDup);
	}
}