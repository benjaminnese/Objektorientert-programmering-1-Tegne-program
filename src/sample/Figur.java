package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.LinkedList;

abstract class Figur extends Shape {

    protected static Color farge = Color.WHITE;
    static LinkedList<Figur> figurListe = new LinkedList<>(); //Alle figurer blir lagt til her i sin
                                                              //konstrøtkor

    static int antall = 0; //variabel for å holde styr på antall figurer


    Figur() {
        antall++;
    }

    public void setX(double x) { }
    public void setY(double y) { }
    public void setEndX(double x) { }
    public void setEndY(double y) { }
    public void setRadius(double x) { }
    public void setRadius(double x, double y) { }
    public void setBreddeHøyde(double x, double y){}
    public void setWidth(double x){}
    public void setHeight(double y){}
    public void setStrokeWidthLinje(double x){}
    public void setText(String text) { }

    public String toString() {
        return EventHåntering.figur.hentFigurType().toUpperCase()+"@";
    }


    //Abstracte metoder, disse blir abstract siden fleste subklassene trenger metodene.
    public abstract <T extends Shape> T getObjekt();
    public abstract String hentFigurType();
    public abstract void flyttFigur(double x, double y);
    public abstract String getAreal();
    public abstract String getOmkrets();


}
