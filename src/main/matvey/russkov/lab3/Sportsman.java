package main.matvey.russkov.lab3;

public class Sportsman extends Thread {
    private final int valTasks;
    Object monitor;

    public Sportsman(Object monitor, int valTasks) {
        super("Sportsman");
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
