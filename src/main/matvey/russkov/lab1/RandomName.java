package main.matvey.russkov.lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomName {
    private List<String> dataBase;
    private final int count;

    RandomName(int count) {
        this.dataBase = new ArrayList<>();
        this.count = count;

        try {
            File file = new File("E:\\Poly\\src\\com\\company\\SecondName.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {
                dataBase.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<String> getArrayOfRandomSecondName() {
        Random random = new Random();
        ArrayList<String> SecondName = new ArrayList<>(this.count);
        for (int i = 0; i < count; i++) {
            SecondName.add(dataBase.get(random.nextInt(dataBase.size())));
        }
        return SecondName;
    }
}
