package java_2.practicaTM.ejercicio4;

public class Fraccion {
    /*
        Ejercicio 4
        Crea una clase Fraccion con métodos necesarios para sumar, restar, multiplicar y dividir
        fracciones. Todos los métodos deben estar sobrecargados de modo que también puedan
        usarse para operar entre fracciones y números enteros (por ejemplo: ⅗+2 o ⅝*4).
     */

    private int num;
    private int den;

    public Fraccion() {

    }

    public Fraccion(int num, int den) {
        this.num = num;
        this.den = den;
        this.simplificar();
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return this.den;
    }

    public void setDen(int den) {
        this.den = den;
    }

    public Fraccion sumar(Fraccion f2) {
        int finalNum = this.num * f2.getDen() + f2.getNum() * this.den;
        int finalDen = this.den * f2.getDen();

        return new Fraccion(finalNum, finalDen);
    }

    public Fraccion sumar(int entero) {
        return this.sumar(new Fraccion(entero, 1));
    }

    public Fraccion resta(Fraccion f2) {
        int finalNum = this.num * f2.getDen() - f2.getNum() * this.den;
        int finalDen = this.den * f2.getDen();

        return new Fraccion(finalNum, finalDen);
    }

    public Fraccion resta(int entero) {
        return this.resta(new Fraccion(entero, 1));
    }

    public Fraccion multiplicar(Fraccion f2) {
        int finalNum = this.num * f2.getNum();
        int finalDen = this.den * f2.getDen();

        return new Fraccion(finalNum, finalDen);
    }

    public Fraccion multiplicar(int entero) {
        return this.multiplicar(new Fraccion(entero, 1));
    }

    public Fraccion dividir(Fraccion f2) {
        int finalNum = this.num * f2.getDen();
        int finalDen = this.den * f2.getNum();

        return new Fraccion(finalNum, finalDen);
    }

    public Fraccion dividir(int entero) {
        return this.dividir(new Fraccion(entero, 1));
    }

    private void simplificar() {
        int mcd = mcd(this.num, this.den);
        this.num /= mcd;
        this.den /= mcd;
    }

    private static int mcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return mcd(b % a, a);
    }

    @Override
    public String toString() {
        return this.num + "/" + this.den;
    }

}
