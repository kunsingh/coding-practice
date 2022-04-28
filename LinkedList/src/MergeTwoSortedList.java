/**
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 != null){
            return l2;
        }
        if(l2 == null && l1 != null){
            return l1;
        }
        if(l1 != null && l2 != null){

            ListNode curr = new ListNode(-1);;
            ListNode head = curr;

            while(l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            if(l2 == null){
                while(l1 != null){
                    curr.next = new ListNode(l1.val);;
                    curr = curr.next;
                    l1 = l1.next;
                }
            }
            if(l1 == null){
                while(l2 != null){
                    curr.next =new ListNode(l2.val);;
                    curr = curr.next;
                    l2 = l2.next;
                }
            }

            return head.next;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
//        ListNode node6 = new ListNode(4);
        
        node1.next=node2;
        node2.next=node3;

        node4.next=node5;
//        node5.next=node6;
        
        ListNode newNode = mergeTwoLists(node1,null);
        while (newNode!=null){
            System.out.print(newNode.val +" ");
            newNode=newNode.next;
        }
    }
}
