package sample;


import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Firkant extends Rectangle  {
    Rectangle firkant;

    Firkant() {
        new Figur.FigurKjør();

    }

    Firkant(double x1, double y1, double x2, double y2) {
        this();
        firkant = new Rectangle(x1, y1, x2, y2);
        firkant.setFill(Figur.farge);
        firkant.setStroke(Color.BLACK);
        Figur.figurListe.add(firkant);
        firkant.setId("" + Figur.antall);
    }

    public void setStartX(double x) {
        firkant.setX(x);
    }

    public void setStartY(double y) {
        firkant.setY(y);
    }

    public double getWidthRiktig(double b) {
        double bredde = (b > firkant.getX()) ? b - firkant.getX() : firkant.getX() - b;
        return bredde;
    }
    public double getHeightRiktig(double h) {
        double høyde = (h > firkant.getY()) ? h - firkant.getY() : firkant.getY() - h;
       return høyde;
    }

    public double getBredde() {
        return firkant.getWidth();
    }

    public double getHøyde() {
        return firkant.getHeight();
    }




    public String toString() {
        return super.toString() +
                firkant.getId()
                + "@Type:@"
                + this.getTypeSelector()
                + "@Farge:@"
                + firkant.getFill()
                + "@X:@"
                + firkant.getX()
                + "@Y:@"
                + firkant.getY()
                + "@Hoyde:@"
                + firkant.getHeight()
                + "@Bredde:@"
                + firkant.getWidth();
    }


    public void setStrokeWidth(int x) {
        if (x == 1)
            firkant.setStrokeWidth(10);
        else if (x == 0)
            firkant.setStrokeWidth(5);
        else
            firkant.setStrokeWidth(1);
    }


    public Firkant getObjekt() {
        return this;
    }
}
