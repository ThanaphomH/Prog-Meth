package pane;

import component.CreatePageButton;
import component.PageButton;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class NavigationPane extends VBox {
    private final ArrayList<PageButton> pageButtons = new ArrayList<>();
    private int currentPage;

    public NavigationPane() {
        this.setPrefWidth(80);
        this.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.setSpacing(15);
        this.setPadding(new Insets(15));

        CreatePageButton createPageButton = new CreatePageButton();
        this.getChildren().add(createPageButton);
    }

    public void addPage() {
        // TODO: FILL CODE HERE
    	PageButton button = new PageButton(this.pageButtons.size());
    	pageButtons.add(button);
    	this.getChildren().add(this.getChildren().size() - 1, button);
    	RootPane.getDisplayPane().addTodoList();
    	this.setCurrentPage(this.pageButtons.size() - 1);
    }

    public int getCurrentPage() {
        // TODO: FILL CODE HERE
    	return currentPage;
    }

    public void setCurrentPage(int pageNumber) {
        // TODO: FILL CODE HERE
    	if (pageNumber >= 0 && pageNumber < pageButtons.size()) {
    		this.pageButtons.get(currentPage).setActive(false);
    		this.currentPage = pageNumber;
    		this.pageButtons.get(pageNumber).setActive(true);
    		RootPane.getDisplayPane().setActiveTodoList(pageNumber);
    	}
    }
}
