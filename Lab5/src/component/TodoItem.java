package component;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pane.RootPane;

public class TodoItem extends HBox {
	public TodoItem(String value) {
		this.setSpacing(10);
		Text text = new Text(value);
		text.setFont(new Font(20));
		Button button = new Button("Delete");
		button.setOnMouseClicked(event -> {
			RootPane.getDisplayPane().removeTodoItem(this);
		});
		this.getChildren().addAll(text , button);
	}
}