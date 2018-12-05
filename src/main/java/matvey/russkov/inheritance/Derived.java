package matvey.russkov.lecture3;

import java.util.Arrays;
import java.util.List;

public class Derived extends Base {

    private String derivedField;

    public Derived() {
        this("Greetings");
        System.out.println("Called Derived default constructor");
    }

    public Derived(String derivedField) {
        super(""); // It will bw done anyway
        System.out.println("Called Derived constructor");
        this.derivedField = derivedField;
    }

    @Override
    void abstractBaseMethod() {
        super.abstractBaseMethod();
        System.out.println("Called Derived method");
    }

    public static void main(String[] args) {
        List<Base> baseList = Arrays.asList(new Base(), new Derived(), new Derived(), new Base(), new Derived());
        for (Base base : baseList) {
            System.out.println(" === ");
            base.abstractBaseMethod();
        }
    }
}
