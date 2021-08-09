package java_2.practicaTM.ejercicio5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    /*
        Ejercicio 5
        Crea una clase Fecha. La clase contendrá además de los constructores que consideres
        adecuados, métodos de acceso y el método toString, tal como lo explicamos en el ejercicio
        anterior, un método para comprobar si la fecha es correcta y otro para sumarle un día al valor
        actual de la fecha. Se debe investigar y utilizar la clase GregorianCalendar para implementar
        los métodos y constructores de Fecha.
     */
    private GregorianCalendar fechaActual;

    public GregorianCalendar getFechaActual() {
        return this.fechaActual;
    }

    public void setFechaActual(GregorianCalendar fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Fecha() {
        this.fechaActual = new GregorianCalendar();
    }

    public void compararFecha(GregorianCalendar gc) {
        String result = 0 == this.getFechaActual().compareTo(gc) ? "Claro que si" : "Claro que no!!";
        System.out.println(result);
    }

    public void sumarDia() {
        this.fechaActual.add(Calendar.DATE, 1);
    }

    @Override
    public String toString() {
        return "Fecha = " + this.fechaActual.getTime();
    }
}
