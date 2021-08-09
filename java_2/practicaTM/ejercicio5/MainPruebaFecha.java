package java_2.practicaTM.ejercicio5;

import java.util.GregorianCalendar;

public class MainPruebaFecha {
    public static void main(String[] args) {
        Fecha fecha = new Fecha();
        System.out.println(fecha.toString());

        GregorianCalendar fechaIncorrecta = new GregorianCalendar(2018, 5, 28);
        GregorianCalendar fechaCorrecta = fecha.getFechaActual();

        fecha.compararFecha(fechaIncorrecta);
        fecha.compararFecha(fechaCorrecta);

        fecha.sumarDia();
        System.out.println(fecha.toString());
    }
}
