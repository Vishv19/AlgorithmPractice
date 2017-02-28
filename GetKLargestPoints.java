import java.util.*;

// There is a large text file with a list of point (x,y). It is too big to fit in memory
// Find k smallest points from the list, we can find k largest if we replace max heap with min heap

public class GetKLargestPoints {

	public static void main(String[] args) {
		EndPoint p1 = new EndPoint(0,2);
		EndPoint p2 = new EndPoint(0,3);
		EndPoint p3 = new EndPoint(0,4);
		EndPoint p4 = new EndPoint(0,5);
		EndPoint p5 = new EndPoint(0,6);
		ArrayList<EndPoint> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		// ArrayList<EndPoint> list = Arrays.asList(p1,p2,p3,p4,p5);
		Iterator<EndPoint> iter = list.iterator();
		List<EndPoint> result = topK(3, iter);
		for(int i = 0; i < result.size(); i++) {
			System.out.println("start: " + result.get(i).start + " " + "end: " + result.get(i).end);
			// System.out.println(result.get(i).end);
		}
	}

	public static class EndPoint {
		double start;
		double end;

		public EndPoint(double s, double e) {
			start = s;
			end = e;
		}

		public double distanceFromOrgin() {
			return Math.sqrt((start*start) + (end*end));
		}
	}

	public static List<EndPoint> topK(int k, Iterator<EndPoint> iter) {
		PriorityQueue<EndPoint> maxHeap = new PriorityQueue<>(k, new Comparator<EndPoint> () {
			public int compare(EndPoint p1, EndPoint p2) {
				// passing reverese parameter creates a max heap, passing in the same order will create min heap
				return Double.compare(p2.distanceFromOrgin(), p1.distanceFromOrgin());
			}
		});
		while(iter.hasNext()) {
			maxHeap.add(iter.next());
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return new ArrayList<>(maxHeap);
	}
}

