package java_2.practicaTT.ejercicio2;

public class Main {
    public static void main(String[] args) {

        Circulo circulo = new Circulo(2);
        Triangulo triangulo = new Triangulo(2, 4);
        Rectangulo rectangulo = new Rectangulo(2, 4);
        FiguraGeometrica[] arr = {circulo, triangulo, rectangulo};

        try {
            System.out.println(Utils.areaPromedio(arr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
