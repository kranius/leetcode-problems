
class MinStack {
    private Minimum head;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null)
            head = new Minimum(val, val, null);
        else
            head = new Minimum(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private static class Minimum {
        private int val;
        private int min;
        private Minimum next;

        public Minimum(int val, int min, Minimum next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

