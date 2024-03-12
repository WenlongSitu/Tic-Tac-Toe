import java.util.ArrayList;
import java.util.Map;


// An Empty Block tile should behave as a space (does nothing and has no winning conditions).
public class Empty extends Block {
    @Override
    boolean isPlayerX() {
        return false;
    }

    @Override
    boolean isPlayerO() {
        return false;
    }

    @Override
    boolean isEmpty() {
        return true;
    }

    @Override
    boolean checkVertical(int col, Map<Integer, ArrayList<Block>> grid) {
        return false;
    }

    @Override
    boolean checkHorizontal(int row, Map<Integer, ArrayList<Block>> grid) {
        return false;
    }

    @Override
    boolean checkLeftDiagonal(Map<Integer, ArrayList<Block>> grid) {
        return false;
    }

    @Override
    boolean checkRightDiagonal(Map<Integer, ArrayList<Block>> grid) {
        return false;
    }

    @Override
    boolean checkWinCondition(Map<Integer, ArrayList<Block>> grid) {
        return false;
    }
}
