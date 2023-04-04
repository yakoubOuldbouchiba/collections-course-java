import com.ouldbouchiba.collections.Guest;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeCollection {
    public static void main(String[] args) {
        Deque<String> messageStack = new ArrayDeque<>();
        messageStack.push("Message 1");
        messageStack.push("Message 2");
        print(messageStack);
        messageStack.push("Message 3");
        messageStack.push("Message 4");
        messageStack.push("Message 5");
        print(messageStack);
        System.out.println(messageStack.pop());
        print(messageStack);
    }

    public static void print(Deque<String> deque){
        System.out.format("%n-- Deque Contents --%n");
        int x=0;
        for (String msg: deque) {
            System.out.format("%x: %s %s %n", x++ , msg, x==1 ? "(Top)":"");
        }
    }
}
