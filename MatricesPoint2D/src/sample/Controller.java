package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Controller implements EventHandler<KeyEvent> {

    @FXML
    private GridPane mainGridPane;
    @FXML
    private Label coordinate;
    private Text text;
    private Point2D textLocation;
    private int rowCount = 10;
    private int columnCount = 10;

    public void initialize() {
        initializeText();
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                StackPane stack = addStackPane();
                if (row == 0 && column == 0) {
                    stack.getChildren().add(text);
                }
                GridPane.setRowIndex(stack, row);
                GridPane.setColumnIndex(stack, column);
                mainGridPane.getChildren().add(stack);
            }
        }
        textLocation = new Point2D(0, 0);
        coordinate.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
    }

    public StackPane addStackPane() {
        StackPane stack = new StackPane();
        Rectangle rect = new Rectangle(30.0, 25.0);
        rect.setFill(Color.GRAY);
        rect.setArcWidth(10.0);
        rect.setArcHeight(10.0);

        stack.getChildren().add(rect);
        return stack;
    }

    public void initializeText() {
        text = new Text("0");
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        text.setFill(Color.WHITE);
    }

    @Override
    public void handle(KeyEvent event) {
        KeyCode code = event.getCode();
        Point2D potentialLocation = null;
        switch (code) {
            case UP:
                potentialLocation = new Point2D(-1, 0);
                break;
            case RIGHT:
                potentialLocation = new Point2D(0, 1);
                break;
            case DOWN:
                potentialLocation = new Point2D(1, 0);
                break;
            case LEFT:
                potentialLocation = new Point2D(0, -1);
                break;
        }
        if (potentialLocation != null) {
            mainGridPane.getChildren().remove(text);
            potentialLocation = textLocation.add(potentialLocation);
            if (potentialLocation.getX() < 10 && potentialLocation.getX() >= 0 &&
                    potentialLocation.getY() < 10 && potentialLocation.getY() >= 0) {

                textLocation = potentialLocation;
                StackPane stackPane = (StackPane) mainGridPane.getChildren().get((int)
                        ((int) (columnCount * textLocation.getX()) +
                                (textLocation.getY())));

                stackPane.getChildren().add(text);
                coordinate.setText("Coordinate: " + "(" + textLocation.getX() + ", "
                        + textLocation.getY() + ")");
            }
        }
    }

}
