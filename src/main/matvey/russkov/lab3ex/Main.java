package main.matvey.russkov.lab3ex;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        if(args.length == 1) {
            try {
                Task task = new Task(0);
                int val = Integer.parseInt(args[0]);

                System.out.println("Количество задач: " + val);
                System.out.println("");

                Trainer trainer = new Trainer(task, val);
                Sportsman sportsman = new Sportsman(task, val);

                trainer.start();
                sportsman.start();

                trainer.join();
                sportsman.join();
            }catch (IllegalArgumentException e) {
                System.out.println("Введите число.");
            }
        } else {
            System.out.println("Неверное кол-во аргументов (Возможен только один аргумент)");
        }
    }
}
