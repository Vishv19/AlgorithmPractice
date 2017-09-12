import java.util.*;

public class SubtractList {
    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
        ListNode(int x, ListNode next) { val = x; this.next = next; }
    }

    public static ListNode subtract(ListNode a) {
        ListNode head = a;
        ListNode slow = a, fast = a, prev = a;
        
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow. next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode middle = slow;
        ListNode newMiddle = reverseLinkedList(slow);
        middle = newMiddle;
        //System.out.println(newMiddle.val);
        while(newMiddle!=null && head!=null) {
            head.val = newMiddle.val - head.val;
            head = head.next;
            newMiddle = newMiddle.next;
        }
        ListNode originalMiddle = reverseLinkedList(middle);
        prev.next = originalMiddle;
        // while(a!=null) {
        //     //System.out.println(a.val);
        //     a = a.next;
        // }
        return a;
    }
    
    public static ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        head.next = null;
        while(p1!=null && p2!=null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1=p2;
            p2 = t;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode result = subtract(node1);
    } 
}