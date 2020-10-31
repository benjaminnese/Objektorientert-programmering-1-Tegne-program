package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class RettLinje extends Figur {

    Line linje;
    double linjeTykkelse = 10;

    RettLinje(double x, double y) {
        super();
        linje = new Line(x,y,x,y);
        linje.setStrokeWidth(linjeTykkelse);
        linje.setStroke(Color.BLACK);
        Figur.figurListe.add(this);
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

    @Override
    public void setEndX(double x){
        linje.setEndX(x);
    }
    @Override
    public void setEndY(double y){
        linje.setEndY(y);
    }
    @Override
    public void flyttFigur(double x, double y) {
        linje.setStartX(this.getBredde());
        linje.setStartY(this.getHøyde());
        linje.setEndX(this.getBredde()-x);
        linje.setEndY(this.getHøyde()-y);
    }

    @Override
    public String getAreal() {
        return null;
    }

    @Override
    public String getOmkrets() {
        return null;
    }

    public String toString() {
        return super.toString()
                + "Posisjon:@"
                + linje.getId()
                + " av "
                + figurListe.size()
                + "@Farge:@"
                + linje.getStroke()
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

    @Override
    public void setStrokeWidthLinje(double x){
        linje.setStrokeWidth(x);
    }

    @Override
    public String hentFigurType() {
        return linje.getTypeSelector();
    }

    @Override
    public Line getObjekt() {
        return linje;
    }
}
