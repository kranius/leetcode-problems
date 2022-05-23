import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithQueue {

    private Queue<Integer> q = new LinkedList<>();

    public MyStackWithQueue() {

    }

    public void push(int x) {
        // insert at the end
        q.offer(x);

        // reverse the queue
        for (int i = q.size(); 1 < i; i--) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
