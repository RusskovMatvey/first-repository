public class ArrayStack<E> extends AbstractStack<E> implements Stack<E> {
    private E[] elements = (E[]) new Object[0];

    public ArrayStack(int capacity) {
        elements = (E[]) (new Object[capacity]);
    }

    public void push(E value) {
        ensureCapacity(size+1);
        elements[size] = value;
        size++;
    }

    public void ensureCapacity(int capacity) {
        if (elements.length >= capacity) {
            return;
        }
        E[] newElements = (E[]) new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public E popS() {
        size++;
        elements[size] = null;
        size--;
        return elements[size];
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        return elements[size-1];
    }
}
