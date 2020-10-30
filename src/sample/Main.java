package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static final int panelWidth = 1920;
    static final int panelHeight = 1080;
    static BorderPane hovedPanel;

    @Override
    public void start(Stage primaryStage){

        Scene scene = new Scene(lagHovedPanel(), panelWidth, panelHeight);
        scene.getStylesheets().add(getClass().getResource("cssFil.css").toString());
        primaryStage.setTitle("Canvas Benjamin");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static BorderPane lagHovedPanel() {

        hovedPanel =
                lagPanel(
                        TopPanel.lagTopPanel(),
                        InfoPanel.lagInfoPanel(),
                        VerktøyPanel.lagVerktøyPanel(),
                        HovedInnhold.lagHovedInnhold(),
                        StatusPanel.lagStatusPanel());

        hovedPanel.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
                    if (event.getCode() == KeyCode.DELETE)
                        MuseTrykk.slettSiste();
                }

        );

        return hovedPanel;
    }

    public static BorderPane lagPanel(
            HBox topPanel,
            BorderPane infoPanel,
            BorderPane verktøyPanel,
            Pane hovedInnhold,
            HBox statusPanel) {
        BorderPane panel = new BorderPane();
        panel.setTop(topPanel);
        panel.setRight(infoPanel);
        panel.setLeft(verktøyPanel);
        panel.setCenter(hovedInnhold);
        panel.setBottom(statusPanel);

        return panel;
    }


}
