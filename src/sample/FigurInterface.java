package sample;


public interface FigurInterface {

     default void setRadiusFigur(double x){};
     public abstract <T, K> T getObjekt();

     @Override
     abstract String toString();

}
