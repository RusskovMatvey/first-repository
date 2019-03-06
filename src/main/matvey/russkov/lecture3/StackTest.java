public class StackTest {
    public static void fill(Stack<String> stack) {
        for (int i = 0; i < 5; i++) {
            stack.push("e" + i);
        }
    }
    public static <E> void dump(Stack<E> stack) {
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.println(stack.peek() + " " + stack.pop());
        }
    }
    public static void main(String[] args) {
        {
            AbstractStack<String> stack = new LinkedStack<String>();
            fill(stack);
            dump(stack);
        }
        {
            AbstractStack<String> stack = new ArrayStack<String>(10);
            fill(stack);
            dump(stack);
        }
    }
}