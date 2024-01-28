package pane;

import javax.swing.GroupLayout.Alignment;

import component.TodoItem;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class InputPane extends HBox {
    public InputPane() {
        // TODO: FILL CODE
    	this.setPrefHeight(70);
    	Background.fill(Color.LIGHTBLUE);
    	this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
    	this.setSpacing(20);
    	this.setAlignment(Pos.CENTER);
    	TextField textfield = new TextField();
    	textfield.setPrefWidth(300);
    	Button button = new Button("Submit");
    	button.setOnMouseClicked(event -> {
    		if (!textfield.getText().isBlank()) {
    			TodoItem todoitem = new TodoItem(textfield.getText().trim());
    			RootPane.getDisplayPane().addTodoItem(todoitem);
    			textfield.clear();
    		}
    	});
    	this.getChildren().addAll(textfield , button);
    }
}
