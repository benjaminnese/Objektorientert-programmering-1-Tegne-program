package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class InfoPanel{

    static BorderPane infoPanel;
    static GridPane infoGrid;

    static String txtOrange = "-fx-font: 22 open-sans; -fx-font-weight:bold;-fx-text-fill: orange; -fx-padding: 5 0 0 0";
    static String txtWhite = "-fx-font: 20 open-sans; -fx-font-weight:bold;-fx-text-fill: white; -fx-padding:-10 0 0 0;";
    static String txtOrangeBig = "-fx-font: 26 open-sans; -fx-font-weight:bold;-fx-text-fill: orange; " +
                                 "-fx-border-color: white; -fx-border-width: 5; -fx-padding:5;";
    static String txtBlackNormal = "-fx-font: 18 open-sans;-fx-font-weight:bold;";
    static Label lblInfo;
    static Label lblFigurOverSkrift;

    public static BorderPane lagInfoPanel() {

        infoPanel = new BorderPane();
        ColorPicker colorPicker = new ColorPicker();
        ColorPicker colorPicker1 = new ColorPicker();

        colorPicker.setOnAction(e -> {
            Color x = colorPicker.getValue();
            EventHåntering.valgShape.setFill(x);
            VerktøyPanel.btnVelgFigur.requestFocus();
        });

        colorPicker1.setOnAction(e -> {
            Color x = colorPicker1.getValue();
            EventHåntering.valgShape.setStroke(x);
            VerktøyPanel.btnVelgFigur.requestFocus();
        });

        Label setFillFarge = new Label("Sett fill farge:");
        Label setStrokeFarge = new Label("Sett stroke farge:");
        setFillFarge.setStyle(txtOrange);
        setStrokeFarge.setStyle(txtOrange);
        VBox fargeContainer = new VBox();
        fargeContainer.getChildren().addAll(setFillFarge, colorPicker, setStrokeFarge, colorPicker1);

        infoPanel.setBottom(fargeContainer);
        infoPanel.setStyle("-fx-background-color: #3f6184;");
        infoGrid = new GridPane();
        infoPanel.setCenter(infoGrid);
        infoPanel.setVisible(false); // sett infopanelet usynlig når det lages
        infoPanel.setPrefWidth(0);
        infoPanel.setPadding(new Insets(-10)); // liten bugfix, tok plass selvom setVisble var false
        return infoPanel;
    }

    public static void infoStatus(Figur x) { //Får inn den selekterte figuren
        infoGrid.getChildren().clear();
        String temp = x.toString();
        String[] tempArr = temp.split("@");

        TextField txtEndre = new TextField();
        txtEndre.setStyle(txtBlackNormal);
        txtEndre.setPrefColumnCount(4);

        TextField txtEndre2 = new TextField();
        txtEndre2.setStyle(txtBlackNormal);
        txtEndre2.setPrefColumnCount(4);

        Button btnEdnre = new Button("Endre");
        btnEdnre.setStyle(txtBlackNormal);

        lblFigurOverSkrift = new Label(tempArr[0]);
        lblFigurOverSkrift.setStyle(txtOrangeBig);
        infoPanel.setTop(lblFigurOverSkrift);
        BorderPane.setMargin(lblFigurOverSkrift, new Insets(10,0,40,0));
        BorderPane.setAlignment(lblFigurOverSkrift, Pos.CENTER);
        BorderPane.setAlignment(infoGrid, Pos.BOTTOM_CENTER);
        infoGrid.setVgap(5);
        Label blank = new Label("    ");

        for (int i = 1; i < tempArr.length; i++) { //Går gjennom toString fra figur og sett text/farge
            if (i == tempArr.length - 1) {
                if (x instanceof Firkant || x instanceof EllipseFigur) { //Vil ha to skrivbare text bokser på
                    txtEndre.setText(tempArr[i - 2]);                    //firkant og ellipse
                    txtEndre2.setText(tempArr[i]);
                    infoGrid.add(txtEndre, 0, i - 2);
                    infoGrid.add(txtEndre2, 0, i);
                    infoGrid.add(btnEdnre, 0, i + 2);
                } else {
                    txtEndre.setText(tempArr[i]);
                    infoGrid.add(txtEndre, 0, i + 1);
                    infoGrid.add(blank,1,i+1);
                    infoGrid.add(btnEdnre, 2, i + 1);
                }

            } else {
                lblInfo = new Label(tempArr[i]);
                lblInfo.setStyle(txtOrange);
                if (i % 2 == 0)
                    lblInfo.setStyle(txtWhite);
                infoGrid.add(lblInfo, 0, i);
            }

        }

        btnEdnre.setOnAction(e -> { //Endrer verdien etter text som ble skrevet inn
            if (x instanceof Sirkel) {
                x.setRadius(Double.parseDouble(txtEndre.getText()));
            } else if (x instanceof RettLinje)
                x.setStrokeWidthLinje(Double.parseDouble(txtEndre.getText()));
            else if (x instanceof Firkant) {
                x.setHeight((Double.parseDouble(txtEndre.getText())));
                x.setWidth((Double.parseDouble(txtEndre2.getText())));
            } else if (x instanceof TextBox) {
                x.setText(txtEndre.getText());
            } else if (x instanceof EllipseFigur) {
                x.setRadius(Double.parseDouble(txtEndre.getText()), Double.parseDouble(txtEndre2.getText()));

            }
            VerktøyPanel.btnVelgFigur.requestFocus();
        });



    }


}
