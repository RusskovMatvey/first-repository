package main.matvey.russkov.lab2;

import main.matvey.russkov.lab5.GUI;

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
                        arrayOfClass.add(new BankOne(66.0, 75.0,65.7,74.68));
                        arrayOfClass.add(new BankTwo(66.09, 75.08,65.31, 74.86));
                        arrayOfClass.add(new BankThree(67.0, 77.00, 64.00,75.09));
                        arrayOfClass.add(new BankFour(65.99,76.08, 65.08, 75.9));
                        if (args[1].equals("покупка")) {
                            int min_index = 0;
                            double min = Double.MAX_VALUE;
                            for (int i = 0; i < arrayOfClass.size(); i++) {
                                if (min > arrayOfClass.get(i).buy(rate, val)) {
                                    min_index = i;
                                    min = arrayOfClass.get(i).buy(rate, val);
                                }
                            }
                            //System.out.print("Самая выгодная покупка будет в банке: ");
                            GUI.textArea.append("Самая выгодная покупка будет в банке: \n");
                            arrayOfClass.get(min_index).whoIAm();
                            //System.out.println(arrayOfClass.get(min_index).buy(rate, val));
                            GUI.textArea.append(arrayOfClass.get(min_index).buy(rate, val) + "\n");
                            arrayOfClass.remove(min_index);
                            //System.out.println("-------------------------------------");
                            GUI.textArea.append("-------------------------------------\n");



                            for (Bank arrayOfClass1 : arrayOfClass) {
                                //System.out.println("");
                                GUI.textArea.append("\n");
                                arrayOfClass1.whoIAm();
                                //System.out.println(arrayOfClass1.buy(rate, val) + " RUB");
                                GUI.textArea.append(arrayOfClass1.buy(rate, val) + " RUB\n");
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
                            //System.out.print("Самая выгодная продажа будет в банке: ");
                            GUI.textArea.append("Самая выгодная продажа будет в банке: \n");

                            arrayOfClass.get(max_index).whoIAm();
                            //System.out.println(arrayOfClass.get(max_index).sell(rate, val));
                            GUI.textArea.append(arrayOfClass.get(max_index).sell(rate, val) + " RUB\n");
                            arrayOfClass.remove(max_index);

                            for (Bank arrayOfClass1 : arrayOfClass) {
                                //System.out.println(" ");
                                GUI.textArea.append("\n");
                                arrayOfClass1.whoIAm();
                                //System.out.println(arrayOfClass1.sell(rate, val) + " RUB");
                                GUI.textArea.append(arrayOfClass1.sell(rate, val) + " RUB\n");
                            }
                        }
                    } else {
                        //System.out.println("Введите положительное число!!!");
                        GUI.textArea.append("Введите положительное число!!!\n");
                    }
                } catch (Exception e) {
                    //System.out.println("Введите корректные данные (3-ий аргумент)");
                    GUI.textArea.append("Введите корректные данные (3-ий аргумент)\n");
                }
            } else {
                //System.out.println("Введите корректные данные");
                GUI.textArea.append("Введите корректные данные\n");
            }
        } else {
            //System.out.println("Program supported 3 arg");
            GUI.textArea.append("Program supported 3 arg\n");
        }
    }
}
