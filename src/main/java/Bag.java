import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Bag {
    private List<Tile> tiles = new ArrayList<>();

    public Bag() {
        Random random = new Random();
        initTiles();
        for (char c = 'a'; c <= 'z'; c++) {
            var tile = new Tile();
            tile.setLetter(c);
            tile.setPoints(random.nextInt(10) + 1);
        }
        Collections.shuffle(tiles);
    }

    private void initTiles() {
        for (char letter = 'a'; letter < 'z'; ++letter) {
            switch (letter) {
                case 'a', 'i' -> createTiles(letter, 1, 9);
                case 'b', 'c', 'm', 'p' -> createTiles(letter, 3, 2);
                case 'd' -> createTiles(letter, 2, 4);
                case 'e' -> createTiles(letter, 1, 12);
                case 'f', 'h', 'v', 'w', 'y' -> createTiles(letter, 4, 2);
                case 'g' -> createTiles(letter, 2, 3);
                case 'j', 'x' -> createTiles(letter, 8, 1);
                case 'k' -> createTiles(letter, 5, 1);
                case 'l', 's', 'u' -> createTiles(letter, 1, 4);
                case 'n', 'r', 't' -> createTiles(letter, 1, 6);
                case 'o' -> createTiles(letter, 1, 8);
                case 'q', 'z' -> createTiles(letter, 10, 1);
            }
        }
    }

    private void createTiles(char letter, int points, int numberOfTiles) {
        for (int count = 0; count < numberOfTiles; ++count) {
            tiles.add(new Tile(letter, points));
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        Random random = new Random();
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            extracted.add(tiles.stream().toList().get(random.nextInt(tiles.size())));
        }
        return extracted;
    }

}
