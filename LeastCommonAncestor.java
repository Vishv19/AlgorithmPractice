import java.util.*;

public class LeastCommonAncestor {
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
		BinaryTreeNode<Integer> sixth = new BinaryTreeNode(6, null, null, fifth);
		BinaryTreeNode<Integer> seventh = new BinaryTreeNode(7, null, null, fifth);
		fifth.left = sixth;
		fifth.right = seventh;

		BinaryTreeNode<Integer> node = LCA(fourth, seventh);
		System.out.println(node.data);
	}

	public static class BinaryTreeNode<T> {
		public T data;
		public BinaryTreeNode<T> left,right,parent;

		public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right, BinaryTreeNode<T> parent) {
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}

	public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
		Set<BinaryTreeNode<Integer>> hash = new HashSet<>();

		while(node1!=null && node2!=null) {
			if(node1!=null) {
				if(!hash.add(node1)) {
					return node1;
				}
			}
			node1 = node1.parent;
			if(node2!=null) {
				if(node2!=null) {
					if(!hash.add(node2)) {
						return node2;
					}
				}
			}
			node2 = node2.parent;
		}
		throw new IllegalArgumentException("node 1 and node 2 are not in same tree");
	}
}