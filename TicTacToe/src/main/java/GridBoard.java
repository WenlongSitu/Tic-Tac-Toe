import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GridBoard {
    Map<Integer, ArrayList<Block>> grid = new HashMap<>(3);

    public boolean xTurn = true; // If Player X's turn is true Player Y's turn is false and vice versa.

    // GridBoard() default constructor initializes all tiles within the 3-by-3 grid with instances of Empty blocks (or tiles).
    public GridBoard() {
        for (int i = 0; i < 3; i++) {
            grid.put(i, new ArrayList<>(3));
            for (int j = 0; j < 3; j++) {
                grid.get(i).add(new Empty());
            }
        }
    }

    // setGridElement() sets a specific tile given its row and col to the Block object that is passed in.
    // Returns true if the tile at row and col position is not empty and false otherwise. Reverse xTurn if
    // setter is successful.
    public boolean setGridElement(int row, int col, Block block) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }
        if (!grid.get(row).get(col).isEmpty()) {
            return false;
        }
        grid.get(row).set(col, block);
        xTurn = !xTurn;
        return true;
    }

    // isFull() returns true if this GridBoard is full and false otherwise.
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.get(i).get(j).isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
