package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;



import static sample.HovedInnhold.hovedInnhold;


public class MuseTrykk {

    static Shape figur;
    static Shape selectedShape = new Circle(0,0,0, Color.WHITE);
    static double x1 = 0, y1 =0;
    static double viewOrder = 5.0;
    static EventHandler<MouseEvent> mouseHandlerSirkel = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {

                 x1 = mouseEvent.getX();
                 y1 = mouseEvent.getY();
                if(x1<10)
                    x1 += 20;
                if(y1<10)
                    y1 += 20;


            if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                    if (VerktøyPanel.btnSirkel.isFocused())
                        figur = new Sirkel(x1, y1);
                    else if(VerktøyPanel.btnFirkant.isFocused())
                        figur = new Firkant(x1, y1, 0, 0);
                    else if(VerktøyPanel.btnRettLinje.isFocused())
                        figur = new RettLinje(x1,y1,x1,y1);
                    else if(VerktøyPanel.btnEllipse.isFocused())
                        figur = new EllipseFigur(x1,y1,0,0);
                    else if(VerktøyPanel.btnText.isFocused())
                        figur = new TextBox();

                    if(!(figur == null) && !(VerktøyPanel.btnVelgFigur.isFocused())) {
                        hovedInnhold.getChildren().add(Figur.figurListe.get(Figur.figurListe.size() - 1));
                        hovedInnhold.getChildren().get(Figur.figurListe.size() - 1).setViewOrder(viewOrder-=0.1);

                    }
            }
            if (mouseEvent.getButton() == MouseButton.SECONDARY && VerktøyPanel.btnVelgFigur.isFocused()){

                if(selectedShape instanceof Circle) {
                    ((Circle) selectedShape).setCenterX(mouseEvent.getX());
                    ((Circle) selectedShape).setCenterY(mouseEvent.getY());
                }
                else if(selectedShape instanceof Rectangle) {
                    ((Rectangle) selectedShape).setX(x1 - ((Rectangle) selectedShape).getWidth() / 2);
                    ((Rectangle) selectedShape).setY(y1 - ((Rectangle) selectedShape).getHeight() / 2);
                }
                else if(selectedShape instanceof Ellipse){
                    ((Ellipse) selectedShape).setCenterX(x1);
                    ((Ellipse) selectedShape).setCenterY(y1);
                }
                else if(selectedShape instanceof Text){
                    ((Text) selectedShape).setStyle("-fx-font-weight:bold;");
                }
            }



                hovedInnhold.setOnMouseDragged(
                        e1 -> {
                            double x2 = e1.getX();
                            double y2 = e1.getY();



                            double diffX = (x2 > x1) ? x2 - x1 : x1 - x2;
                            double diffY = (y2 > y1) ? y2 - y1 : y1 - y2;
                            double radius =  ((diffX + diffY) / 2.0);


                            if (e1.getButton() == MouseButton.PRIMARY) {
                                if (VerktøyPanel.btnSirkel.isFocused()) {
                                    ((Circle) Figur.figurListe.get(Figur.figurListe.size() - 1)).setRadius(radius);
                                    if(x2-diffX+radius*2<0)
                                        ((Circle) Figur.figurListe.get(Figur.figurListe.size() - 1)).setCenterX(500);
                                } else if (VerktøyPanel.btnFirkant.isFocused()) {
                                    double width = ((Firkant) figur).getWidthRiktig(x2);
                                    double height = ((Firkant) figur).getHeightRiktig(y2);
                                    ((Rectangle) Figur.figurListe.get(Figur.figurListe.size() - 1)).setWidth((width));
                                    ((Rectangle) Figur.figurListe.get(Figur.figurListe.size() - 1)).setHeight((height));
                                } else if (VerktøyPanel.btnRettLinje.isFocused()) {
                                    ((Line) Figur.figurListe.get(Figur.figurListe.size() - 1)).setEndX(x2);
                                    ((Line) Figur.figurListe.get(Figur.figurListe.size() - 1)).setEndY(y2);
                                } else if (VerktøyPanel.btnEllipse.isFocused()) {
                                    ((Ellipse) Figur.figurListe.get(Figur.figurListe.size() - 1)).setRadiusX(diffX);
                                    ((Ellipse) Figur.figurListe.get(Figur.figurListe.size() - 1)).setRadiusY(diffY);
                                } else if (VerktøyPanel.btnText.isFocused()) {
                                    ((Text) Figur.figurListe.get(Figur.figurListe.size() - 1)).setX(x2);
                                    ((Text) Figur.figurListe.get(Figur.figurListe.size() - 1)).setY(y2);
                                }

                                else if(VerktøyPanel.btnVelgFigur.isFocused()){
                                    if (e1.getButton() == MouseButton.SECONDARY) {
                                        if (selectedShape instanceof Circle) {
                                            ((Circle) selectedShape).setCenterX(x2);
                                            ((Circle) selectedShape).setCenterY(y2);
                                        } else if (selectedShape instanceof Rectangle) {
                                            ((Rectangle) selectedShape).setX(x2 - ((Rectangle) selectedShape).getWidth() / 2);
                                            ((Rectangle) selectedShape).setY(y2 - ((Rectangle) selectedShape).getHeight() / 2);
                                        } else if (selectedShape instanceof Ellipse) {
                                            ((Ellipse) selectedShape).setRadiusX(x2);
                                            ((Ellipse) selectedShape).setRadiusX(y2);
                                        } else if (selectedShape instanceof Text) {
                                            ((Text) selectedShape).setX(x2);
                                            ((Text) selectedShape).setY(y2);
                                        }
                                    }
                                }
                                hovedInnhold.setOnMouseReleased(e3 -> {
                                    if (Figur.figurListe.size() > 0)
                                        Figur.figurListe.get(Figur.figurListe.size() - 1).setOnMousePressed(MuseTrykk.mouseHandlerVelgFigur);
                                });

                            }



            });

                    selectedShape.setOnMouseClicked(e2->{
                        if(e2.getClickCount()==2){
                            selectedShape = (Shape) e2.getSource();
                            selectedShape.setStrokeWidth(10);
                        }

                });


            for(int i = 0; i < Figur.figurListe.size();i++) {
                if(!(Figur.figurListe.get(i) == selectedShape))
                    if(Figur.figurListe.get(i).getStroke() == Color.BLACK)
                        if(!(Figur.figurListe.get(i).getTypeSelector().equals("Line")))
                            Figur.figurListe.get(i).setStrokeWidth(1);
            }
        }
    };

    static EventHandler<MouseEvent> mouseHandlerVelgFigur = new EventHandler<MouseEvent>() {


        @Override
        public void handle(MouseEvent mouseEvent) {
            double x1 = mouseEvent.getX();
            double y1 = mouseEvent.getY();

            if(mouseEvent.getClickCount()==2){
                InfoPanel.infoPanel.setVisible(true);
                InfoPanel.infoPanel.setPrefWidth(200);
                selectedShape = (Shape) mouseEvent.getSource();
                InfoPanel.infoStatus(selectedShape);
            }


        }
    };


    static void slettSiste() {
        if (!hovedInnhold.getChildren().isEmpty()) {
            hovedInnhold.getChildren().remove((Figur.figurListe.size()-1));
            Figur.figurListe.remove(Figur.figurListe.size()-1);
        }
    }

    static void slettAlle() {
        hovedInnhold.getChildren().clear();
        Figur.figurListe.clear();
        Figur.antall = 0;
    }

    static void lagre() {

    }


}
