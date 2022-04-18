import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class Board {
    private final List<String> words = new ArrayList<>();

    public synchronized void addWord(Player player, String word) {
        this.words.add(word);
        log.info("{}: {}", player.getName(), word);
    }
}
