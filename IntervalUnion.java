import java.util.*;

public class IntervalUnion {
	public static class Interval implements Comparable<Interval> {
		public Endpoint left = new Endpoint();
		public Endpoint right = new Endpoint();

		private static class Endpoint {
			public int val;
			public boolean isClosed;
		}

		public int compareTo(Interval i) {
			if(Integer.compare(left.val, i.left.val)!=0) {
				return left.val - i.left.val;
			}
			if(left.isClosed && !i.left.isClosed) {
				return -1;
			}
			if(!left.isClosed && i.left.isClosed) {
				return 1;
			}
			return 0;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == null || !(obj instanceof Interval)) {
				return false;
			}
			if(this == obj) {
				return true;
			}
			Interval that = (Interval)obj;
			return left.val == that.left.val && left.isClosed == that.left.isClosed;
		}

		@Override
		public int hashCode() { return Objects.hash(left.val, left.isClosed);}
	}

	public static List<Interval> unionOfInterval(List<Interval> intervals) {
		if(intervals.isEmpty()) {
			return Collections.EMPTY_LIST;
		}

		Collections.sort(intervals);
		Interval curr = intervals.get(0);
		List<Interval> result = new ArrayList<>();

		for(int i = 1; i < intervals.size(); i++) {
			if(intervals.get(i).left.val < curr.right.val
				|| (intervals.get(i).left.val == curr.right.val
				&&	(intervals.get(i).left.isClosed || curr.right.isClosed))) {
				if(intervals.get(i).right.val > curr.right.val 
					|| (intervals.get(i).right.val == curr.right.val
					&&	intervals.get(i).right.isClosed)) {
					curr.right = intervals.get(i).right;
				}
			} else {
				result.add(curr);
				curr = intervals.get(i);
			}
		}
		result.add(curr);
		return result;
	}

	public static void main(String[] args) {
		Interval one = new Interval();
		Interval two = new Interval();
		Interval three = new Interval();
		Interval four = new Interval();
		Interval five = new Interval();
		Interval six = new Interval();
		Interval seven = new Interval();
		Interval eight = new Interval();
		Interval nine = new Interval();
		Interval ten = new Interval();
		Interval eleven = new Interval();
		Interval tweleve = new Interval();

		one.left.val = 0;
		one.right.val = 3;
		one.left.isClosed = false;
		one.right.isClosed = false;

		two.left.val = 1;
		two.right.val = 1;
		two.left.isClosed = true;
		two.right.isClosed = true;

		three.left.val = 3;
		three.right.val = 4;
		three.left.isClosed = true;
		three.right.isClosed = false;

		four.left.val = 2;
		four.right.val = 4;
		four.left.isClosed = true;
		four.right.isClosed = true;

		five.left.val = 5;
		five.right.val = 7;
		five.left.isClosed = true;
		five.right.isClosed = false;

		six.left.val = 7;
		six.right.val = 8;
		six.left.isClosed = true;
		six.right.isClosed = false;

		seven.left.val = 8;
		seven.right.val = 11;
		seven.left.isClosed = true;
		seven.right.isClosed = false;

		eight.left.val = 9;
		eight.right.val = 11;
		eight.left.isClosed = false;
		eight.right.isClosed = true;

		nine.left.val = 12;
		nine.right.val = 14;
		nine.left.isClosed = true;
		nine.right.isClosed = true;

		ten.left.val = 12;
		ten.right.val = 16;
		ten.left.isClosed = false;
		ten.right.isClosed = true;

		eleven.left.val = 13;
		eleven.right.val = 15;
		eleven.left.isClosed = false;
		eleven.right.isClosed = false;

		tweleve.left.val = 16;
		tweleve.right.val = 17;
		tweleve.left.isClosed = false;
		tweleve.right.isClosed = false;

		List<Interval> intervals = Arrays.asList(one, two, three, four, five, six, seven, eight, nine, ten, eleven, tweleve);
		List<Interval> result = unionOfInterval(intervals);

		for(int i = 0; i < result.size(); i++) {
			System.out.println(i + ": " + result.get(i).left.val + result.get(i).right.val);
		}
	}
}