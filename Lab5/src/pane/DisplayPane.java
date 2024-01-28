package pane;

import component.TodoItem;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class DisplayPane extends VBox {
    private final ArrayList<ArrayList<TodoItem>> todoLists = new ArrayList<>();
    public DisplayPane() {
        // TODO: FILL CODE HERE
    	Background.fill(Color.WHITE);
    	this.setPadding(new Insets(20));
    	this.setSpacing(10);
    }

    public void addTodoList() {
        // TODO: FILL CODE HERE
    	ArrayList<TodoItem> array = new ArrayList<TodoItem>();
    	this.todoLists.add(array);
    }

    public void setActiveTodoList(int index) {
        // TODO: FILL CODE HERE
    	if (index >= 0 && index < this.todoLists.size()) {
    		this.getChildren().clear();
    		this.getChildren().addAll(this.todoLists.get(index));
    	}
    }

    public void addTodoItem(TodoItem todoItem) {
        int currentPage = RootPane.getNavigationPane().getCurrentPage();
        this.todoLists.get(currentPage).add(todoItem);
        this.getChildren().add(todoItem);
    }

    public void removeTodoItem(TodoItem todoItem) {
        int currentPage = RootPane.getNavigationPane().getCurrentPage();
        this.todoLists.get(currentPage).remove(todoItem);
        this.getChildren().remove(todoItem);
    }
}
