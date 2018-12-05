package matvey.russkov.lecture2;

public class LinkedStack extends AbstractStack {
    private Node head;

    private class Node {
        private Object value;
        private Node next;

        public Node(Node next, Object value) {
            this.next = next;
            this.value = value;
        }
    }

    public void push(Object element) {
        size++;
        head = new Node(head, element);
    }

    public Object popS() {
        final Object value = head.value;
        head = head.next;
        return value;
    }

    public Object peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
}