public class ReverseSubList {
    public static class ListNode<T> {
        public T val;
        public ListNode next;
        ListNode(T x) { val = x; next = null; }
        ListNode(T x, ListNode next) { val = x; this.next = next; }
    }

    public static ListNode<Integer> reverseList(ListNode<Integer> L, int start, int end) {
        // always handle the base case
        if(start == end) {
            return L;
        }

        //counter to keep track of our progress till start point
        int k = 1;
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode subListHead = dummyHead;

        while(k++ < start) {
            subListHead = subListHead.next;
        }

        ListNode<Integer> subListIterator = subListHead.next;
        while(start++ < end) {
            ListNode<Integer> temp = subListIterator.next;
            subListIterator.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
            System.out.println("subListHead: " + subListHead.val);
            System.out.println("temp: " + temp.val);
            System.out.println("subListHead next: " + subListHead.next.val);
            if(subListIterator.next!=null) {
                System.out.println("subListIterator next: " + subListIterator.next.val);                
            }
        }

        return dummyHead.next;
    }

    public static void printList(ListNode<Integer> head) {
        while(head!=null) {
            System.out.println(head.val);    
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<>(5,null);
        ListNode<Integer> node4 = new ListNode<>(4,node5);
        ListNode<Integer> node3 = new ListNode<>(3,node4);
        ListNode<Integer> node2 = new ListNode<>(2,node3);
        ListNode<Integer> node1 = new ListNode<>(1,node2);

        printList(node1);
        ListNode<Integer> resultHead = reverseList(node1, 2, 5);
        System.out.println("after reversing");
        printList(resultHead);
    }
}