package sample;

import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;

public class TopPanel extends Main {

  public static HBox lagTopPanel() {
    HBox topPanel = new HBox();
    topPanel.setPadding(new Insets(0, 0, 5, 0));
    MenuBar menuFil = new MenuBar();
    MenuItem nyFil = new MenuItem("Ny fil");

    nyFil.setOnAction(e->{
      MuseTrykk.slettAlle();
    });
    MenuItem lagreFil = new MenuItem("Lagre fil");
    lagreFil.setOnAction(e->{
      StatusPanel.txtStatus.setText(StatusPanel.txtStatus.getText() +" Fil lagres på harddisk..") ;
    });
    Menu fil = new Menu("Filer");
    fil.getItems().addAll(nyFil, lagreFil);
    menuFil.getMenus().add(fil);
    menuFil.prefWidthProperty().bind(topPanel.widthProperty());
    topPanel.getChildren().add(menuFil);

    return topPanel;
  }

}
