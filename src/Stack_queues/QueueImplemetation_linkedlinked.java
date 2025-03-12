package Stack_queues;

public class QueueImplemetation_linkedlinked {
    //usinng linked list
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
            next= null;
        }

        Node head= null;
        Node tail = null;

        public boolean isEmpty(){
            return head==null && tail== null;
        }

        public void add(int x){
            Node nn = new Node(x);
            if(isEmpty()){
                head= nn;
                tail=nn;
                return;
            }
            tail.next= nn;
            tail= nn;
        }
        public int remove(){
            if(isEmpty()) return -1;
            int result = head.data;
            // single ele
            if(head== tail)
            {
                tail= null;
            }
            head= head.next;
            return result;
        }
    }
    public static void main(String[] args) {

    }
}
