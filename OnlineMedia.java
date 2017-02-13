import java.util.*;

public class OnlineMedia {
	public static final int DEFAULT_INITIAL_CAPACITY = 16;
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();

		al.add(1);
		al.add(0);
		al.add(3);
		al.add(5);
		al.add(2);
		al.add(0);
		al.add(1);
		Iterator<Integer> itr = al.iterator();
		onlineMedia(itr);
	}

	public static void onlineMedia(Iterator<Integer> sequence) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, Collections.reverseOrder());

		while(sequence.hasNext()) {
			int next = sequence.next();
			if(minHeap.isEmpty()) {
				minHeap.add(next);
			}
			else {
				if(next >= minHeap.peek()) {
					minHeap.add(next);
				}
				else {
					maxHeap.add(next);
				}
			}

			System.out.println("minHeap " + minHeap);
			System.out.println("maxHeap " + maxHeap);
		}

		if(minHeap.size() > maxHeap.size() + 1) {
			maxHeap.add(maxHeap.remove());
		}
		else if(maxHeap.size() > minHeap.size()) {
			minHeap.add(maxHeap.remove());
		}
		double answer = minHeap.size() == maxHeap.size() ? 0.5 *(minHeap.peek() + maxHeap.peek()) :minHeap.peek();
		System.out.println(answer);
	}
}