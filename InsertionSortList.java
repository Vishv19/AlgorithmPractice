public class InsertionSortList {

    private static class ListNode<T> {
        ListNode<T> next;
        T data;

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> node5 = new ListNode<Integer>(5,null);
        ListNode<Integer> node4 = new ListNode<Integer>(6,node5);
        ListNode<Integer> node3 = new ListNode<Integer>(3,node4);
        ListNode<Integer> node2 = new ListNode<Integer>(8,node3);
        ListNode<Integer> node1 = new ListNode<Integer>(9,node2);
        ListNode<Integer> result = insertionSort(node1);
        System.out.println(result.data);
    }

    public static ListNode<Integer> insertionSort(final ListNode<Integer> L) {
        ListNode<Integer> dummyHead = new ListNode<>(0, L);        
        ListNode<Integer> iter = L;

        while(iter!=null && iter.next!=null) {
            //check that if the current position data is greater than the next position
            if(iter.data > iter.next.data) {
                ListNode<Integer> target = iter.next, pre = dummyHead;
                //keep moving ahead if the data is already sorted
                while(pre.next.data < target.data) {
                    pre = pre.next;
                }
                ListNode<Integer> temp = pre.next;
                pre.next = target;
                iter.next = target.next;
                target.next = temp;
            }
            else {
                iter = iter.next;
            }
        }
        return dummyHead.next;
    }

}