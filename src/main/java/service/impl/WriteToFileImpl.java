package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import model.Fruit;
import service.WriteToFile;

public class WriteToFileImpl implements WriteToFile {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void writeFromDataBase(String fileName) {
        try (FileWriter writer = new FileWriter(fileName);) {
            for (Map.Entry<Fruit, Integer> entry : fruitDao.getEntries()) {
                writer.write(entry.getKey().getFruitType() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }
}