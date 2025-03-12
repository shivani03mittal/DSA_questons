package Stack_queues;

import java.util.ArrayList;

public class Stack_Implementation {

//using linked list
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data= data;
            next= null;
        }
    }

    static class Stack{
        static public Node head;

        public static boolean isEmpty(){
            return head==null;
        }

        //push insert at headd
        public static void push(int data){
            Node nn = new Node(data);
            //if null
            if(isEmpty()){
              head= nn;
              return;
            }
            //if head exists
            nn.next= head;
            head= nn;
        }
        //pop

        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head= head.next;
            return top;
        }
        //peek
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }


    // usimg arraylist

    class StackClass{
        ArrayList<Integer> all = new ArrayList<>();
        public  boolean isEmptyStack(){
            return all.size()==0;
        }
        public void push2(int data){
            all.add(data);
        }
        public int pop2(){
            if(isEmptyStack()){
                return -1;
            }
            int top = all.get(all.size()-1);
            all.remove(all.size()-1);
            return top;
        }

        public int peek2(){
            if (isEmptyStack())
                return -1;
            int top = all.get(all.size()-1);
            return top;
        }


    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
