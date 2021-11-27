import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws FileNotFoundException {
        new WordFrequency().Scan();
    }

    public void Scan() throws FileNotFoundException {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        List<String> keys = new ArrayList<>();
        List<String> words = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader("src/main/resources/words.txt"));
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        for (String word : words) {
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }
        keys.addAll(counts.keySet());
        for(String key : keys){
            System.out.println(key + " " + counts.get(key));
        }
    }
}
