package Stack_queues;

public class QueueImplementation {
    public class Queue{
        int[] arr;
        int size ;
        int rear =-1; //rear and front are initially -1, front is always 0;

        Queue(int n){
            arr= new int[n];
            this.size= n;
        }
        public boolean isEmpty(){
            return  rear ==-1;
        }
        //enqueue o(1)
        public void add(int data){
            if (rear== size-1){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear]= data;

        }
        //dequeue o(n) // because all elemnets have to be shifted from left to right
        public int remove(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            int front = arr[0];
            for(int i=0; i< rear; i++){
                arr[i]= arr[i+1];
            }
            rear--;
            return front;

        }
        //peek o(n)
        public int peek(){
            if (isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];
        }

    }

    public static void main(String[] args) {

    }

}
