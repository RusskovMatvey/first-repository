public class LinkedStack<E> extends AbstractStack<E> {
    private Node<E> head;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        private Node(Node<E> next, E value) {
            this.next = next;
            this.value = value;
        }
    }

    public void push(E element) {
        size++;
        head = new Node<E>(head, element);
    }

    public E popS() {
        final E value = head.value;
        head = head.next;
        return value;
    }

    public E peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }
}