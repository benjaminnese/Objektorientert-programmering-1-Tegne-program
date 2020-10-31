package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class StatusPanel extends Main {

    static HBox statusPanel;
    static BorderPane statusGrid;
    static Label txtStatus;
    static Label txtStatusInfo;

    public static HBox lagStatusPanel() {
        statusPanel = new HBox();
        statusPanel.setPadding(new Insets(2,30,2,20));
        statusGrid = new BorderPane();
        txtStatus = new Label("Status: ");
        txtStatusInfo = new Label();
        txtStatus.setStyle("-fx-font: 18 open-sans; -fx-font-weight:bold;");
        txtStatusInfo.setStyle("-fx-font: 18 open-sans; -fx-font-weight:bold;");

        statusGrid.setLeft(txtStatus);
        statusGrid.setRight(txtStatusInfo);
        statusGrid.prefWidthProperty().bind(statusPanel.widthProperty());

        statusPanel.getChildren().add(statusGrid);
        statusPanel.setStyle("-fx-background-color: #c1cdcd;");
        return statusPanel;
    }
}
