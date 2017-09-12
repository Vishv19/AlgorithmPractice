import java.util.*;

public class PriorityQueueMedia {
	public static void main(String[] args) {
		// PriorityQueue < Integer >  prq = new PriorityQueue < Integer > (4, Collections.reverseOrder());
		PriorityQueue < Integer >  prq = new PriorityQueue < Integer > (4, new Comparator<Integer> () {
			public int compare(Integer lhs, Integer rhs) {
				if(lhs > rhs) return -1;
				if(lhs.equals(rhs)) return 0;
				return 1;
			}
		});
		prq.add(4);
		prq.add(1);
		prq.add(2);
		prq.add(5);
		System.out.println(prq);

		ArrayList<String> al = new ArrayList<String>();

		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			System.out.print(element + " ");
		}
	}
}