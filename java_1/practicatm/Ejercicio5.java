package java_1.practicatm;

public class Ejercicio5 {
/*
    Ejercicio 5
    Desarrollar un programa para mostrar por consola los primeros n números naturales que
    tienen al menos m dígitos d, siendo n, m y d valores que el usuario ingresará por consola.
    Por ejemplo: si el usuario ingresa n=5, m=2 y d=3, el programa deberá mostrar por consola
    los primeros 5 números naturales que tienen, al menos, 2 dígitos 3. En este caso la salida
    será: 33, 133, 233, 303, 313.    
 */

    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de numeros deseados.");
        int n = Utils.obtenerDato();

        System.out.println("Ingrese la cantidad de digitos.");
        int m = Utils.obtenerDato();

        System.out.println("Ingrese el digito deseado.");
        int d = Utils.obtenerDato();

        int cont = 0;
        for (int i = 0; cont < n; i++) {
            if (revisarNumero(i, m, d)) {
                System.out.print(i + " ");
                cont++;
            }
        }
    }

    private static boolean revisarNumero(int i, int m, int d) {
        int cont = 0;
        while (i > 0) {
            if (i % 10 == d) {
                cont++;
                if (cont == m) {
                    break;
                }
            }
            i /= 10;
        }
        return (i > 0);
    }
}
