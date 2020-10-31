package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    static final int panelWidth = 1920;
    static final int panelHeight = 1080;
    static final int minPanelWidth = 600;
    static final int minPanelHeight = 400;

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


    public static BorderPane lagHovedPanel(){
        BorderPane panel = new BorderPane();

        panel.setTop(TopPanel.lagTopPanel());
        panel.setRight(InfoPanel.lagInfoPanel());
        panel.setLeft(VerktøyPanel.lagVerktøyPanel());
        panel.setCenter( HovedInnhold.lagHovedInnhold());
        panel.setBottom(StatusPanel.lagStatusPanel());

        panel.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
                    if (event.getCode() == KeyCode.DELETE)
                        MuseTrykk.slettSiste();
             }
        );

        return panel;
    }


}
