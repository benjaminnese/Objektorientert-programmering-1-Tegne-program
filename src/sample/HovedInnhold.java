package sample;

import javafx.scene.layout.Pane;

public class HovedInnhold {
    static Pane hovedInnhold;


    static int øversteLag;


    public static Pane lagHovedInnhold() {
        hovedInnhold = new Pane();

        hovedInnhold.setStyle("-fx-background-color: WHITE");
        hovedInnhold.setStyle("-fx-borderStyle: solid");
        hovedInnhold.setStyle("-fx-border-color: BLACK");


        return hovedInnhold;
    }


}
