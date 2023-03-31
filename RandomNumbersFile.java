import java.io.*;
import java.util.Random;
public class RandomNumbersFile {
    public static void main(String[] args) {
        // Имя файла и количество чисел, которые нужно записать
        String fileName = "random_numbers.txt";
        int numOfNumbers = 10000;
        // Создание объекта Random для генерации случайных чисел
        Random random = new Random();
        try {
            // Создание объекта FileWriter для записи данных в файл
            FileWriter fileWriter = new FileWriter(fileName);
            // Запись первых чисел с переносом строки
            for (int i = 0; i < numOfNumbers - 1; i++) {
                int num = random.nextInt(100000); // Случайное число от 0 до 99999
                fileWriter.write(num + "\n");
            }
            // Запись последнего числа без переноса строки
            int num = random.nextInt(100000); // Случайное число от 0 до 99999
            fileWriter.write(num + "");
            // Закрытие FileWriter
            fileWriter.close();
            System.out.println("Файл " + fileName + " успешно создан.");
        } catch (IOException ex) {
            System.out.println("Ошибка при записи в файл " + fileName);
            ex.printStackTrace();
        }
    }
}