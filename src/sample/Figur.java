package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.LinkedList;

abstract class Figur extends Shape {

    protected static Color farge = Color.WHITE;
    static LinkedList<Figur> figurListe = new LinkedList<>();
    static int antall = 0;


    Figur() {
        farge = Color.color(Math.random(), Math.random(), Math.random());
        antall++;
    }

    public void setEndX(double x) { }
    public void setEndY(double y) { }
    public void setX(double x) { }
    public void setY(double y) { }
    public void setRadius(double x) { }
    public void setRadius(double x, double y) { }
    public void setBreddeHøyde(double x, double y){}
    public void setWidth(double x){}
    public void setHeight(double y){}
    public void setStrokeWidthLinje(double x){}
    public double getWidthRiktig(double x2) { return 0; }
    public void setText(String text) { }

    public abstract <T extends Shape> T getObjekt();
    public abstract String hentFigurType();
    public abstract void flyttFigur(double x, double y);
    public abstract String getAreal();
    public abstract String getOmkrets();
    public String toString() {
        return EventHåntering.figur.hentFigurType().toUpperCase()+"@";
    }

}
