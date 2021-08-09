package java_1.practicatm;

public class Ejercicio3 {
/*
    Ejercicio 3
    Desarrollar un programa para informar si un número n es primo o no, siendo n un
    valor que el usuario ingresará por consola.
    Recordá que un número es primo cuando sólo es divisible por sí mismo y por 1
 */

    public static void main(String[] args) {
        System.out.println("Ingrese el numero a verificar si es numero primo.");
        int dato = Utils.obtenerDato();

        if (Utils.esPrimo(dato)) {
            System.out.println("El numero '" + dato + "' es primo.");
        } else {
            System.out.println("El numero '" + dato + "' no es primo.");
        }
    }

}
