import java.util.*;

public class EvenOddMerge {
	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(2, null);
		ListNode<Integer> second = new ListNode<Integer>(3, null);
		ListNode<Integer> third = new ListNode<Integer>(4, null);
		ListNode<Integer> fourth = new ListNode<Integer>(5, null);
		ListNode<Integer> fifth = new ListNode<Integer>(6, null);
		ListNode<Integer> sixth = new ListNode<Integer>(7, null);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;

		ListNode<Integer> newhead = evenOddMerge(head);
		// for(ListNode<Integer> i = newhead; i!=null; i=i.next) {
		// 	System.out.println(i.data);
		// }
	}

	static class ListNode<T> {
		public T data;
		public ListNode<T> next;

		ListNode(T d, ListNode<T> n) {
			this.data = d;
			this.next = next;
		}
	}

	public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
		if(L == null) {
			return L;
		}

		ListNode<Integer> evenNode = new ListNode<>(0, null);
		ListNode<Integer> oddNode = new ListNode<>(0, null);

		int turn = 0;
		List<ListNode<Integer>> tails = Arrays.asList(evenNode, oddNode);
		for(ListNode<Integer> i = L; i!=null; i=i.next) {
			tails.get(turn).next = i; //set evenNode's next pointer which is actually first useful node to iter.
			System.out.println(tails.get(turn).next.data);
			tails.set(turn, tails.get(turn).next); // set evenNode's first value to actually something useful.
			System.out.println(tails.get(turn).data);
			turn ^= 1;
		}
		tails.get(1).next = null;
		tails.get(0).next = oddNode.next;
		return evenNode.next;
	}

}