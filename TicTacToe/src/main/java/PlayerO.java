import java.util.ArrayList;
import java.util.Map;

public class PlayerO extends Block{
    @Override
    boolean isPlayerX() {
        return false;
    }

    @Override
    boolean isPlayerO() {
        return true;
    }

    @Override
    boolean isEmpty() {
        return false;
    }


    // checkVertical() returns true if the row given a specific column contains all PlayerO Blocks.
    @Override
    boolean checkVertical(int col, Map<Integer, ArrayList<Block>> grid) {
        for (int i = 0; i < 3; i++) {
            if (!grid.get(i).get(col).isPlayerO()) {
                return false;
            }
        }
        return true;
    }

    // checkVertical() returns true if the column given a specific row contains all PlayerO Blocks.
    @Override
    boolean checkHorizontal(int row, Map<Integer, ArrayList<Block>> grid) {
        for (int i = 0; i < 3; i++) {
            if (!grid.get(row).get(i).isPlayerO()) {
                return false;
            }
        }
        return true;
    }

    // checkLeftDiagonal returns true if the left diagonal of grid contains all PlayerO Blocks.
    @Override
    boolean checkLeftDiagonal(Map<Integer, ArrayList<Block>> grid) {
        for (int i = 0; i < 3; i++) {
            if (!grid.get(i).get(i).isPlayerO()) {
                return false;
            }
        }
        return true;
    }

    // checkLeftDiagonal returns true if the right diagonal of grid contains all PlayerO Blocks.
    @Override
    boolean checkRightDiagonal(Map<Integer, ArrayList<Block>> grid) {
        int col = 2;
        for (int i = 0; i < 3; i++) {
            if (!grid.get(col--).get(i).isPlayerO()) {
                return false;
            }
        }
        return true;
    }


    // checkWinCondition returns true if PlayerO has won the game displayed by grid.
    // uses helper functions from above.
    @Override
    boolean checkWinCondition(Map<Integer, ArrayList<Block>> grid) {
        // Check all rows and columns:
        for (int i = 0; i < 3; i++) {
            if (checkHorizontal(i, grid) || checkVertical(i, grid)) {
                return true;
            }
        }
        return (checkRightDiagonal(grid) || checkLeftDiagonal(grid));
    }
}
