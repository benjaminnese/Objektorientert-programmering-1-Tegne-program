//OBLIG JAVA_FX BENJAMIN NESE
//Kommenterer det jeg føler det kan være usikkerhet på om koden er forstått av meg
//Kunne nok gjort mer polyformi, private/protected/public, try/catch og generell lovelighet av inndata.

package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    static final double panelWidth = 1920;
    static final double panelHeight = 1080;
    static final double minPanelWidth = 600;
    static final double minPanelHeight = 400;

    public static BorderPane lagHovedPanel() {
        BorderPane panel = new BorderPane();

        panel.setTop(TopPanel.lagTopPanel());
        panel.setRight(InfoPanel.lagInfoPanel());
        panel.setLeft(VerktøyPanel.lagVerktøyPanel());
        panel.setCenter(TegnePanel.lagHovedInnhold());
        panel.setBottom(StatusPanel.lagStatusPanel());

        panel.addEventFilter(KeyEvent.KEY_RELEASED, event -> { //Legger inn event lytter på panelet for
                    if (event.getCode() == KeyCode.DELETE)     // om DEL knapp blir trykket
                        EventHåntering.slettSiste();
                }
        );
        return panel;
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(lagHovedPanel(), panelWidth, panelHeight);
        scene.getStylesheets().add(getClass().getResource("cssFil.css").toString()); //CSS for litt pirk
        primaryStage.setTitle("Canvas Benjamin");
        primaryStage.setMinHeight(minPanelHeight);
        primaryStage.setMinWidth(minPanelWidth);
        primaryStage.setScene(scene);
        primaryStage.show();
        TegnePanel.tegnePanel.requestFocus();
    }


}
