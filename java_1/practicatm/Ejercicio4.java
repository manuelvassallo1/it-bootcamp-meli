package java_1.practicatm;

public class Ejercicio4 {
    /*
        Ejercicio 4
        Desarrollar un programa para mostrar por consola los primeros n números primos, siendo n
        un valor que el usuario ingresará por consola.
    */
    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de numeros primos que desea ver.");
        int dato = Utils.obtenerDato();
        int cont = 0;

        for (int i = 2; cont < dato; i++) {
            if (Utils.esPrimo(i)) {
                cont++;
                System.out.println(i);
            }
        }
    }
}
