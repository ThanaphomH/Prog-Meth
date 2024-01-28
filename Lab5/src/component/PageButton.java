package component;

import javafx.scene.Cursor;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pane.RootPane;

public class PageButton extends StackPane{
	private Circle circle;
	
	public PageButton(int pageNumber) {
		this.circle = new Circle(25, Color.LIGHTGRAY);
		this.setCursor(Cursor.HAND);
		Text text = new Text(Integer.toString(pageNumber));
		text.setFont(new Font(25));
		
		this.setOnMouseClicked(event -> {
			RootPane.getNavigationPane().setCurrentPage(pageNumber);
		});
		this.getChildren().addAll(this.circle , text);
	}
	
	public void setActive(boolean value) {
		if (value) {
			this.circle.setFill(Color.WHITE);
		} else {
			this.circle.setFill(Color.LIGHTGRAY);
		}
	}
}