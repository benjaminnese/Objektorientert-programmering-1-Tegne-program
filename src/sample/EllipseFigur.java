package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class EllipseFigur extends Ellipse {
    Ellipse ellipse;

    EllipseFigur() {
        new Figur.FigurKjør();
    }

    EllipseFigur(double x1, double y1, double x2, double y2) {
        this();
        ellipse = new Ellipse(x1, y1, x2, y2);
        ellipse.setFill(Figur.farge);
        ellipse.setStroke(Color.BLACK);
        Figur.figurListe.add(ellipse);
        ellipse.setId("" + Figur.antall);
    }


    public void setStartX(double x) {
        ellipse.setCenterX(x);
    }

    public void setStartY(double y) {
        ellipse.setCenterY(y);
    }




    public void setStrokeWidth(int x) {
        if (x == 1)
            ellipse.setStrokeWidth(10);
        else if (x == 0)
            ellipse.setStrokeWidth(5);
        else
            ellipse.setStrokeWidth(1);
    }
    @Override
    public String toString() {
        return
                ellipse.getId()
                + "@Type:@"
                + this.getTypeSelector()
                + "@Farge:@"
                + ellipse.getFill()
                + "@X radius:@"
                + ellipse.getRadiusX()
                + "@Y radius:@"
                + ellipse.getRadiusY();
    }


    public EllipseFigur getObjekt() {
        return this;
    }



}
