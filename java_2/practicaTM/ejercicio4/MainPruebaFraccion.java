package java_2.practicaTM.ejercicio4;

public class MainPruebaFraccion {
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(1, 4);
        Fraccion f2 = new Fraccion(1, 2);

        Fraccion suma1 = f1.sumar(f2);
        System.out.println("Resultado de sumar " + f1 + " y " + f2 + " es igual a : " + suma1);

        Fraccion suma2 = f1.sumar(2);
        System.out.println("Resultado de sumar " + f1 + " y " + 2 + " es igual a : " + suma2);

        Fraccion resta1 = f1.resta(f2);
        System.out.println("Resultado de restar " + f1 + " y " + f2 + " es igual a : " + resta1);

        Fraccion resta2 = f1.resta(2);
        System.out.println("Resultado de restar " + f1 + " y " + 2 + " es igual a : " + resta2);

        Fraccion producto1 = f1.multiplicar(f2);
        System.out.println("Resultado de multiplicar " + f1 + " y " + f2 + " es igual a : " + producto1);

        Fraccion producto2 = f1.multiplicar(2);
        System.out.println("Resultado de multiplicar " + f1 + " y " + 2 + " es igual a : " + producto2);

        Fraccion division1 = f1.dividir(f2);
        System.out.println("Resultado de dividir " + f1 + " y " + f2 + " es igual a : " + division1);

        Fraccion division2 = f1.dividir(2);
        System.out.println("Resultado de dividir " + f1 + " y " + 2 + " es igual a : " + division2);

    }
}
