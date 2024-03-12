import java.util.ArrayList;
import java.util.Map;


// Abstract Block class represents each tile using template pattern.
// Represents the base superclass of a tile that can behave differently through polymorphism and inheritance.
public abstract class Block {
    abstract boolean isPlayerX();
    abstract boolean isPlayerO();
    abstract boolean isEmpty();

    abstract boolean checkVertical(int col, Map<Integer, ArrayList<Block>> grid);
    abstract boolean checkHorizontal(int row, Map<Integer, ArrayList<Block>> grid);
    abstract boolean checkLeftDiagonal(Map<Integer, ArrayList<Block>> grid);
    abstract boolean checkRightDiagonal(Map<Integer, ArrayList<Block>> grid);
    abstract boolean checkWinCondition(Map<Integer, ArrayList<Block>> grid);
}
