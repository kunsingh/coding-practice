import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeleteDuplicateFromUnsorted {

    public static ListNode deleteDuplicatesUnsorted(ListNode head) {


            Map<Integer, Integer> countMap = getCount(head);
            ListNode node = new ListNode();
            node.next = head;
            ListNode curr = head;
            ListNode prev = node;
            while (curr != null) {

                if (countMap.get(curr.val) > 1) {
                    prev.next = curr.next;
                } else {
                    prev = prev.next;
                }
                curr = curr.next;

            }

        return node.next;
    }

    private static Map<Integer, Integer> getCount(ListNode head) {
        Map<Integer, Integer> countMap = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            if (countMap.containsKey(curr.val)) {
                int val = countMap.get(curr.val);
                countMap.put(curr.val, val + 1);
            } else {
                countMap.put(curr.val, 1);
            }
            curr = curr.next;
        }

        return countMap;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode result = deleteDuplicatesUnsorted(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
