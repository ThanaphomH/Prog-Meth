package pane;

import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane {
    private static NavigationPane navigationPane;
    private static DisplayPane displayPane;
    private static InputPane inputPane;

    public RootPane() {
        // TODO: FILL CODE
    	this.navigationPane = new NavigationPane();
    	this.displayPane = new DisplayPane();
    	this.inputPane = new InputPane();
    	
    	this.navigationPane.addPage();
    	this.setBottom(inputPane);
    	this.setCenter(displayPane);
    	this.setLeft(navigationPane);
    	
    }

    public static NavigationPane getNavigationPane() {
        return navigationPane;
    }

    public static DisplayPane getDisplayPane() {
        return displayPane;
    }

    public static InputPane getInputPane() {
        return inputPane;
    }
}
