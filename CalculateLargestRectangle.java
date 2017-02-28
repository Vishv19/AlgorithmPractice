import java.util.*;

public class CalculateLargestRectangle {
	public static void main(String[] args) {
		List<Integer> heights = Arrays.asList(1,3,2,5,6,3,2,6,6,5,2,1,3);
		System.out.println(calculateLargestRectangle(heights));
	}

	public static int calculateLargestRectangle(List<Integer> heights) {
		Deque<Integer> pillarIndixces = new LinkedList<Integer>();
		int maxRectangleArea = 0;
		for(int i = 0; i < heights.size(); i++) {
			//Replace the earlier building with same height by current building. This ensures
			//that the later building have correct left end point.
			if(!pillarIndixces.isEmpty() && i < heights.size()
				&& heights.get(i).equals(heights.get(pillarIndixces.peekFirst()))) {
				pillarIndixces.removeFirst();
				pillarIndixces.addFirst(i);
			}

			while(!pillarIndixces.isEmpty() && heights.get(i) < heights.get(pillarIndixces.peekFirst())
				&& isNewPillarOrReachEnd(heights, i, pillarIndixces.peekFirst())) {
				int height = heights.get(pillarIndixces.removeFirst());
				int width = pillarIndixces.isEmpty() ? i : i-pillarIndixces.peekFirst() - 1;
				// System.out.println("peekFirst: " + pillarIndixces.peekFirst());
				// System.out.println("height: " + height);
				// System.out.println("i: " + i);
				// System.out.println("width: " + width);
				maxRectangleArea = Math.max(maxRectangleArea, height * width);
			}
			pillarIndixces.addFirst(i);
		}
		return maxRectangleArea;
	}

	public static boolean isNewPillarOrReachEnd(List<Integer> heights, int currentIdx, int lastBlockedIdx) {
		return currentIdx < heights.size() ? heights.get(currentIdx) < heights.get(lastBlockedIdx): true;
	}
}