package java_1.practicatm;

import java.util.Scanner;

public class Utils {
    private Utils() {
        
    }

    public static boolean esPrimo(int dato) {

        if (dato < 2 || (dato > 2 && dato % 2 == 0)) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(dato); i++) {
            if (dato % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int obtenerDato() {
        Scanner scanner = new Scanner(System.in);

        String dato = scanner.nextLine();

        while (!Utils.validarDato(dato.trim())) {
            System.out.println("Ha ingresado un dato invalido. Por favor ingrese un Numero.");
            dato = scanner.nextLine();
        }
        return Integer.parseInt(dato);
    }

    public static boolean validarDato(String dato) {
        return dato.matches("^[0-9]+$");
    }
}
