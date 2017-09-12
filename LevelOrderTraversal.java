import java.util.*;

public class LevelOrderTraversal {
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

    public static void levelOrderBFS(BSTNode<Integer> b) {
        Queue<BSTNode> q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        q.add(b);

        // System.out.println(b);
        while(!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> sublist = new LinkedList<Integer>();
            System.out.println(q.peek().data);
            for(int i = 0; i < levelNum; i++) {
                BSTNode<Integer> n = q.remove();
                if(n.left!=null) {
                    q.add(n.left);
                    sublist.add(n.left.data);
                }
                if(n.right!=null) {
                    q.add(n.right);
                    sublist.add(n.right.data);
                }                
            }
            result.add(sublist);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BSTNode<Integer> left = new BSTNode<Integer>(4, null, null);
        BSTNode<Integer> right = new BSTNode<Integer>(5, null, null);
        BSTNode<Integer> rootLeft = new BSTNode<Integer>(2, left, right);
        BSTNode<Integer> rootRight = new BSTNode<Integer>(3, null, null);
        BSTNode<Integer> root = new BSTNode<Integer>(1, rootLeft, rootRight);

        levelOrderBFS(root);
    }
}