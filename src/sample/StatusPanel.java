package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class StatusPanel extends Main {

  static HBox statusPanel;
  static GridPane statusGrid;
  static Label txtStatus;
  static Label txtStatusInfo;

  public static HBox lagStatusPanel() {
    statusPanel = new HBox();
    statusGrid = new GridPane();
    txtStatus = new Label("Status: ");
    txtStatusInfo = new Label();
    txtStatus.setStyle("-fx-font: 16 open-sans; -fx-font-weight:bold;");
    txtStatusInfo.setStyle("-fx-font: 16 open-sans; -fx-font-weight:bold;");

    statusGrid.add(txtStatus,0,0);
    statusGrid.add(txtStatusInfo,1,0);
    statusPanel.getChildren().add(statusGrid);
    statusPanel.setStyle("-fx-background-color: #c1cdcd;");
    return statusPanel;
  }
}
