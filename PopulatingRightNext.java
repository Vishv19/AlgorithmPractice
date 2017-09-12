public class PopulatingRightNext {
    public static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode<T> left, right;
        public BinaryTreeNode<T> next;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static void constructRightSibling(BinaryTreeNode<Integer> tree) {
        BinaryTreeNode<Integer> leftStart = tree;
        while(leftStart !=null || leftStart.left!=null) {
            populateNextLevelField(leftStart);
            leftStart = leftStart.left;
        }
    }

    public static void populateNextLevelField(BinaryTreeNode<Integer> startNode) {
        BinaryTreeNode<Integer> iter = startNode;
        while(iter!=null) {
            //set the right next sibling of left child
            iter.left.next = iter.right;
            if(iter.next!=null) {
                iter.right.next = iter.next.left;
            }
            iter = iter.next;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
        root.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(7);
        root.left.left = new BinaryTreeNode<>(1);
        root.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(4);
        root.right.right = new BinaryTreeNode<>(6);
        constructRightSibling(root);
        System.out.println(root.left.next.data); 
        System.out.println(root.right.data);
    }
}