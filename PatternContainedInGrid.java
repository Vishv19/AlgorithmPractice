import java.util.*;

public class PatternContainedInGrid {
	public static void main(String[] args) {
		List<List<Integer>> matrix = new ArrayList<>();
		matrix.add(Arrays.asList(1, 2, 3));
		matrix.add(Arrays.asList(3, 4, 5));
		matrix.add(Arrays.asList(5, 6, 7));
		List<Integer> pattern = Arrays.asList(1,3,4,5);
		System.out.println(isPatternContainedInGrid(matrix,pattern));
	}

	public static class Attempt {
		Integer x;
		Integer y;
		Integer offset;

		Attempt(int x, int y, int offset) {
			this.x = x;
			this.y = y;
			this.offset = offset;
		}

		public boolean equals(Object o) {
			//check if the object reference matches
			if(this == o) {
				return true;
			}
			//check if both the class matches
			if(o==null || getClass() != o.getClass()) {
				return false;
			}

			Attempt cacheEntry = (Attempt)o;

			if(x!=null ? !x.equals(cacheEntry.x): cacheEntry.x!=null) {
				return false;
			}
			if(y!=null ? !y.equals(cacheEntry.y): cacheEntry.y!=null) {
				return false;
			}
			if(offset!=null ? !offset.equals(cacheEntry.offset): cacheEntry.offset!=null) {
				return false;
			}

			return true;
		}

		@Override
		public int hashCode() {return Objects.hash(x, y, offset);}
	}

	public static boolean isPatternContainedInGrid(List<List<Integer>> grid, List<Integer> pattern) {
		Set<Attempt> previousAttempts = new HashSet<>();
		for(int i = 0; i < grid.size(); i++) {
			for(int j = 0; j < grid.get(i).size(); j++) {
				if(isPatternSuffixContainedStartingAtXY(grid, i, j, pattern, 0, previousAttempts)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isPatternSuffixContainedStartingAtXY(List<List<Integer>>grid, int x, int y, List<Integer>pattern, int offset, Set<Attempt>previousAttempts) {
		if(offset == pattern.size()) {
			return true;
		}

		//check if the coordinates are not out of the boundary limits
		if(x < 0 || x >= grid.size() || y < 0 || y >= grid.get(x).size() 
			|| previousAttempts.contains(new Attempt(x,y,offset))) {
			return false;
		}

		if(grid.get(x).get(y).equals(pattern.get(offset)) 
			&& (isPatternSuffixContainedStartingAtXY(grid, x-1, y, pattern, offset+1, previousAttempts)
				|| isPatternSuffixContainedStartingAtXY(grid, x+1, y, pattern, offset+1, previousAttempts)
				|| isPatternSuffixContainedStartingAtXY(grid, x, y-1, pattern, offset+1, previousAttempts)
				|| isPatternSuffixContainedStartingAtXY(grid, x, y+1, pattern, offset+1, previousAttempts))) {
			return true;
		}

		previousAttempts.add(new Attempt(x, y, offset));
		return false;
	}
}