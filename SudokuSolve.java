import java.util.*;

public class SudokuSolve {
	private static final int EMPTY_ENTRY = 0;
	public static void main(String[] args) {
		List<List<Integer>> A
        = Arrays.asList(Arrays.asList(0, 2, 6, 0, 0, 0, 8, 1, 0),
                        Arrays.asList(3, 0, 0, 7, 0, 8, 0, 0, 6),
                        Arrays.asList(4, 0, 0, 0, 5, 0, 0, 0, 7),
                        Arrays.asList(0, 5, 0, 1, 0, 7, 0, 9, 0),
                        Arrays.asList(0, 0, 3, 9, 0, 5, 1, 0, 0),
                        Arrays.asList(0, 4, 0, 3, 0, 2, 0, 5, 0),
                        Arrays.asList(1, 0, 0, 0, 3, 0, 0, 0, 2),
                        Arrays.asList(5, 0, 0, 2, 0, 4, 0, 0, 9),
                        Arrays.asList(0, 3, 8, 0, 0, 0, 4, 6, 0));
        System.out.println(solveSudoku(A));
        System.out.println(A);
	}

	public static boolean solveSudoku(List<List<Integer>> partialAssignment) {
		return solvePartialSudoku(0,0,partialAssignment);
	}

	private static boolean solvePartialSudoku(int i, int j, List<List<Integer>> partialAssignment) {
		//base case for the problem
		if(i == partialAssignment.size()) {
			i = 0; //starts a new row
			if(++j == partialAssignment.get(i).size()) {
				return true; //entire matrix has been filled without conflict.
			}
		}

		System.out.println("j: " + j);

		//go to next entry if it is already filled up
		if (partialAssignment.get(i).get(j) != EMPTY_ENTRY) {
			return solvePartialSudoku(i+1, j, partialAssignment);
		}

		for (int val = 1; val <= partialAssignment.size(); val++) {
			if(validToAddVal(partialAssignment, i, j, val)) {
				partialAssignment.get(i).set(j, val);
				if(solvePartialSudoku(i+1, j, partialAssignment)) {
					return true;
				}
			}
		}

		partialAssignment.get(i).set(j, EMPTY_ENTRY);
		return false;
	}

	private static boolean validToAddVal(List<List<Integer>> partialAssignment, int i, int j, int val) {
		//check row constraints
		for(List<Integer> element: partialAssignment) {
			if(val == element.get(j)) {
				return false;
			}
		}

		for(int k = 0; k < partialAssignment.size(); k++) {
			if(val == partialAssignment.get(i).get(k)) {
				return false;
			}
		}

		int regionSize = (int) Math.sqrt(partialAssignment.size());
		int I = i/regionSize, J = j/regionSize;

		for(int a = 0; a < regionSize; a++) {
			for(int b = 0; b < regionSize; b++) {
				if(val == partialAssignment.get(regionSize*I+a).get(regionSize * J +b)) {
					return false;
				}
			}
		}

		return true;
	}
}