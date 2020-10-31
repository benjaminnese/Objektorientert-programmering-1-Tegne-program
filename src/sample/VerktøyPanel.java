package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class VerktøyPanel extends TegnePanel {

    static VBox verktøyPanelZ;
    static VBox verktøyPanel;
    static GridPane verktøyGrid;
    static GridPane verktøyGridZ;
    static Button btnSirkel;
    static Button btnRettLinje;
    static Button btnFirkant;
    static Button btnText;
    static Button btnVelgFigur;
    static Button btnEllipse;
    static Button btnOpp;
    static Button btnNed;
    static Button btnHeltBak;
    static Button btnHeltFrem;

    public static BorderPane lagVerktøyPanel() {
        BorderPane verktøyPanelBeholder = new BorderPane();

        verktøyPanelZ = new VBox();

        verktøyPanel = new VBox();


        verktøyPanelBeholder.setStyle("-fx-background-color: #3f6184;");
        verktøyPanelBeholder.setPadding(new Insets(10, 10, 10, 10));
        verktøyPanelBeholder.setPrefWidth(150);
        verktøyGrid = new GridPane();
        verktøyGrid.setVgap(10);
        verktøyGrid.setHgap(10);
        verktøyPanel.setAlignment(Pos.CENTER);
        verktøyGridZ = new GridPane();
        verktøyGridZ.setVgap(10);
        verktøyGridZ.setHgap(10);


        btnRettLinje = new Button();
        btnRettLinje.setGraphic(hentBilde("line"));
        btnRettLinje.setOnAction(e -> tegnePanel.setOnMousePressed(EventHåntering.mouseHandlerFigur));
        btnRettLinje.setTooltip(new Tooltip("Lag rett linje"));

        btnSirkel = new Button();
        btnSirkel.setGraphic(hentBilde("Sirkel"));
        btnSirkel.setOnAction(e -> tegnePanel.setOnMousePressed(EventHåntering.mouseHandlerFigur));
        btnSirkel.setTooltip(new Tooltip("Lag Sirkel"));

        btnFirkant = new Button();
        btnFirkant.setGraphic(hentBilde("square"));
        btnFirkant.setOnAction(e -> tegnePanel.setOnMousePressed(EventHåntering.mouseHandlerFigur));
        btnFirkant.setTooltip(new Tooltip("Lag Firkant"));

        btnEllipse = new Button();
        btnEllipse.setGraphic(hentBilde("ellipse"));
        btnEllipse.setOnAction(e -> tegnePanel.setOnMousePressed(EventHåntering.mouseHandlerFigur));
        btnEllipse.setTooltip(new Tooltip("Lag ellipse"));

        btnText = new Button();
        btnText.setGraphic(hentBilde("font"));
        btnText.setOnAction(e -> tegnePanel.setOnMousePressed(EventHåntering.mouseHandlerFigur));
        btnText.setTooltip(new Tooltip("Lag text boks"));

        btnVelgFigur = new Button();
        btnVelgFigur.setGraphic(hentBilde("valgFigur"));
        btnVelgFigur.setOnAction(e -> EventHåntering.figur.setOnMousePressed(EventHåntering.mouseHandlerVelgFigur));
        btnVelgFigur.setTooltip(new Tooltip("Velg figur"));


        btnNed = new Button();
        btnNed.setGraphic(hentBilde("Minus"));
        btnNed.setOnAction(e -> {
            int index = Integer.parseInt(EventHåntering.figur.getObjekt().getId()) - 1;
            tegnePanel.getChildren().get(index).setViewOrder(tegnePanel.getChildren().get(index).getViewOrder() + 0.1);
            VerktøyPanel.btnVelgFigur.requestFocus();
        });

        btnOpp = new Button();
        btnOpp.setGraphic(hentBilde("leggTil"));
        btnOpp.setOnAction(e -> {
            int index = Integer.parseInt(EventHåntering.figur.getObjekt().getId()) - 1;
            tegnePanel.getChildren().get(index).setViewOrder(tegnePanel.getChildren().get(index).getViewOrder() - 0.1);
            VerktøyPanel.btnVelgFigur.requestFocus();
        });

        btnHeltFrem = new Button();
        btnHeltFrem.setGraphic(hentBilde("up-arrow"));
        btnHeltFrem.setOnAction(e -> {
            int index = Integer.parseInt(EventHåntering.figur.getObjekt().getId()) - 1;
            for (int i = 0; i < tegnePanel.getChildren().size(); i++)
                if (tegnePanel.getChildren().get(i).getViewOrder() <= tegnePanel.getChildren().get(index).getViewOrder())
                    tegnePanel.getChildren().get(index).setViewOrder(tegnePanel.getChildren().get(i).getViewOrder() - 0.1);
            VerktøyPanel.btnVelgFigur.requestFocus();
        });

        btnHeltBak = new Button();
        btnHeltBak.setGraphic(hentBilde("down-arrow"));
        btnHeltBak.setOnAction(e -> {
            int index = Integer.parseInt(EventHåntering.figur.getObjekt().getId()) - 1;
            for (int i = 0; i < tegnePanel.getChildren().size(); i++)
                if (tegnePanel.getChildren().get(i).getViewOrder() >= tegnePanel.getChildren().get(index).getViewOrder())
                    tegnePanel.getChildren().get(index).setViewOrder(tegnePanel.getChildren().get(i).getViewOrder() + 0.1);
            VerktøyPanel.btnVelgFigur.requestFocus();
        });


        verktøyGrid.add(btnSirkel, 0, 0);
        verktøyGrid.add(btnFirkant, 1, 0);
        verktøyGrid.add(btnRettLinje, 0, 1);
        verktøyGrid.add(btnText, 1, 1);
        verktøyGrid.add(btnEllipse, 0, 2);
        verktøyGrid.add(btnVelgFigur, 1, 2);
        verktøyGridZ.add(btnOpp, 0, 0);
        verktøyGridZ.add(btnNed, 1, 0);
        verktøyGridZ.add(btnHeltFrem, 0, 1);
        verktøyGridZ.add(btnHeltBak, 1, 1);

        verktøyPanel.getChildren().add(verktøyGrid);
        verktøyPanelZ.getChildren().add(verktøyGridZ);
        verktøyPanelBeholder.setTop(verktøyPanel);
        verktøyPanelBeholder.setBottom(verktøyPanelZ);
        return verktøyPanelBeholder;
    }

    static ImageView hentBilde(String bildeNavn) {

        Image img = new Image(VerktøyPanel.class.getResourceAsStream("icons/" + bildeNavn + ".png"));
        ImageView showImg = new ImageView(img);
        showImg.setFitHeight(45);
        showImg.setFitWidth(45);
        return showImg;
    }
}
