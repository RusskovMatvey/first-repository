package main.matvey.russkov.lab4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        if (args.length == 2) {
            try {
                int valFlow = Integer.parseInt(args[0]);
                int count = Integer.parseInt(args[1]);
                if (count > 0 & valFlow > 0) {
                    System.out.println("Количество потоков: " + valFlow + " Число: " + count);
                    Count obj = new Count(count, valFlow);
                    Flow[] arrayOfFlow = new Flow[valFlow];

                    for (int i = 0; i < valFlow; i++) {
                        arrayOfFlow[i] = new Flow(obj, i, valFlow);
                    }

                    for (int i = 0; i < valFlow; i++) {
                        arrayOfFlow[i].start();
                    }

                    for (int i = 0; i < valFlow; i++) {
                        arrayOfFlow[i].join();
                    }


                } else {
                    System.out.println("Введите положительное число");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Введите число.");
            }
        } else {
            System.out.println("Неверное кол-во аргументов (Возможен только один аргумент)");
        }
    }
}