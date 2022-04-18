import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

@Data
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running;

    private final int BASIC_NUM_OF_TILES = 7;

    public Player(String name) {
        this.name = name;
    }

    private boolean submitWord() throws InterruptedException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        System.out.println(extracted);

        Collections.shuffle(extracted);
        String word = createWord(extracted);

        game.getBoard().addWord(this, word);
        Thread.sleep(50);
        return true;
    }

    private String createWord(List<Tile> extracted) {
        StringBuilder builder = new StringBuilder(extracted.size());
        for (Tile ch : extracted) {
            builder.append(ch.getLetter());
        }
        return builder.toString();
    }

    @Override
    public void run() {
        setGame(game);

        try {
            while (submitWord()) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
