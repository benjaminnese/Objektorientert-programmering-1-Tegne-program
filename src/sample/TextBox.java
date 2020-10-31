package sample;



import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextBox extends Figur {
    Text txtBox;

    TextBox(double x, double y) {
        //new Figur.FigurKjør();
        super();
        txtBox = new Text(x,y, "TextBox");
        txtBox.setFont(Font.font(40));
        Figur.figurListe.add(this);
        txtBox.setId("" + Figur.antall);

    }


    @Override
    public void flyttFigur(double x, double y) {
        txtBox.setX(x);
        txtBox.setY(y);
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
                + txtBox.getId()
                + " av "
                + figurListe.size()
                + "@Farge:@"
                + txtBox.getFill()
                + "@X:@"
                + txtBox.getX()
                + "@Y:@"
                + txtBox.getY()
                + "@Innhold:@"
                + txtBox.getText();
    }


    @Override
    public void setText(String text) {
        txtBox.setText(text);
    }
    @Override
    public String hentFigurType() {
        return txtBox.getTypeSelector();
    }


    @Override
    public Text getObjekt() {
        return txtBox;
    }
}
