package Stack_queues;
import java.util.*;


public class pushatBottom_stack {
    public static void pushBotoom(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBotoom(data,s);
        s.push(top);

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushBotoom(4, s);

        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
