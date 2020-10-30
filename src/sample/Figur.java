package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;

      abstract class Figur {


        static ObservableList<Shape> figurListe = FXCollections.observableArrayList();


        static Color farge = Color.WHITE;
        static int antall = 0;



    Figur() {

        farge = Color.color(Math.random(), Math.random(), Math.random());
        antall++;
        StatusPanel.txtStatusInfo.setText("Antall: " + antall);

    }





         public static class FigurKjør extends Figur{
         FigurKjør(){
             super();
         }




             public <T, K> T getObjekt() {
             return null;
         }
     }






}




