package main.matvey.russkov.lab3ex;

import main.matvey.russkov.lab5.GUI;

public class Trainer extends Thread {
    private final int valTasks;
    private final Task task;

    Trainer(Task task, int valTasks) {
        super("Trainer");
        this.task = task;
        this.valTasks = valTasks;
    }

    public void run() {
        try {
            while (true) {
                synchronized (task) {
                    task.incrementCount();
                    //System.out.println(Thread.currentThread().getName() + " Задача " + task.getCount());
                    GUI.textArea.append(Thread.currentThread().getName() + " Задача " + task.getCount() + "\n");
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
