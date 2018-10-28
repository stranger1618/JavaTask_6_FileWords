import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс WorkWithWords
 * Описывает работу со словами из файла:
 * 1. Выводит список слов в алфавитном порядке.
 * 2. Выводит статистику использованич слов в файле.
 * 3. Выводит слова, встречающиеся чаще остальных
 */

public class WorkWithWords {
    private TreeMap<String, Integer> words;

    /**
     * Конструктор без параметров
     * Создает новую пустую коллекцию.
     */


    public WorkWithWords() {
        this.words = new TreeMap<String, Integer>();
    }

    /**
     * Конструктор с заданными параметрами
     * @param words Заданная коллекция слов
     */

    public WorkWithWords(TreeMap<String, Integer> words) {
        this.words = words;
    }

    /**
     * Геттер и сеттер
     */

    public TreeMap<String, Integer> getWords() {
        return words;
    }

    public void setWords(TreeMap<String, Integer> words) {
        this.words = words;
    }

    /**
     * Метод добавления слова в коллекцию
     * @param word Слово
     */
    public void addAWord(String word) {
        TreeMap<String, Integer> words = this.getWords();

        // Получение текущего количества использования слова в файле
        Integer count = words.get(word);

        // Задание начального значения, если данное слово не было встречено в файле ранее
        if (count == null) {
            count = 0;
        }

        // Добавление слова в коллекцию
        words.put(word, ++count);

        this.setWords(words);
    }

    /**
     * Метод вывода статистики слов в файле: какое слово сколько раз встречалось
     * Выводит слова в алфавитном порядке
     */
    public void Statist() {
        TreeMap<String, Integer> words = this.getWords();

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\" was used " +
                    entry.getValue() + " times");
        }
    }

    /**
     * Метод вывода списка всех слов в файле
     * Выводит слова в алфавитном порядке
     */
    public void printWords() {
        TreeMap<String, Integer> words = this.getWords();

        for (String key : words.keySet()) {
            System.out.println(key);
        }
    }

    /**
     * Метод поиска максимального значения использования слова в файле
     * @return Максимальное использование слова
     */

    public Integer mostUsed() {
        TreeMap<String, Integer> words = this.getWords();
        int maxFound = 0;

        for (Integer found : words.values()) {
            if (found > maxFound)
                maxFound = found;
        }
        return maxFound;
    }

    /**
     * Метод поиска слов, встретившихся в файле чаще всего
     *
     * @param usage Значение количества использования слова
     * @return Список слов, использованных чаще остальных
     */
    private ArrayList<String> findMostUsed(Integer usage) {
        TreeMap<String, Integer> words = this.getWords();
        ArrayList<String> foundWords = new ArrayList<String>();

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue().equals(usage))
                foundWords.add(entry.getKey());
        }
        return foundWords;
    }

    /**
     * Вывод списка слов, встретившихся в файле чаще остальных
     *
     * @param usage Значение количества использования слова
     */
    public void printMostUsed(Integer usage) {
        ArrayList<String> foundWords = this.findMostUsed(usage);

        System.out.println("This words are: ");

        for (String word : foundWords) {
            System.out.println(word);
        }
    }
}
