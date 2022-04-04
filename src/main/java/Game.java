import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final Dictionary dictionary = new Dictionary();
    private final List<Player> playerList = new ArrayList<>();

    public void addPlayer(Player player) {
        this.playerList.add(player);
        player.setGame(this);
    }

    public void play() {
        for (var player : playerList) {
            var thread = new Thread(player);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Player {} thread interrupted", player.getName());
            }

        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }
}
