package main.matvey.russkov.lab4;

import main.matvey.russkov.lab5.GUI;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        if (args.length == 2) {
            try {
                int valFlow = Integer.parseInt(args[0]);
                int count = Integer.parseInt(args[1]);

                if (count > 0 & valFlow > 0) {
                    //System.out.println("Количество потоков: " + valFlow + " Число: " + count);
                    GUI.textArea.append("Количество потоков: " + valFlow + " Число: " + count + "\n");

                    Task task = new Task(count, valFlow);
                    Flow[] arrayOfFlow = new Flow[valFlow];

                    for (int i = 0; i < valFlow; i++) {
                        arrayOfFlow[i] = new Flow(i==0?null:arrayOfFlow[i-1],task, i);
                    }
                    arrayOfFlow[0].setWait(arrayOfFlow[valFlow - 1]);

                    for (int i = valFlow-1; i >= 0; i--) {
                        arrayOfFlow[i].start();
                    }


                } else {
                    //System.out.println("Введите положительное число");
                    GUI.textArea.append("Введите положительное число\n");
                }
            } catch (IllegalArgumentException e) {
                //System.out.println("Введите число.");
                GUI.textArea.append("Введите число.\n");
            }
        } else {
            //System.out.println("Неверное кол-во аргументов (Возможен только один аргумент)");
            GUI.textArea.append("Неверное кол-во аргументов (Возможен только один аргумент)\n");
        }
    }
}