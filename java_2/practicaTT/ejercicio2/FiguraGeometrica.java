package java_2.practicaTT.ejercicio2;

public abstract class FiguraGeometrica {
    private double valorArea;

    public double getValorArea() {
        return this.valorArea;
    }

    public void setValorArea(double valorArea) {
        this.valorArea = valorArea;
    }

    public abstract double area();


}
