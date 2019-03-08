package main.matvey.russkov.lab3ex;

public class Sportsman extends Thread {
    private final int valTasks;
    private final Task task;

    Sportsman(Task monitor, int valTasks) {
        super("Sportsman");
        this.task = monitor;
        this.valTasks = valTasks;
    }

    public void run() {
        try {
            while (true) {
                synchronized (task) {
                    System.out.println(Thread.currentThread().getName() + " Задача " + task.getCount());
                    task.notify();

                    if (task.getCount() < valTasks) {
                        task.wait();
                    } else {
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
