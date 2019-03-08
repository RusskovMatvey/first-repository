package main.matvey.russkov.lab3;

public class Trainer extends Thread {
    private final int valTasks;
    Object monitor;

    public Trainer(Object monitor, int valTasks) {
        super("Trainer");
        this.monitor = monitor;
        this.valTasks = valTasks;
    }

    public void run() {
        for (int i = 1; i <= valTasks; i++) {
            synchronized (monitor) {
                System.out.println(Thread.currentThread().getName() + " Задача " + i);
                monitor.notify();

                try {
                    if (i < valTasks) {
                        monitor.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
