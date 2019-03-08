package main.matvey.russkov.lab3ex;

class Task {
    private static int count;

    Task(int count) {
        Task.count = count;
    }

    int getCount() {
        return count;
    }

    void incrementCount() {
        count++;
    }

}
