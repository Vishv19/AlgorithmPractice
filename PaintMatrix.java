import java.util.*;

public class PaintMatrix {
    private static class Coordinate {
        public Integer x;
        public Integer y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }   

    public static void flipColor(List<List<Boolean>> A, int x, int y) {
        boolean color = A.get(x).get(y);

        final int[][] DIRS = {{-1,0}, {0,-1}, {0,1}, {-1,0}};
        Queue<Coordinate> q = new LinkedList<>();
        A.get(x).set(y, !A.get(x).get(y));
        q.add(new Coordinate(x, y));

        // traverse till q is empty
        while(!q.isEmpty()) {
            // traverse the first element in the queue
            Coordinate current = q.remove();
            for(int[] dir: DIRS) {
                Coordinate next = new Coordinate(current.x + dir[0], current.y + dir[1]);

                // check the boundary conditions
                if(next.x >=0 && next.x < A.size() && next.y >=0 && next.y < A.get(next.x).size()
                    && A.get(next.x).get(next.y) == color) {
                    q.add(next);
                    A.get(next.x).set(next.y, !color);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Boolean>> A = new ArrayList<>();
        A.add(Arrays.asList(true, false, false, true));
        A.add(Arrays.asList(true, true, false, true));
        A.add(Arrays.asList(true, false, true, true));
        A.add(Arrays.asList(true, false, false, true));

        flipColor(A, 3, 1);
        System.out.println(A);     
    }
}