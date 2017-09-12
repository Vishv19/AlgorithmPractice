import java.util.*;

public class BuildBSTFromSortedArray {
    
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

    public static BSTNode<Integer> buildMinHeightBSTFromSortedArray(List<Integer> A) {
        return buildMinHeightBSTFromSortedArrayHelper(A, 0, A.size());
    }

    public static BSTNode<Integer> buildMinHeightBSTFromSortedArrayHelper(List<Integer> A, int start, int end) {
        if(start == end) {
            return null;
        }

        int mid = start +(end-start)/2;
        return new BSTNode<>(A.get(mid), buildMinHeightBSTFromSortedArrayHelper(A, start, mid),
            buildMinHeightBSTFromSortedArrayHelper(A, mid+1, end));
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1,2,3,4,5,6,7,8);
        BSTNode<Integer> root = buildMinHeightBSTFromSortedArray(A);
        // levelOrderBFS(root);
        printLevelOrder(root);
    }

    public static void levelOrderBFS(BSTNode<Integer> b) {
        Queue<BSTNode> q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        q.add(b);

        // System.out.println(b);
        while(!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> sublist = new LinkedList<Integer>();
            // System.out.println(q.peek().data);
            for(int i = 0; i < levelNum; i++) {
                BSTNode<Integer> n = q.remove();
                if(n.left!=null) {
                    q.add(n.left);
                    sublist.add(n.left.data);
                    System.out.println(n.left.data);
                }
                if(n.right!=null) {
                    q.add(n.right);
                    sublist.add(n.right.data);
                    System.out.println(n.right.data);
                }                
            }
            result.add(sublist);
        }
        System.out.println(result);
    }

    public static void printLevelOrder(BSTNode<Integer> root)
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    public static int height(BSTNode<Integer> root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
    }
 
    /* Print nodes at the given level */
    public static void printGivenLevel (BSTNode<Integer> root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }    
}