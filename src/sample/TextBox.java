package sample;


import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextBox extends Text {
    Text txtBox;

    TextBox() {
        new Figur.FigurKjør();
        txtBox = new Text(20,20,"TextBox: " + Figur.antall);
        txtBox.setFont(Font.font(30));
        Figur.figurListe.add(txtBox);
        txtBox.setId("" + Figur.antall);

    }


    public void setStyleFigur(String k) {
        txtBox.setStyle(k);
    }

    public String toString() {
        return super.toString() +
                txtBox.getId()
                + "@Type:@"
                + this.getTypeSelector()
                + "@Farge:@"
                + txtBox.getFill()
                + "@X:@"
                + txtBox.getX()
                + "@Y:@"
                + txtBox.getY()
                + "@Innhold:@"
                + txtBox.getText();
    }


    public void setStrokeWidth(int x) {

    }


    public TextBox getObjekt() {
        return this;
    }
}
