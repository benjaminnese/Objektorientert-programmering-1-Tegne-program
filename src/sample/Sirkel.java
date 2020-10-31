package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

import java.util.List;


public class Sirkel extends Figur {

    Circle sirkel;

    Sirkel(double x1, double y1, Color farge) {
        super();
        sirkel = new Circle(x1, y1, 10, farge);
        sirkel.setStroke(Color.BLACK);
        sirkel.setStrokeWidth(10);
        Figur.figurListe.add(this);
        sirkel.setId("" + Figur.antall);
    }

    @Override
    public void setRadius(double x) {
        sirkel.setRadius(x);
    }

    @Override
    public void flyttFigur(double x, double y) {
        sirkel.setCenterX(x);
        sirkel.setCenterY(y);
    }

    @Override
    public String getAreal(){
        return "" + (int)((((sirkel.getRadius() * sirkel.getRadius() * Math.PI))/100)+0.5);
    }

    @Override
    public String getOmkrets(){
        return "" +(int)((((Math.PI*2)*sirkel.getRadius())/100)+0.5);
    }

    @Override
    public String hentFigurType() {
        return sirkel.getTypeSelector();
    }

    @Override
    public Circle getObjekt() {
        return sirkel;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Posisjon:@"
                + sirkel.getId()
                + " av "
                + figurListe.size()
                + "@Farge:@"
                + sirkel.getFill()
                + "@X:@"
                + sirkel.getCenterX()
                + "@Y:@"
                + sirkel.getCenterY()
                + "@Areal/100:@"
                + getAreal()
                +"@"
                + "Omkrets/100:@"
                + getOmkrets()
                + "@Radius:@"
                + sirkel.getRadius();
    }
}
