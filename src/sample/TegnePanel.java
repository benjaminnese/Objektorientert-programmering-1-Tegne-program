package sample;

import javafx.scene.layout.Pane;

public class TegnePanel {
    static Pane tegnePanel;


    public static Pane lagHovedInnhold() {
        tegnePanel = new Pane();

        tegnePanel.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3f6184");
        tegnePanel.requestFocus();
        return tegnePanel;
    }


}
