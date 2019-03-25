package main.matvey.russkov.lab4;

import main.matvey.russkov.lab5.GUI;

import java.util.ArrayList;

public class Flow extends Thread {
    private Object wait;
    private Task task;
    private final int number;
    private final int count;

    Flow(Object wait, Task task, int number) {
        super("Flow");
        this.wait = wait;
        this.task = task;
        this.number = number;
        this.count = task.getCount();
    }

    ArrayList<Integer> a = new ArrayList<>();
    void setWait(Object wait) {
        this.wait = wait;
    }

    public void run() {
        ArrayList<Integer> a = new ArrayList<>();
        try {
            for (int i = 0; i < count; ++i) {

                if (!(number == 0 && i == 0))
                    synchronized (wait) {
                        wait.wait();
                    }

                synchronized (this) {
                    if (task.getCount() > 0) {

                        task.subtractionCount();
                        //System.out.println(Thread.currentThread().getName() + " " + number + " count: " + task.getCount());
                        GUI.textArea.append(Thread.currentThread().getName() + " " + number + " count: " + task.getCount() + "\n");

                        this.notify();
                    } else {
                        this.notify();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
