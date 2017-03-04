import java.util.*;

public class RebuildBSTFromPreOrder {
    private static Integer rootIdx;

    public static void main(String[] args) {
        List<Integer> preOrderSequence = Arrays.asList(43,23,37,29,31,41,47,53);
        BSTNode<Integer> tree = rebuildBSTFromPreOrder(preOrderSequence);
        System.out.println(tree.data);
        System.out.println(tree.left.data);
        System.out.println(tree.left.right.data);
        System.out.println(tree.left.right.left.data);
        System.out.println(tree.left.right.right.data);
        System.out.println(tree.left.right.left.right.data);
        // System.out.println(tree.left.right.left.right.right.data);
        System.out.println(tree.right.data);
        System.out.println(tree.right.right.data);
        assert(3 == tree.data);
        assert(2 == tree.left.data);
        assert(1 == tree.left.left.data);
        assert(5 == tree.right.data);
        assert(4 == tree.right.left.data);
        assert(6 == tree.right.right.data); 
    }

    private static class BSTNode<T> {
        T data;
        BSTNode<T> left;
        BSTNode<T> right;

        BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static BSTNode<Integer> rebuildBSTFromPreOrder(List<Integer> preOrderSequence) {
        rootIdx = 0;
        return rebuildBSFromPreorderOnValueRange(preOrderSequence, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static BSTNode<Integer> rebuildBSFromPreorderOnValueRange(List<Integer> preOrderSequence, int lowerbound, int upperbound) {
        if(rootIdx == preOrderSequence.size()) {
            return null;
        }

        Integer root = preOrderSequence.get(rootIdx);
        if(root < lowerbound || root > upperbound) {
            System.out.println("root: " + root);
            System.out.println("lowerbound: " + lowerbound);
            System.out.println("upperbound: " + upperbound);
            return null;
        }
        ++rootIdx;

        BSTNode<Integer> leftSubtree = rebuildBSFromPreorderOnValueRange(preOrderSequence, lowerbound, root);
        BSTNode<Integer> rightSubtree = rebuildBSFromPreorderOnValueRange(preOrderSequence, root, upperbound);

        return new BSTNode<>(root, leftSubtree, rightSubtree);
    }
}