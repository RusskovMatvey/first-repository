package main.matvey.russkov.lab1;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                int amount = Integer.parseInt(args[0]);
                int number = Integer.parseInt(args[1]);
                if (amount != 0) {
                    if (number >= 1 & number <= 12) {

                        final int RIGHT_BORDER = 12;
                        Random random = new Random();
                        ArrayList<Integer> arrayOfMonth = new ArrayList<>(amount);
                        for (int i = 0; i < amount; i++) {
                            arrayOfMonth.add(random.nextInt(RIGHT_BORDER) + 1);
                        }

                        System.out.println("Количество студентов: " + amount + ", Номер месяца рождения: " + number);
                        System.out.println("");

                        RandomName randomName = new RandomName(amount);
                        ArrayList<String> arrayOfSecondName = randomName.getArrayOfRandomSecondName();
                        System.out.println("Список студентов:");
                        int count = 0;
                        for (int i = 0; i < arrayOfSecondName.size(); i++) {
                            System.out.println(arrayOfSecondName.get(i) + " " + arrayOfMonth.get(i));
                            if (number == arrayOfMonth.get(i)) {
                                count++;
                            }
                        }
                        System.out.println();

                        if (count > 0) {
                            System.out.println("Список студентов с номером месяца " + number + ":");
                            for (int i = 0; i < arrayOfSecondName.size(); i++) {
                                if (number == arrayOfMonth.get(i)) {
                                    System.out.println(arrayOfSecondName.get(i) + " " + number);
                                }
                            }
                        } else {
                            System.out.println("Студентов с номером месаца " + number + " нет.");
                        }
                    } else {
                        System.out.println("Второй параметр должен быть от 1 до 12!!!");
                    }
                } else {
                    System.out.println("Список пуст!!!");
                }
            } catch (Exception ex) {
                System.out.println("Введите положительные целочисленные значения!!!");
            }
        } else {
            System.out.println("Программа поддерживает только 2 аргумента.");
        }
    }
}
