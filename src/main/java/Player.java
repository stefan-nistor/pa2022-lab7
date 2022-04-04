import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;

    private final int BASIC_NUM_OF_TILES = 7;

    public Player(String name) {
        this.name = name;
    }

    private boolean submitWord(){
        List<Tile> extracted = game.getBag().extractTiles(BASIC_NUM_OF_TILES);
        if(extracted.isEmpty()){
            return false;
        }

        var word = createWord(extracted);
        game.getBoard().addWord(this, word);

        try{
            Thread.sleep(50);
        } catch (InterruptedException e) {
            log.error("Player {} thread interrupted", this.getName());
        }
        return true;
    }

    private String createWord(List<Tile> extracted){
        return "testing";
    }

    @Override
    public void run() {

    }
}
