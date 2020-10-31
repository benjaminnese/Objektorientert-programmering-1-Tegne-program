package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


public class EventHåntering {

    static Figur figur;
    static Shape valgShape;
    static double x1 = 0, y1 = 0;
    static double viewOrder = 5.0; //Standard verdi for noder i et panel er 0. Hvor lavere verdi hvor lengre frem
                                   //vil noden fremståe i panelet visuelt. Jeg setter den derfor på 5 for å kunne
                                   //har rom for å justere rekkefølgen på figurer både opp og ned.

    static EventHandler<MouseEvent> mouseHandlerFigur = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {

            x1 = mouseEvent.getX();
            y1 = mouseEvent.getY();
            Color farge = Color.color(Math.random(), Math.random(), Math.random());

            //Hvis bruker trykket venstre museknapp
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                if (VerktøyPanel.btnSirkel.isFocused())
                    figur = new Sirkel(x1, y1, farge);

                else if (VerktøyPanel.btnFirkant.isFocused())
                    figur = new Firkant(x1, y1, 0, 0, farge);

                else if (VerktøyPanel.btnRettLinje.isFocused())
                    figur = new RettLinje(x1, y1);

                else if (VerktøyPanel.btnEllipse.isFocused())
                    figur = new EllipseFigur(x1, y1, 0, 0, farge);

                else if (VerktøyPanel.btnText.isFocused())
                    figur = new TextBox(x1,y1);

                if (!(InfoPanel.infoPanel.isFocused())) //Sjekk for å ikke legg til duplikat eller tom figur
                    if (!(figur == null) && !(VerktøyPanel.btnVelgFigur.isFocused())) {
                        TegnePanel.tegnePanel.getChildren().add(Figur.figurListe.getLast().getObjekt());
                        TegnePanel.tegnePanel.getChildren().get(Integer.parseInt(Figur.figurListe.getLast().getObjekt().getId()) - 1).setViewOrder(viewOrder -= 0.1);
                    }

            }
            //Høyre museknapp
            //Kaller på figur sin akutuelle metode, slipper if(figur== sirkel) osv på forflyttingen
            else if (mouseEvent.getButton() == MouseButton.SECONDARY && VerktøyPanel.btnVelgFigur.isFocused())
                figur.flyttFigur(x1, y1);

            TegnePanel.tegnePanel.setOnMouseDragged(
                    e1 -> {
                        double x2 = e1.getX();
                        double y2 = e1.getY();
                        double diffX = (x2 > x1) ? x2 - x1 : x1 - x2;
                        double diffY = (y2 > y1) ? y2 - y1 : y1 - y2;
                        double radius = ((diffX + diffY) / 2.0);

                        if (e1.getButton() == MouseButton.PRIMARY) {
                            if (VerktøyPanel.btnSirkel.isFocused()) {
                                figur.setRadius(radius);

                            } else if (VerktøyPanel.btnFirkant.isFocused()) {
                                figur.setBreddeHøyde(x2, y2);

                            } else if (VerktøyPanel.btnRettLinje.isFocused()) {
                                figur.setEndX(x2);
                                figur.setEndY(y2);

                            } else if (VerktøyPanel.btnEllipse.isFocused()) {
                                figur.setRadius(diffX, diffY);

                            } else if (VerktøyPanel.btnText.isFocused()) {
                                figur.setX(x2);
                                figur.setY(y2);
                            }
                        }
                        else if (VerktøyPanel.btnVelgFigur.isFocused())
                            figur.flyttFigur(x2, y2);


                        TegnePanel.tegnePanel.setOnMouseReleased(e3 -> { //Legger på muselytter for hver ny figur som blir lagt til
                            if (Figur.figurListe.size() > 0)
                                Figur.figurListe.getLast().getObjekt().setOnMousePressed(EventHåntering.mouseHandlerVelgFigur);
                            StatusPanel.txtStatusInfo.setText("Antall: " + Figur.antall);
                            StatusPanel.txtStatus.setText("Status: ");
                        });
                    });

            for (int i = 0; i < Figur.figurListe.size() - 1; i++) { //Litt design, fjerner tjukk linje evnt underlinje på tekst
                if (!(Figur.figurListe.get(i).getObjekt() == valgShape)) {
                    if (Figur.figurListe.get(i).getObjekt().getStroke() == Color.BLACK) {
                        if (!(Figur.figurListe.get(i).getObjekt().getTypeSelector().equals("Line")))
                            Figur.figurListe.get(i).getObjekt().setStrokeWidth(1);
                    } else if (Figur.figurListe.get(i).getObjekt().getTypeSelector().equals("Text"))
                        Figur.figurListe.get(i).getObjekt().setStyle("-fx-underline: false");
                }
            }
        }
    };

    static EventHandler<MouseEvent> mouseHandlerVelgFigur = new EventHandler<MouseEvent>() {


        @Override
        public void handle(MouseEvent mouseEvent) {


            if (mouseEvent.getClickCount() == 2) {  //Funker som dobbelklikk på musen, resettes fort

                InfoPanel.infoPanel.setVisible(true); //Viser høyre panel sin informasjon ved figur selektering
                InfoPanel.infoPanel.setPrefWidth(260);  //sjult ved programstart
                InfoPanel.infoPanel.setPadding(new Insets(15));

                valgShape = (Shape) mouseEvent.getSource();
                int index = Integer.parseInt(valgShape.getId());
                figur = Figur.figurListe.get(index - 1);
                if (!(valgShape.getTypeSelector().equals("Line"))) //legg på tykkelse og underlinje for
                    valgShape.setStrokeWidth(5);                   //for tydeligere markere figur som er selektert
                if (valgShape.getTypeSelector().equals("Text"))
                    valgShape.setStyle("-fx-underline: true");
                InfoPanel.infoStatus(figur);
            }
        }
    };

    static void slettSiste() {
        if (!TegnePanel.tegnePanel.getChildren().isEmpty()) {
            TegnePanel.tegnePanel.getChildren().remove((Figur.figurListe.size() - 1));
            Figur.figurListe.removeLast();
        }
    }

    static void slettAlle() {
        TegnePanel.tegnePanel.getChildren().clear();
        Figur.figurListe.clear();
        Figur.antall = 0;
    }
    static void lagre() {}
}
