package main.matvey.russkov.lab3ex;

import main.matvey.russkov.lab5.GUI;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        if(args.length == 1) {
            try {
                Task task = new Task(0);
                int val = Integer.parseInt(args[0]);

                //System.out.println("Количество задач: " + val);
                //System.out.println("");
                GUI.textArea.append("Количество задач: " + val + "\n");
                GUI.textArea.append("\n");

                Trainer trainer = new Trainer(task, val);
                Sportsman sportsman = new Sportsman(task, val);

                trainer.start();
                sportsman.start();

                trainer.join();
                sportsman.join();
            }catch (IllegalArgumentException e) {
                //System.out.println("Введите число.");
                GUI.textArea.append("Введите число.\n");
            }
        } else {
            //System.out.println("Неверное кол-во аргументов (Возможен только один аргумент)");
            GUI.textArea.append("Неверное кол-во аргументов (Возможен только один аргумент)\n");
        }
    }
}
