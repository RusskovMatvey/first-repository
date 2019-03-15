package main.matvey.russkov.lab4;

public class Count {
    private int count;
    private int numberFlow;
    private int valFlow;

    public Count(int count, int numberFlow) {
        this.count = count;
        this.numberFlow = numberFlow;
        this.valFlow = numberFlow;
    }

    public void subtractionCount() {
        count--;
    }

    public int getCount() {
        return count;
    }

    public void subtractionNumberFlow() {
        if(numberFlow == 1) {
            numberFlow = valFlow;
        } else {
            numberFlow--;
        }
    }

    public int getNumberFlow() {
        return numberFlow;
    }
}
