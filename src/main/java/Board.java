import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class Board {
    private Collection<String> words = new ArrayList<>();
    public synchronized void addWord(Player player, String word){
        this.words.add(word);
        log.info("{}: {}", player.getName(), word);
    }
}
