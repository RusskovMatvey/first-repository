package main.matvey.russkov.lab4;

public class Task {
    private int count;

    public Task(int count, int numberFlow) {
        this.count = count;
    }

    public void subtractionCount() {
        count--;
    }

    public int getCount() {
        return count;
    }

}
