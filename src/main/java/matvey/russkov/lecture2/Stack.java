package matvey.russkov.lecture2;

public interface Stack {
    void push(Object o);
    Object pop();
    Object peek();
    int size();
    default boolean isEmpty() {
        return size() == 0;
    }
}