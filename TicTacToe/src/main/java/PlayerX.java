import java.util.ArrayList;
import java.util.Map;

public class PlayerX extends Block{

    @Override
    boolean isPlayerX() {
        return true;
    }

    @Override
    boolean isPlayerO() {
        return false;
    }

    @Override
    boolean isEmpty() {
        return false;
    }


    // checkVertical() returns true if the row given a specific column contains all PlayerX Blocks.
    @Override
    boolean checkVertical(int col, Map<Integer, ArrayList<Block>> grid) {
        for (int i = 0; i < 3; i++) {
            if (!grid.get(i).get(col).isPlayerX()) {
                return false;
            }
        }
        return true;
    }

    // checkHorizontal() returns true if the column given a specific row contains all PlayerX Blocks.
    @Override
    boolean checkHorizontal(int row, Map<Integer, ArrayList<Block>> grid) {
        for (int i = 0; i < 3; i++) {
            if (!grid.get(row).get(i).isPlayerX()) {
                return false;
            }
        }
        return true;
    }

    // checkLeftDiagonal returns true if the left diagonal of grid contains all PlayerX Blocks.
    @Override
    boolean checkLeftDiagonal(Map<Integer, ArrayList<Block>> grid) {
        for (int i = 0; i < 3; i++) {
            if (!grid.get(i).get(i).isPlayerX()) {
                return false;
            }
        }
        return true;
    }

    // checkRightDiagonal returns true if the right diagonal of grid contains all PlayerX Blocks.
    @Override
    boolean checkRightDiagonal(Map<Integer, ArrayList<Block>> grid) {
        int col = 2;
        for (int i = 0; i < 3; i++) {
            if (!grid.get(col--).get(i).isPlayerX()) {
                return false;
            }
        }
        return true;
    }

    // checkWinCondition returns true if PlayerX has won the game displayed by grid.
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
