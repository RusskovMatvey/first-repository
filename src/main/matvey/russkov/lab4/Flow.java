package main.matvey.russkov.lab4;

public class Flow extends Thread {
    private final Count count;
    private final int number;
    private int valFlow;

    public Flow(Count count, int number, int valFlow) {
        super("Flow");
        this.count = count;
        this.number = number;
        this.valFlow = valFlow;

    }

    public void run() {
        try {
            while (true) {
                synchronized (count) {
                    if (valFlow - count.getNumberFlow() == number) {
                        count.subtractionNumberFlow();
                        if (count.getCount() > 0) {

                            count.subtractionCount();
                            System.out.println(Thread.currentThread().getName() + " " + number + " count: " + count.getCount());

                            count.notifyAll();
                            if (count.getCount() > 0) {
                                count.wait();
                            } else {
                                break;
                            }
                        } else {
                            count.notifyAll();
                            break;
                        }
                    } else {
                        count.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
