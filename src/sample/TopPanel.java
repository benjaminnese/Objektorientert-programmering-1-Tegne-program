package sample;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;

public class TopPanel{
    //En lite funksjonell del av oppgaven, mest for øvingen sin del.
    public static HBox lagTopPanel() {
        HBox topPanel = new HBox();
        MenuBar menuFil = new MenuBar();
        MenuItem nyFil = new MenuItem("Ny fil");

        nyFil.setOnAction(e -> {
            EventHåntering.slettAlle();
        });
        MenuItem lagreFil = new MenuItem("Lagre fil");
        lagreFil.setOnAction(e -> {
            StatusPanel.txtStatus.setText(StatusPanel.txtStatus.getText() + " Fil lagres på harddisk.. || ");
        });
        Menu fil = new Menu("Meny");
        fil.setStyle("-fx-font-size:18;-fx-font-weight: bold;");

        fil.getItems().addAll(nyFil, lagreFil);
        menuFil.getMenus().add(fil);
        menuFil.prefWidthProperty().bind(topPanel.widthProperty()); //Meny blir like brei som topPanelet
        topPanel.getChildren().add(menuFil);
        return topPanel;
    }

}
