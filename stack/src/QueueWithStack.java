import java.util.ArrayDeque;
import java.util.Deque;

public class QueueWithStack {
    int front;

    Deque<Integer> s1 = new ArrayDeque<Integer>();
    Deque<Integer> s2 = new ArrayDeque<Integer>();

    public QueueWithStack() {
    }

    public void push(int x) {
        if (s1.size() == 0)
            front = x;
        while (s1.size() != 0)
            s2.addFirst(s1.removeFirst());
        s2.addFirst(x);
        while (s2.size() != 0) {
            s1.addFirst(s2.removeFirst());
        }
    }

    public int pop() {
        int pop = s1.removeFirst();

        if (s1.size() != 0)
            front = s1.getFirst();

        return pop;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return (s1.size() == 0);
    }
}
