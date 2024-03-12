import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TicTacToe extends Application {
	GridBoard gameBoard = new GridBoard();
	int buttonWidth = 100, buttonHeight = 100;

	// All buttons except reset will use this action event handler:
	EventHandler<ActionEvent> gridButtons;
	Button one, two, three, four, five, six, seven, eight, nine, reset;

	// VBox base will be the main layout of this gui
	VBox base;

	// message will be used to display whose turn it is and who won the game.
	TextField message = new TextField();

	// A GridPane will be used to represent the 3-by-3 tiles that can be pressed.
	GridPane grid;

	// getIDRow() returns the row corresponding to the location of each tile (buttons) based on its ID.
	public int getIDRow(String id) {
		return Character.getNumericValue(id.charAt(1));
	}

	// getIDRow() returns the column corresponding to the location of each tile (buttons) based on its ID.
	public int getIDCol(String id) {
		return Character.getNumericValue(id.charAt(2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// TODO Auto-generated method stub
		primaryStage.setTitle("TicTacToe");
		// Initialize all Grid buttons
		one = new Button();
		two = new Button();
		three = new Button();
		four = new Button();
		five = new Button();
		six = new Button();
		seven = new Button();
		eight = new Button();
		nine = new Button();
		one.setMinSize(buttonHeight, buttonWidth);
		two.setMinSize(buttonHeight, buttonWidth);
		three.setMinSize(buttonHeight, buttonWidth);
		four.setMinSize(buttonHeight, buttonWidth);
		five.setMinSize(buttonHeight, buttonWidth);
		six.setMinSize(buttonHeight, buttonWidth);
		seven.setMinSize(buttonHeight, buttonWidth);
		eight.setMinSize(buttonHeight, buttonWidth);
		nine.setMinSize(buttonHeight, buttonWidth);

		//set ID corresponding to row and col for each grid button:
		one.setId("B00");
		two.setId("B01");
		three.setId("B02");
		four.setId("B10");
		five.setId("B11");
		six.setId("B12");
		seven.setId("B20");
		eight.setId("B21");
		nine.setId("B22");

		reset = new Button("Reset");
		reset.setMinWidth(300);

		message.setDisable(true);
		message.setText("Player X's Turn");
		message.setStyle("-fx-opacity: 100");
		message.setAlignment(Pos.CENTER);


		// Sets up grid in the following order:
		// [[one, two, three]
		// 	[four, five, six]
		// 	[seven, eight, nine]]
		grid = new GridPane();
		grid.add(one,0, 0);
		grid.add(two,1, 0);
		grid.add(three,2, 0);
		grid.add(four,0, 1);
		grid.add(five,1, 1);
		grid.add(six,2, 1);
		grid.add(seven,0, 2);
		grid.add(eight,1, 2);
		grid.add(nine,2, 2);

		// All buttons (grid buttons) except for reset will use this action event handler.
		// defines the main behavior of the grid gui.
		// Outputs text in message TextField notifying whose turn it is and whether the game has won or tied.
		// disables all buttons when the game has either been won or tied.
		gridButtons = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Button temp = (Button)actionEvent.getSource();
				String id = temp.getId();
				boolean gameover = false;
				if (gameBoard.xTurn) {
					Block X = new PlayerX();
					if (gameBoard.setGridElement(getIDRow(id), getIDCol(id), X)) {
						message.setText("Player O's turn");
						temp.setText("X");
						if (X.checkWinCondition(gameBoard.grid)) {
							message.setText("Player X wins!");
							gameover = true;
						}
					}
				} else {
					Block O = new PlayerO();
					if (gameBoard.setGridElement(getIDRow(id), getIDCol(id), O)) {
						message.setText("Player X's turn");
						temp.setText("O");
						if (O.checkWinCondition(gameBoard.grid)) {
							message.setText("Player O wins!");
							gameover = true;
						}
					}
				}
				if (gameBoard.isFull()) {
					gameover = true;
					message.setText("Tie! (Board is Full)");
				}
				if (gameover) {
					one.setDisable(true);
					two.setDisable(true);
					three.setDisable(true);
					four.setDisable(true);
					five.setDisable(true);
					six.setDisable(true);
					seven.setDisable(true);
					eight.setDisable(true);
					nine.setDisable(true);
				}
			}
		};

		// Set grid button handlers
		one.setOnAction(gridButtons);
		two.setOnAction(gridButtons);
		three.setOnAction(gridButtons);
		four.setOnAction(gridButtons);
		five.setOnAction(gridButtons);
		six.setOnAction(gridButtons);
		seven.setOnAction(gridButtons);
		eight.setOnAction(gridButtons);
		nine.setOnAction(gridButtons);

		// Set reset button handler:
		// Deletes the old GridBoard and create a new instance
		// for the new gameBoard so that a new game can start.
		reset.setOnAction(e -> {
			gameBoard = new GridBoard();
			message.setText("");
			one.setText("");
			two.setText("");
			three.setText("");
			four.setText("");
			five.setText("");
			six.setText("");
			seven.setText("");
			eight.setText("");
			nine.setText("");
			one.setDisable(false);
			two.setDisable(false);
			three.setDisable(false);
			four.setDisable(false);
			five.setDisable(false);
			six.setDisable(false);
			seven.setDisable(false);
			eight.setDisable(false);
			nine.setDisable(false);
		});

		base = new VBox(reset, grid, message);
		Scene scene = new Scene(base, 300,350);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
