package main.matvey.russkov.lab2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length == 3) {
            if ((args[0].equals("USD") | args[0].equals("EUR")) & (args[1].equals("покупка") | args[1].equals("продажа"))) {
                int rate;
                int val = 0;
                try {
                    val = Integer.parseInt(args[2]);
                    if (args[0].equals("USD")) {
                        rate = 1;
                    } else {
                        rate = 2;
                    }
                    if (val >= 1) {
                        byte COUNT = 4;
                        ArrayList<Bank> arrayOfClass = new ArrayList<>(COUNT);
                        arrayOfClass.add(new BankOne());
                        arrayOfClass.add(new BankTwo());
                        arrayOfClass.add(new BankThree());
                        arrayOfClass.add(new BankFour());
                        if (args[1].equals("покупка")) {
                            int min_index = 0;
                            double min = Double.MAX_VALUE;
                            for (int i = 0; i < arrayOfClass.size(); i++) {
                                if (min > arrayOfClass.get(i).buy(rate, val)) {
                                    min_index = i;
                                    min = arrayOfClass.get(i).buy(rate, val);
                                }
                            }
                            System.out.print("Самая выгодная покупка будет в банке: ");
                            arrayOfClass.get(min_index).whoIAm();
                            System.out.println(arrayOfClass.get(min_index).buy(rate, val));
                            arrayOfClass.remove(min_index);
                            System.out.println("-------------------------------------");


                            for (Bank arrayOfClass1 : arrayOfClass) {
                                System.out.println("");
                                arrayOfClass1.whoIAm();
                                System.out.println(arrayOfClass1.buy(rate, val) + " RUB");
                            }
                        } else {
                            int max_index = 0;
                            double max = Double.MIN_VALUE;
                            for (int i = 0; i < arrayOfClass.size(); i++) {
                                if (max < arrayOfClass.get(i).sell(rate, val)) {
                                    max_index = i;
                                    max = arrayOfClass.get(i).sell(rate, val);
                                }
                            }
                            System.out.print("Самая выгодная продажа будет в банке: ");
                            arrayOfClass.get(max_index).whoIAm();
                            System.out.println(arrayOfClass.get(max_index).sell(rate, val));
                            arrayOfClass.remove(max_index);

                            for (Bank arrayOfClass1 : arrayOfClass) {
                                System.out.println(" ");
                                arrayOfClass1.whoIAm();
                                System.out.println(arrayOfClass1.sell(rate, val) + " RUB");
                            }
                        }
                    } else {
                        System.out.println("Введите положительное число!!!");
                    }
                } catch (Exception e) {
                    System.out.println("Введите корректные данные (3-ий аргумент)");
                }
            } else {
                System.out.println("Введите корректные данные");
            }
        } else {
            System.out.println("Program supported 3 arg");
        }
    }
}
