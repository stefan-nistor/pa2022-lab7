import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Slf4j
public class Dictionary {

    private Set<String> wordList = new HashSet<>();

    public Dictionary() {
        File file = new File("src/main/resources/dictionary.txt");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                var word = scanner.next();
                wordList.add(word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        }
    }

    public boolean isWord(String word){
        return wordList.contains(word);
    }
}
