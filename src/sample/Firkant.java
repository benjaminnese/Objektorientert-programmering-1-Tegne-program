package sample;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Firkant extends Figur {
    Rectangle firkant;


    Firkant(double x1, double y1, double x2, double y2, Color farge) {
        super();
        firkant = new Rectangle(x1, y1, x2, y2);
        firkant.setFill(farge);
        firkant.setStroke(Color.BLACK);
        firkant.setStrokeWidth(10);
        Figur.figurListe.add(this);
        firkant.setId("" + Figur.antall);
    }

    @Override
    public void setBreddeHøyde(double x, double y){
        double bredde = (x > firkant.getX()) ? x - firkant.getX() : firkant.getX() - x;
        double høyde = (y > firkant.getY()) ? y - firkant.getY() : firkant.getY() - y;
        firkant.setWidth(bredde);
        firkant.setHeight(høyde);
    }

    @Override
    public void flyttFigur(double x, double y) {
        firkant.setX(x - firkant.getWidth() / 2);
        firkant.setY(y - firkant.getHeight() / 2);
    }

    @Override
    public void setHeight(double x){
        firkant.setHeight(x);
    }

    @Override
    public void setWidth(double y){
        firkant.setWidth(y);
    }

    @Override
    public String getAreal() {
        return "" + (int)(((firkant.getHeight()*firkant.getWidth())/100)+0.5);
    }

    @Override
    public String getOmkrets() {
        return "" + (int)((((firkant.getWidth()*2)+(firkant.getHeight()*2))/100)+0.5);
    }

    @Override
    public String hentFigurType() {
        return firkant.getTypeSelector();
    }

    @Override
    public Rectangle getObjekt() {
        return firkant;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Posisjon:@"
                + firkant.getId()
                + " av "
                + figurListe.size()
                + "@Farge:@"
                + firkant.getFill()
                + "@X:@"
                + firkant.getX()
                + "@Y:@"
                + firkant.getY()
                + "@Areal/100:@"
                + getAreal()
                + "@Omkrets/100@"
                + getOmkrets()
                + "@Hoyde:@"
                + firkant.getHeight()
                + "@Bredde:@"
                + firkant.getWidth();
    }
}
