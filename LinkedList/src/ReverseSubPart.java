/**
 * Example
 * Input:
 * N = 6
 * list = [1, 2, 8, 9, 12, 16]
 * Output:
 * [1, 8, 2, 9, 16, 12]
 */

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }
}
public class ReverseSubPart {

    static Node reverse(Node head) {
        // Write your code here

        if(head == null){
            return null;
        }

        if(head.next == null || head.next.next == null){
            return head;
        }

        Node curr = head;
        Node prev = null;
        int count =0;

        while (curr != null){
            count = 0;
            while (count < 2){
                if(count == 0){
                    prev = curr;
                    curr = curr.next;
                    count++;
                }else{ //list = [1, 2, 8, 9, 12, 16]
                    Node temp = curr.next.next;
                    prev.next = curr.next;
                    curr.next.next = curr;
                    curr.next = temp;
                    curr = curr.next;
                    count++;
                }


            }
        }



        return head;

    }
//2, 18, 24, 3, 5, 7, 9, 6, 12
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(8);
        Node n4 = new Node(9);
        Node n5 = new Node(12);
        Node n6 = new Node(16);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Node a = reverse(n1);

        while (a !=null){
            System.out.println(a.data);
            a=a.next;
        }
    }
}
