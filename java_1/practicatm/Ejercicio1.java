package java_1.practicatm;

/*
    Ejercicio 1
    Desarrollar un programa para mostrar los primeros n números pares, siendo n un valor que
    el usuario ingresará por consola.
    Recordá que un número es par cuando es divisible por 2.
 */
public class Ejercicio1 {
    public static void main(String[] args) {

        System.out.println("Ingrese un numero.");
        int datoValidado = Utils.obtenerDato();
        int contador = 0;
        int i = 0;

        while (contador != datoValidado) {
            if (i % 2 == 0) {
                System.out.println(i);
                contador++;
            }
            i++;
        }
    }
}
