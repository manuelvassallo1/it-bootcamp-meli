package java_2.practicaTM.ejercicio1;

public class MainPruebaCuentaCorriente {
    public static void main(String[] args) {
        CuentaCorriente c1 = new CuentaCorriente();
        c1.ingreso(1000);
        c1.printSaldo();

        c1.egreso(500);
        c1.printSaldo();

        c1.reintegro(200);
        c1.printSaldo();

        CuentaCorriente c2 = new CuentaCorriente(c1.generateRandomCbu(), 1000);

        c1.transferencia(1000, c2);

        c1.printSaldo();
        c2.printSaldo();

        c1.transferencia(500, c2);

        c2.printSaldo();
        c2.printSaldo();

        CuentaCorriente c3 = new CuentaCorriente(c1);
        c3.printSaldo();
    }
}
