package java_2.practicaTM.ejercicio2;

public class Contador {
    /*
        Ejercicio 2
        Crea una clase Contador (sí, contador de programación) con métodos que permitan
        incrementar y decrementar su valor. La clase contendrá un constructor por defecto, un
        constructor con parámetros, un constructor copia y los setters y getters (métodos de
        acceso) que corresponda.
     */

    private int valor;

    public int getValor() {
        return this.valor;
    }

    private void setValor(int valor) {
        this.valor = valor;
    }

    public Contador() {
        System.out.println("\n***** Generando nuevo contador por defecto *****");
        this.setValor(0);
    }

    public Contador(int valor) {
        System.out.println("\n***** Generando nuevo contador con parametro *****");
        this.setValor(valor);
    }

    public Contador(Contador contador) {
        System.out.println("\n***** Generando nuevo contador copia *****");
        this.setValor(contador.getValor());
    }

    public void incrementarValor(int valor) {
        System.out.println("***** Incrementando el valor *****");
        this.setValor(this.getValor() + valor);
    }

    public void decrementarValor(int valor) {
        System.out.println("***** Decrementando el valor *****");
        this.setValor(this.getValor() - valor);
    }

    public void printValorActual() {
        System.out.println("El valor actual del contador es: " + this.getValor());
    }
}
