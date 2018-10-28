import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Класс Main
 * Считывание слов из файла и вывод всей информации
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Открытие файла
        Scanner myValue = new Scanner(new File("D:\\example.txt"));
        WorkWithWords Mwords = new WorkWithWords();

        while (myValue.hasNext()) {
            String word = myValue.useDelimiter("\\s+").next();
            Mwords.addAWord(word);
        }


        // Вывод списка всех слов в файле
        System.out.println("\nThe list of all words in a file:\n");
        Mwords.printWords();

        // Вывод статистики о словах в файле: слово и сколько раз оно встречается
        System.out.println("\nStatistics of the words in a file:\n");
        Mwords.Statist();

        // Поиск слов, которые были использованы максимальное количество раз
        int usage = Mwords.mostUsed();
        System.out.println("\nThe most used words were used " + usage + " times.");
        Mwords.printMostUsed(usage);
    }
}

