package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class EllipseFigur extends Figur {
    Ellipse ellipse;


    EllipseFigur(double x1, double y1, double x2, double y2, Color farge) {
        super();
        ellipse = new Ellipse(x1, y1, x2, y2);
        ellipse.setFill(farge);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(10);
        Figur.figurListe.add(this);
        ellipse.setId("" + Figur.antall);
    }


    @Override
    public String hentFigurType() {
        return ellipse.getTypeSelector();
    }

    @Override
    public void flyttFigur(double x, double y) {
        ellipse.setCenterX(x);
        ellipse.setCenterY(y);
    }


    @Override
    public String getAreal() {
        return "Husk";
    }

    @Override
    public String getOmkrets() {
        return "Husk";
    }

    @Override
    public void setRadius(double x, double y) {
        ellipse.setRadiusX(x);
        ellipse.setRadiusY(y);
    }


    @Override
    public String toString() {
        return  super.toString()
                + "Posisjon:@"
                + ellipse.getId()
                + " av "
                + figurListe.size()
                + "@Farge:@"
                + ellipse.getFill()
                + "@X:@"
                + ellipse.getCenterX()
                + "@Y:@"
                + ellipse.getCenterY()
                + "@Areal:@"
                + getAreal()
                + "@Omkrets:@"
                + getOmkrets()
                + "@X radius:@"
                + ellipse.getRadiusX()
                + "@Y radius:@"
                + ellipse.getRadiusY();
    }

    @Override
    public Ellipse getObjekt() {
        return ellipse;
    }


}
