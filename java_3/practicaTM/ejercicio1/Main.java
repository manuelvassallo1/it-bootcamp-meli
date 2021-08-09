package java_3.practicaTM.ejercicio1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona("Manu", 30000000);
        Persona p2 = new Persona("Graciela", 40000000);
        Persona p3 = new Persona("Camila", 35000000);

        System.out.println("Array ordenado de nombres de personas:");

        Persona[] arr = {p1, p2, p3};
        SortUtil.ordenar(arr);
        Arrays.stream(arr).forEach(persona -> System.out.println(persona.getNombre()));

        Celular c1 = new Celular(1512345678, "Manu");
        Celular c2 = new Celular(1598765432, "Camila");
        Celular c3 = new Celular(1532459867, "Graciela");

        System.out.println("\nArray ordenado de titulares de celular:");

        Celular[] arrCelu = {c1, c2, c3};
        SortUtil.ordenar(arrCelu);
        Arrays.stream(arrCelu).forEach(celular -> System.out.println(celular.getTitular()));
    }
}
