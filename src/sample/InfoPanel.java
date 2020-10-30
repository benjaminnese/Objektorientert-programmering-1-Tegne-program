package sample;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;


public class InfoPanel extends Main {

    static BorderPane infoPanel;
    static GridPane infoGrid;

    static Button btnFargeValg = new Button();

    public static BorderPane lagInfoPanel() {
        infoPanel = new BorderPane();
        ColorPicker colorPicker = new ColorPicker();
        ColorPicker colorPicker1 = new ColorPicker();
        colorPicker.setOnAction(e -> {
            Color x = colorPicker.getValue();
            MuseTrykk.selectedShape.setFill(x);

        });
        colorPicker1.setOnAction(e -> {
            Color x = colorPicker1.getValue();
            MuseTrykk.selectedShape.setStroke(x);
        });

        Label setFillFarge = new Label("Sett fill farge:");
        Label setStrokeFarge = new Label("Sett stroke farge:");
        String stilText = "-fx-font: 22 open-sans; -fx-font-weight:bold;-fx-text-fill: orange";
        setFillFarge.setStyle(stilText);
        setStrokeFarge.setStyle(stilText);
        VBox fargeContainer = new VBox();
        fargeContainer.getChildren().addAll(setFillFarge, colorPicker, setStrokeFarge, colorPicker1);
        infoPanel.setBottom(fargeContainer);
        infoPanel.setStyle("-fx-background-color: #3f6184;");
        infoGrid = new GridPane();
        infoPanel.setCenter(infoGrid);
        infoPanel.setVisible(false);
        infoPanel.setPrefWidth(0);
        infoPanel.setPadding(new Insets(8));

        return infoPanel;
    }

    public static void infoStatus(Shape x) {

        infoGrid.getChildren().clear();
        int id = Integer.parseInt(x.getId()) - 1;

        String temp = x.toString();
        String[] tempArr = temp.split(" ");
        System.out.println(temp);
        for(String k : tempArr)
            System.out.println(k);
        TextField txtEndre = new TextField();
        txtEndre.setStyle("-fx-font: 18 open-sans;-fx-font-weight:bold;");
        Button btnEdnre = new Button("Endre");
        TextField txtEndre2 = new TextField();
        txtEndre2.setStyle("-fx-font: 18 open-sans;-fx-font-weight:bold;");
        btnEdnre.setOnAction(e -> {
            if (x instanceof Circle)
                ((Circle) x).setRadius(Double.parseDouble(txtEndre.getText()));
            else if (x instanceof Line)
                x.setStrokeWidth(Double.parseDouble(txtEndre.getText()));
            else if (x instanceof Rectangle) {
                ((Rectangle) x).setHeight(Double.parseDouble(txtEndre.getText()));
                ((Rectangle) x).setWidth(Double.parseDouble(txtEndre2.getText()));
            } else if (x instanceof Text) {
                ((Text) x).setText(txtEndre.getText());
            }
            else if (x instanceof Ellipse) {
                ((Ellipse) x).setRadiusX(Double.parseDouble(txtEndre.getText()));
                ((Ellipse) x).setRadiusY(Double.parseDouble(txtEndre2.getText()));
            }
        });


        Label lblInfo;

        for (int i = 1; i < tempArr.length; i++) {
            if (i == tempArr.length - 1) {

                if (x instanceof Rectangle || x instanceof Ellipse) {
                    txtEndre.setText(tempArr[i - 2]);
                    txtEndre2.setText(tempArr[i]);
                    infoGrid.add(txtEndre, 0, i - 2);
                    infoGrid.add(txtEndre2, 0, i);
                    infoGrid.add(btnEdnre, 0, i + 2);
                } else {
                    txtEndre.setText(tempArr[i]);
                    infoGrid.add(txtEndre, 0, i + 1);
                    infoGrid.add(btnEdnre, 0, i + 2);
                }

            } else {
                lblInfo = new Label(tempArr[i]);
                lblInfo.setStyle("-fx-font: 22 open-sans; -fx-font-weight:bold;-fx-text-fill: orange;");
                if (i % 2 == 0)
                    lblInfo.setStyle("-fx-font: 20 open-sans; -fx-font-weight:bold;-fx-text-fill: white;");
                infoGrid.add(lblInfo, 0, i);
            }

        }


    }


}
