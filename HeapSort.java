import java.io.*;
import java.util.*;
public class HeapSort<T extends Comparable<? super T>> {
    // Управляющая программа
    public static void main(String[] args) {
        String fileName = "random_numbers.txt";
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.valueOf(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error");
        }
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        List<Integer> genericList = Arrays.asList(array);
        System.out.print("Unsorted array is: ");
        System.out.println(genericList);

        long startTime = System.nanoTime();
        HeapSort<Integer> sort = new HeapSort<>();
        sort.heapSort(array);
        System.out.print("Sorted array is: ");
        long endTime = System.nanoTime();
        printArray(array);
        System.out.print("Sorted time is: " + (endTime - startTime)/1e6);
    }
    // Вспомогательная функция для вывода на экран массива
    private static <T> void printArray(T[] array) {
        System.out.println(java.util.Arrays.toString(array));
    }
    void heapSort(T[] array) {
        int size = array.length;
        // Построить heapSort (перестроить массив)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }
        // Извлечь один за другим элемент из heapSort
        for (int i = size - 1; i >= 0; i--) {
            // Переместить текущий корень в конец
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // Вызвать максимальное heapify для уменьшенной выборки
            heapify(array, i, 0);
        }
    }
    // Создать поддерево с корнем в узле i, которое является индексом в array[]
    void heapify(T[] array, int size, int i) {
        // инициализируем максимум как корень
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // Если левый потомок больше, чем корень
        if (left < size && array[left].compareTo(array[max]) > 0) {
            max = left;
        }
        // Если правый потомок больше, чем максимальный
        if (right < size && array[right].compareTo(array[max]) > 0) {
            max = right;
        }
        // Если максимум не является корнем
        if (max != i) {
            // Поменять элементы местами
            T temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            // Рекурсивно нагромождать затронутое поддерево
            heapify(array, size, max);
        }
    }
}