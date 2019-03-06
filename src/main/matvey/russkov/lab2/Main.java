package main.matvey.russkov.lab2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length == 3) {
            if ((args[0].equals("USD") | args[0].equals("EUR")) & (args[1].equals("покупка") | args[1].equals("продажа"))) {
                int RATE;
                int VAL = Integer.parseInt(args[2]);
                if (args[0].equals("USD")) {
                    RATE = 1;
                } else {
                    RATE = 2;
                }
                int count = Integer.parseInt(args[2]);
                if (count >= 1) {
                    byte COUNT = 4;
                    ArrayList<Bank> arrayOfClass = new ArrayList<>(COUNT);
                    arrayOfClass.add(new BankOne());
                    arrayOfClass.add(new BankTwo());
                    arrayOfClass.add(new BankThree());
                    arrayOfClass.add(new BankFour());
                    if (args[1].equals("покупка")) {
                        int min_index = 0;
                        double min = Double.MAX_VALUE;
                        for (int i = 0; i < 4; i++) {
                            if (min > arrayOfClass.get(i).buy(RATE, VAL)) {
                                min_index = i;
                                min = arrayOfClass.get(i).buy(RATE, VAL);
                            }
                        }
                        System.out.print("Самая выгодная покупка будет в банке: ");
                        arrayOfClass.get(min_index).whoIAm();
                        System.out.print(arrayOfClass.get(min_index).buy(RATE, VAL));


                        for (int i = 0; i < 4; i++) {
                            System.out.println("");
                            arrayOfClass.get(i).whoIAm();
                            System.out.println(arrayOfClass.get(i).buy(RATE, VAL) + " RUB");
                        }
                    } else {
                        int max_index = 0;
                        double max = Double.MIN_VALUE;
                        for (int i = 0; i < 4; i++) {
                            if (max < arrayOfClass.get(i).sell(RATE, VAL)) {
                                max_index = i;
                                max = arrayOfClass.get(i).sell(RATE, VAL);
                            }
                        }
                        System.out.print("Самая выгодная продажа будет в банке: ");
                        arrayOfClass.get(max_index).whoIAm();
                        System.out.println(arrayOfClass.get(max_index).sell(RATE, VAL));

                        for (int i = 0; i < 4; i++) {
                            System.out.println(" ");
                            arrayOfClass.get(i).whoIAm();
                            System.out.println(arrayOfClass.get(i).sell(RATE, VAL) + " RUB");
                        }
                    }
                } else {
                    System.out.println("Введите положительное число!!!");
                }
            } else {
                System.out.println("Введите корректные данные");
            }
        } else {
            System.out.println("Program supported 3 arg");
        }
    }
}
