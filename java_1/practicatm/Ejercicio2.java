package java_1.practicatm;

public class Ejercicio2 {
/*
    Ejercicio 2
    Desarrollar un programa para mostrar los primeros n múltiplos de m, siendo n y m valores
    que el usuario ingresará por consola.
    Recordá que un número a es múltiplo de b si a es divisible por b
*/

    public static void main(String[] args) {
        System.out.println("Ingrese el numero del cual quiere obtener sus multiplos.");
        int dato = Utils.obtenerDato();

        System.out.println("Ingrese la cantidad de multiplos que desea ver.");
        int cantMultiplos = Utils.obtenerDato();

        if (dato != 0) {
            for (int i = 1; i <= cantMultiplos; i++) {
                System.out.println(dato * i);
            }
        } else {
            System.out.println("El numero '0' solo se tiene a si mismo como multiplo");
        }

    }
}
