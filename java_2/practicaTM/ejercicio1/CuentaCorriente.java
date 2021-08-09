package java_2.practicaTM.ejercicio1;

import java.util.UUID;

public class CuentaCorriente {
    /*
        Ejercicio 1
        Crea una clase CuentaCorriente, con los métodos: ingreso, egreso, reintegro y
        transferencia. La clase contendrá un constructor por defecto, uno con parámetros y otro que
        recibirá una CuentaCorriente de la cual copiará todos sus datos. Además se deben
        desarrollar los métodos de acceso (para cada variable de instancia de la clase, desarrollar
        un método set y otro get. Por ejemplo: si la clase tiene una variable double saldo, sus
        métodos de acceso serán: double getSaldo() y void setSaldo(double s). Los prototipos de
        los métodos y constructores deberán ser discutidos y diseñados en equipo
     */
    private double saldo;
    private String cbu;

    public double getSaldo() {
        return this.saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCbu() {
        return this.cbu;
    }

    private void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public CuentaCorriente() {
        System.out.println("\n***** Generando nueva cuenta *****");
        this.setCbu(this.generateRandomCbu());
        this.setSaldo(0);
        System.out.println("***** Se ha generado correctamente la cuenta " + this.getCbu() + "*****");
    }

    public CuentaCorriente(String cbu, double saldo) {
        System.out.println("\n***** Generando nueva cuenta *****");
        this.setCbu(cbu);
        this.setSaldo(saldo);
        System.out.println("***** Se ha generado correctamente la cuenta " + this.getCbu() + "*****");
    }

    public CuentaCorriente(CuentaCorriente cc) {
        System.out.println("\n***** Generando nueva cuenta *****");
        this.setSaldo(cc.getSaldo());
        this.setCbu(cc.getCbu());
        System.out.println("Se ha generado la nueva cuenta corriente con los datos de la cuenta " + cc.getCbu());
    }

    public void ingreso(double ingreso) {
        System.out.println("\n***** Realizando ingreso *****");
        this.saldo += ingreso;
        System.out.println("Se han ingresado " + ingreso + " a la cuenta");
    }

    public boolean egreso(double egreso) {
        System.out.println("\n***** Realizando egreso *****");
        if (this.saldo > egreso) {
            this.saldo -= egreso;
            System.out.println("Se han descontado " + egreso + " de su cuenta.");
            return true;
        } else {
            System.out.println("Usted no posee saldo suficiente.");
            return false;
        }
    }

    public void reintegro(double reintegro) {
        System.out.println("\n***** Realizando reintegro *****");
        this.ingreso(reintegro);
    }

    public void transferencia(double saldo, CuentaCorriente cc) {
        System.out.println("\n***** Realizando transferencia *****");
        if (this.egreso(saldo)) {
            cc.ingreso(saldo);
            System.out.println("Se han logrado transferir " + saldo + " a la cuenta " + cc.getCbu());
        } else {
            System.out.println("No se pudo transferir porque usted no posee saldo suficiente.");
        }
    }

    public String generateRandomCbu() {
        return UUID.randomUUID().toString();
    }

    public void printSaldo() {
        System.out.println("El saldo actual del cbu " + this.getCbu() + " es de: " + this.getSaldo());
    }

}
