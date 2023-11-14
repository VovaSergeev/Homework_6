import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Стартовый класс.
 */

public class Main {
    /**
     * Точка старта приложения
     *
     * @param args
     *             стартовые аргументы
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Создаем два файла для хранения комментариев и черного списка
        File file1 = new File("comments.txt");
        File file2 = new File("blacklist.txt");

        // Создаем список для хранения комментариев и набор для хранения черного списка
        List<String> comments = new ArrayList<>();
        Set<String> blacklist = new HashSet<>();

        try (Scanner in1 = new Scanner(file1)) {
            // Читаем все строки из файла comments.txt и добавляем их в список comments
            while (in1.hasNextLine()) {
                comments.add(in1.nextLine());
            }
        }
        try (Scanner in2 = new Scanner(file2)) {
            // Читаем все строки из файла blacklist.txt и добавляем их в набор blacklist
            while (in2.hasNextLine()) {
                blacklist.add(in2.nextLine());
            }
        }

        // Создаем объект Filter для фильтрации комментариев по черному списку
        Filter filter = new Filter();
        filter.filterComments(comments, blacklist);
        // Проходим по всем элементам списка comments и выводим их на экран
        int num = 1;
        for (String comment : comments) {
            System.out.println(num++ + ". " + comment);
        }
    }
}
