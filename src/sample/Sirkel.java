package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Sirkel extends Circle {

    Circle sirkel;
    Sirkel(){
        new Figur.FigurKjør();
    }


    Sirkel(double x1, double y1) {
        this();
        sirkel = new Circle(x1, y1,10, Figur.farge);
        sirkel.setStroke(Color.BLACK);
        Figur.figurListe.add(sirkel);
        sirkel.setId("" + Figur.antall);
    }



    @Override
    public String toString() {
        return
                sirkel.getId()
                + "@Type:@"
                + this.getTypeSelector()
                + "@Farge:@"
                + sirkel.getFill()
                + "@X:@"
                + sirkel.getCenterX()
                + "@Y:@"
                + sirkel.getCenterY()
                + "@Radius:@"
                + sirkel.getRadius();
    }
      public void setRadiusFigur(double x){
        sirkel.setRadius(x);
    }




    public Sirkel getObjekt() {
        return this;
    }


}
