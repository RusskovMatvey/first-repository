package matvey.russkov.lecture3;

public class Base {
    public Base() {
        System.out.println("Called Base default constructor");
    }

    public Base(String s) {
        this();
        System.out.println("Called Base constructor");
    }

    void abstractBaseMethod() {
        System.out.println("Called Base method");
    }
}
