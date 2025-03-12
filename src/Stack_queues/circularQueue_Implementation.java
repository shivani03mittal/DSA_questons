package Stack_queues;

public class circularQueue_Implementation {
    //using array
    static class Queue{
        static int arr[];
        static int size;
        static int rear=-1;
        static int front =-1;
        
        Queue(int n){
            size=n;
            arr= new int[n];

        }

        public static boolean isEmty(){
            return rear==-1 && front==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size ==  front;
        }

        //enqueue
        public static void add(int data){

            if (isFull()){
                System.out.println("queue is full");
                return;
            }
            //if first element
            if(front==-1 )
            front=0;
            rear= (rear+1)% size;
            arr[rear]= data;
        }

        //dequeue o(1)
        public static int remove(){
            if (isEmty()){
                return -1;
            }
            int top = arr[front];
            // if single ele rear= front =0
            if(rear==front){
                rear=front=-1;

            }
            else {
                front= (front+1)%size;
            }
            return top;
        }

        public static int peek(){
            if(isEmty()) return -1;
            int top =arr[front];
            return top;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();

    }
}
