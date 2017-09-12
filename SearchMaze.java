public class SearchMaze {
	private static class Coordinate {
		public int x;
		public int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			if(o == null || getClass() != o.getClass()) {
				return false;
			}

			Coordinate that = (Coordinate) o;
			if(that.x != this.x || that.y != this.y) {
				return false;
			}
			return true;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x,y);
		}
	}

	public static enum Color {WHITE, BLACK};

	public static List<Coordinate> searchMaze(List<List<Coordinate>> maze, Coordinate s, Coordinate e) {
		List<Coordinate> path = new ArrayList<>();
		maze.get(s.x).set(s.y, Color.BLACK);
		path.add(s);
		if(searchMazeHelper(maze, path, s, e)) {
			return path;
		}
		path.remove(path.size()-1);
		return path;
	}

	public static boolean searchMazeHelper(List<List<Coordinate>> maze, List<Coordinate> path, Coordinate cur, Coordinate e) {
		// base case
		if(cur.equals(e)) {
			return true;
		}

		final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

		for(int[] dir: DIRS) {
			Coordinate next = new Coordinate(cur.x + dir[0], cur.y + dir[1]);
			if(isFeasible(maze, next)) {
				maze.get(next.x).set(next.y, Color.BLACK);
				path.add(next);
				if(searchMazeHelper(maze, next, e)) {
					return true;
				}
				path.remove(path.size()-1);
			}
		}
		return false;
	}

	public static boolean isFeasible(List<List<Coordinate>> maze, Coordinate cur) {
		return cur.x >=0 && cur.x < maze.size() && cur.y >= 0 && cur.y < maze.get(cur.x).size()
				&& maze.get(cur.x).get(cur.y) == Color.WHITE;
	}

}