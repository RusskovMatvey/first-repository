public class StackTest {
    public static void fill(Stack stack) {
        for (int i = 0; i < 5; i++) {
            stack.push("e" + i);
        }
    }
    public static void dump(Stack stack) {
        System.out.println(stack.size());
        while (stack.size() != 0) {
            System.out.println(stack.peek() + " " + stack.pop());
        }
    }
    public static void main(String[] args) {
        {
            LinkedStack stack = new LinkedStack();
            fill(stack);
            dump(stack);
        }
        {
            ArrayStack stack = new ArrayStack();
            fill(stack);
            dump(stack);
        }
    }
}