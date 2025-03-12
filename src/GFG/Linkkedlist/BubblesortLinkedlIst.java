package GFG.Linkkedlist;

public class BubblesortLinkedlIst {
    //Bubble Sort For Linked List
//By using get higher node
     class LinkedList {

         class Node {
            int data;
            Node next;
        }
        public Node head;
        //Class constructors
        LinkedList() {
            head = null;
        }
        //insert element
        public void insert(int value) {
            //Create  node
            Node node = new Node();
            node.data = value;
            node.next = null;
            if (head == null) head = node;
            else {
                Node temp = head;
                //find last node
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = node;
            }

        }
        //Display all Linked List elements
        public void display() {
            if (head != null) {

                Node temp = head;
                while (temp != null) {
                    System.out.print("  " + temp.data);
                    temp = temp.next;
                }
            } else {
                System.out.println("Empty Linked list");
            }
        }
        //perform bubble sort in single linked list
        public void bubbleSort() {

            if (head != null) {

                Node current = null,
                        new_head = null,
                        move_node = null,
                        prev = null;

                while (head != null) {
                    prev = null;
                    current = head;
                    move_node = head;
                    while (current != null) {

                        //When current node value is grator than previous node
                        if (current.next != null && current.next.data > move_node.data) {
                            //Swap node values
                            move_node = current.next;
                            prev = current;

                        }
                        current = current.next;
                    }
                    if (move_node == head) {
                        head = (head).next;
                    }

                    if (prev != null) {
                        prev.next = move_node.next;
                    }
                    move_node.next = new_head;
                    new_head = move_node;
                }
                //make new head
                head = new_head;

            } else {
                System.out.println("Empty Linked list");
            }
        }

//        public static void main(String[] args) {
//
//            LinkedList obj = new LinkedList();
//            //insert element of linked list
//            obj.insert(7);
//            obj.insert(50);
//            obj.insert(9);
//            obj.insert(42);
//            obj.insert(5);
//            obj.insert(15);
//            System.out.print("Before sort : ");
//
//            //display all node
//            obj.display();
//
//            obj.bubbleSort();
//            System.out.print("\nAfter sort  : ");
//
//            obj.display();
//        }
    }
}
