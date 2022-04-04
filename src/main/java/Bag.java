import lombok.*;

import java.util.*;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Bag {
    private Collection<Tile> tiles = new ArrayList<>();

    public Bag() {
        Random random = new Random();
        for(char c = 'a'; c <= 'z'; c++){
            var tile = new Tile();
            tile.setLetter(c);
            tile.setPoints(random.nextInt(10) + 1);
        }
    }

    public synchronized List<Tile> extractTiles (int howMany) {
        Random random = new Random();
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if(tiles.isEmpty()) {
                break;
            }
            extracted.add(tiles.stream().toList().get(random.nextInt(tiles.size())));
        }
        return extracted;
    }

}
