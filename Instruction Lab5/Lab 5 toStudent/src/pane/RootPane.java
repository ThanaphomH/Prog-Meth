package pane;

import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane {
    private static NavigationPane navigationPane;
    private static DisplayPane displayPane;
    private static InputPane inputPane;

    public RootPane() {
        // TODO: FILL CODE
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
