import java.util.PriorityQueue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null;

        if(lists != null && lists.length > 0){
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            for(int i=0;i<lists.length;i++){
                while (lists[i] != null){
                    priorityQueue.add(lists[i].val);
                    lists[i] = lists[i].next;
                }
            }
            ListNode curr = null;
            while (!priorityQueue.isEmpty()){
                ListNode node = new ListNode(priorityQueue.poll());
                if(head == null){
                    head = node;
                    curr = head;
                }else{
                    curr.next = node;
                    curr = node;
                }
            }
        }

        return head;

    }
}
