import java.io.*;
import java.util.*;
public class HeapSortIterations <T extends Comparable<? super T>> {
    int count = 0; // переменная для подсчета итераций
    public static void main(String[] args) {
        String fileName = "random_numbers.txt";
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
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
        HeapSortIterations<Integer> sort = new HeapSortIterations<>();
        sort.heapSort(array);
        System.out.print("Sorted array is: ");
        printArray(array);
        System.out.println("Number of iterations is: " + sort.count); // вывод количества итераций
    }
    private static <T> void printArray(T[] array) {
        System.out.println(java.util.Arrays.toString(array));
    }
    void heapSort(T[] array) {
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }
    void heapify(T[] array, int size, int i) {
        int max   = i;
        int left  = 2 * i + 1;
        int right = 2 * i + 2;
        count++; // увеличиваем счетчик итераций
        if (left < size && array[left].compareTo(array[max]) > 0) {
            max = left;
        }
        count++; // увеличиваем счетчик итераций
        if (right < size && array[right].compareTo(array[max]) > 0) {
            max = right;
        }
        count++; // увеличиваем счетчик итераций
        if (max != i) {
            T temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            heapify(array, size, max);
        }
        count++; // увеличиваем счетчик итераций
    }
}