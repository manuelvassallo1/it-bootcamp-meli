package java_2.practicaTM.ejercicio2;

public class MainPruebaContador {
    public static void main(String[] args) {
        Contador c1 = new Contador();
        c1.incrementarValor(1);
        c1.printValorActual();

        Contador c2 = new Contador(2);
        c2.decrementarValor(5);
        c2.printValorActual();

        Contador c3 = new Contador(c2);
        c3.printValorActual();

    }
}
