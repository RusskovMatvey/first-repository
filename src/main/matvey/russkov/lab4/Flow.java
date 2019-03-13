package main.matvey.russkov.lab4;

public class Flow extends Thread {
    private static int count;
    private final int number;
    private final Object monitor;
    private static int flag;
    private int valFlow;

    public Flow(int count, int number, Object monitor, int valFlow) {
        super("Flow");
        Flow.count = count;
        this.number = number;
        this.monitor = monitor;
        Flow.flag = -1;
        this.valFlow = valFlow;
    }

    public void run() {
        try {
            while (true) {
                synchronized (monitor) {
                    if (count > 0) {
                        count--;
                        System.out.println(Thread.currentThread().getName() + " " + number + " count: " + count);
                        monitor.notify();
                        if (count > 0) {
                            monitor.wait();
                        } else {
                            break;
                        }
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
