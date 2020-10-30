package sample;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class RettLinje extends Line {
    Line linje;
    double linjeTykkelse = 10;

    RettLinje() {
        new Figur.FigurKjør();
    }

    RettLinje(double x1, double y1, double x2, double y2) {
        this();
        linje = new Line();
        linje.setStrokeWidth(linjeTykkelse);
        linje.setStartX(x1);
        linje.setStartY(y1);
        linje.setEndX(x2);
        linje.setEndY(y2);
        Figur.figurListe.add(linje);
        linje.setId("" + Figur.antall);

    }


    public double getBredde() {
        return (linje.getStartX() > linje.getEndX()) ?
                linje.getStartX() - linje.getEndX() :
                linje.getEndX() - linje.getStartX();
    }

    public double getHøyde() {
        return (linje.getStartY() > linje.getEndY()) ?
                linje.getStartY() - linje.getEndY() :
                linje.getEndY() - linje.getStartY();
    }

    public String toString() {
        return super.toString() +
                linje.getId()
                + "@Type:@"
                + this.getTypeSelector()
                + "@Farge:@"
                + linje.getFill()
                + "@X Start:@"
                + linje.getStartX()
                + "@X Slutt:@"
                + linje.getEndX()
                + "@Y Start:@"
                + linje.getStartY()
                + "@Y Slutt:@"
                + linje.getEndY()
                + "@Tykkelse:@"
                + linje.getStrokeWidth();
    }


    public void setStrokeWidth(int x) {

    }



    public RettLinje getObjekt() {
        return this;
    }
}
