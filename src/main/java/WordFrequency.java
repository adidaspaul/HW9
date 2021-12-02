import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;
import java.util.Map.Entry;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        new WordFrequency().Scan();
    }

    public void Scan() throws FileNotFoundException {
        Map<String, Integer> counts = new HashMap<>();
        List<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader("src/main/resources/words.txt"));
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        for (String word : words) {
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }
        Map<String, Integer> sortedCounts = sortMap(counts);
        sortedCounts.entrySet().forEach(System.out::println);

    }

    static Map<String, Integer> sortMap(Map<String, Integer> map) {
        Set<Entry<String, Integer>> entries = map.entrySet();
        Comparator<Entry<String, Integer>> compare = (e1, e2) -> (e2.getValue()).compareTo(e1.getValue());

        List<Entry<String, Integer>> enters = new ArrayList<>(entries);

        enters.sort(compare);

        Map<String, Integer> sorted = new LinkedHashMap<>(enters.size());

        for (Entry<String, Integer> entry : enters) {
            sorted.put(entry.getKey(), entry.getValue());
        }

        return sorted;
    }
}
