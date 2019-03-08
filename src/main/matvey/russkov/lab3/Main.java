package main.matvey.russkov.lab3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        if(args.length == 1) {
            try {
                Object monitor = new Object();
                int val = Integer.parseInt(args[0]);
                Trainer trainer = new Trainer(monitor, val);
                Sportsman sportsman = new Sportsman(monitor, val);

                trainer.start();
                sportsman.start();

                trainer.join();
                sportsman.join();
            }catch (Exception e) {
                System.out.println("Введите число.");
            }
        } else {
            System.out.println("Неверное кол-во аргументов (Возможен только один аргумент)");
        }
    }
}
