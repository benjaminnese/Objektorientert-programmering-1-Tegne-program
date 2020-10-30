package sample;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class VerktøyPanel extends HovedInnhold {

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
        verktøyPanelZ.setPrefWidth(75);
        verktøyPanel = new VBox();

        verktøyPanel.setPrefWidth(75);
        verktøyPanel.setStyle("-fx-background-color: Black;");
        verktøyPanelZ.setStyle("-fx-background-color: Black;");
        verktøyPanelBeholder.setStyle("-fx-background-color: #3f6184;");
        verktøyPanelBeholder.setPadding(new Insets(10,0,10,0));
        verktøyGrid = new GridPane();
        verktøyGrid.setVgap(5);
        verktøyGrid.setHgap(5);
        verktøyGridZ = new GridPane();
        verktøyGridZ.setVgap(5);
        verktøyGridZ.setHgap(5);

        btnRettLinje = new Button();
        btnRettLinje.setGraphic(hentBilde("line"));
        btnRettLinje.setOnAction(e -> hovedInnhold.setOnMousePressed(MuseTrykk.mouseHandlerSirkel));
        btnRettLinje.setTooltip(new Tooltip("Lag rett linje"));

        btnSirkel = new Button();
        btnSirkel.setGraphic(hentBilde("Sirkel"));
        btnSirkel.setOnAction(e -> hovedInnhold.setOnMousePressed(MuseTrykk.mouseHandlerSirkel));
        btnSirkel.setTooltip(new Tooltip("Lag Sirkel"));

        btnFirkant = new Button();
        btnFirkant.setGraphic(hentBilde("square"));
        btnFirkant.setOnAction(e -> hovedInnhold.setOnMousePressed(MuseTrykk.mouseHandlerSirkel));
        btnFirkant.setTooltip(new Tooltip("Lag Firkant"));

        btnEllipse = new Button();
        btnEllipse.setGraphic(hentBilde("ellipse"));
        btnEllipse.setOnAction(e -> hovedInnhold.setOnMousePressed(MuseTrykk.mouseHandlerSirkel));
        btnEllipse.setTooltip(new Tooltip("Lag ellipse"));

        btnText = new Button();
        btnText.setGraphic(hentBilde("font"));
        btnText.setOnAction(e -> hovedInnhold.setOnMousePressed(MuseTrykk.mouseHandlerSirkel));
        btnText.setTooltip(new Tooltip("Lag text boks"));

        btnVelgFigur = new Button();
        btnVelgFigur.setGraphic(hentBilde("valgFigur"));
        btnVelgFigur.setOnAction(e -> MuseTrykk.selectedShape.setOnMousePressed(MuseTrykk.mouseHandlerVelgFigur));
        btnVelgFigur.setTooltip(new Tooltip("Velg figur"));


        btnNed = new Button();
        btnNed.setGraphic(hentBilde("Minus"));
        btnNed.setOnAction(e->{
            int index = Integer.parseInt(MuseTrykk.selectedShape.getId())-1;
            hovedInnhold.getChildren().get(index).setViewOrder(hovedInnhold.getChildren().get(index).getViewOrder()+0.1);
        });
        btnOpp = new Button();
        btnOpp.setGraphic(hentBilde("leggTil"));
        btnOpp.setOnAction(e->{
            int index = Integer.parseInt(MuseTrykk.selectedShape.getId())-1;
            hovedInnhold.getChildren().get(index).setViewOrder(hovedInnhold.getChildren().get(index).getViewOrder()-0.1);
        });

        btnHeltFrem = new Button();
        btnHeltFrem.setGraphic(hentBilde("up-arrow"));
        btnHeltFrem.setOnAction(e->{
            int index = Integer.parseInt(MuseTrykk.selectedShape.getId())-1;
            for(int i = 0; i < hovedInnhold.getChildren().size();i++)
                if(hovedInnhold.getChildren().get(i).getViewOrder() < hovedInnhold.getChildren().get(index).getViewOrder())
                    hovedInnhold.getChildren().get(index).setViewOrder(hovedInnhold.getChildren().get(i).getViewOrder()-0.1);
        });
        btnHeltBak = new Button();
        btnHeltBak.setGraphic(hentBilde("down-arrow"));
        btnHeltBak.setOnAction(e->{
            int index = Integer.parseInt(MuseTrykk.selectedShape.getId())-1;
            for(int i = 0; i < hovedInnhold.getChildren().size();i++)
                if(hovedInnhold.getChildren().get(i).getViewOrder() > hovedInnhold.getChildren().get(index).getViewOrder())
                    hovedInnhold.getChildren().get(index).setViewOrder(hovedInnhold.getChildren().get(i).getViewOrder()+0.1);
        });


        verktøyGrid.add(btnSirkel, 0, 0);
        verktøyGrid.add(btnFirkant, 1, 0);
        verktøyGrid.add(btnRettLinje, 0, 1);
        verktøyGrid.add(btnText, 1, 1);
        verktøyGrid.add(btnEllipse, 0, 2);
        verktøyGrid.add(btnVelgFigur, 1, 2);
        verktøyGridZ.add(btnOpp,0,0);
        verktøyGridZ.add(btnNed,1,0);
        verktøyGridZ.add(btnHeltFrem,0,1);
        verktøyGridZ.add(btnHeltBak,1,1);

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
