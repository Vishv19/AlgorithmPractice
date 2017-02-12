import java.util.*;

public class IterativeInorderTraversal {
	public static void main(String[] args) {
		BinaryTreeNode<Integer> first = new BinaryTreeNode(1, null, null, null);
		BinaryTreeNode<Integer> second = new BinaryTreeNode(2, null, null, first);
		BinaryTreeNode<Integer> third = new BinaryTreeNode(3, null, null, first);
		first.left = second;
		first.right = third;
		BinaryTreeNode<Integer> fourth = new BinaryTreeNode(4, null, null, second);
		BinaryTreeNode<Integer> fifth = new BinaryTreeNode(5, null, null, second);
		second.left = fourth;
		second.right = fifth;
		BinaryTreeNode<Integer> sixth = new BinaryTreeNode(6, null, null, third);
		BinaryTreeNode<Integer> seventh = new BinaryTreeNode(7, null, null, third);
		third.left = sixth;
		third.right = seventh;
		inorderTraversal(first);
	}

	public static class BinaryTreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left, right, parent;

		BinaryTreeNode(T data, BinaryTreeNode<T>left, BinaryTreeNode<T>right, BinaryTreeNode<T>parent) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}

	//inorder traversal in O(1) space complexity
	public static void inorderTraversal(BinaryTreeNode<Integer> node) {
		BinaryTreeNode<Integer> prev = null, curr = node;
		BinaryTreeNode<Integer> next = null;
		ArrayList<Integer> result = new ArrayList<>();
		while(curr!=null) {
			//to check if the traversal in in the bottom direction
			if(curr.parent == prev) {
				//iterate to left untill we reach end
				if(curr.left!=null) {
					next = curr.left;
				}
				else {
					result.add(curr.data);
					next = (curr.right!=null) ? curr.right : curr.parent;
				}
			}
			else if(curr.left == prev){	// if we are going upwards
				result.add(curr.data);	//if the left subtree is covered then add root of subtree to results sequence.
				next = (curr.right!=null) ? curr.right : curr.parent;
			}
			else {
				next = curr.parent;
			}
			prev = curr;
			curr = next;
		}
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	public static void inorderTraversalWithoutParent(BinaryTreeNode<Integer>node) {
		Deque<BinaryTreeNode> s = new LinkedList<BinaryTreeNode>();
		boolean notfinished = true;
		BinaryTreeNode<Integer> current = node;
		while(notfinished) {
			if(current!=null) {
				s.addFirst(current);
				current = current.left;		
			}
			else {
				if(!s.isEmpty()) {
					current = s.removeFirst();
					System.out.println(current.data);
					current = current.right;
				}
				else {
					notfinished = false;
				}
			}
		}
	}
}