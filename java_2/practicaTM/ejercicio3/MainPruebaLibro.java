package java_2.practicaTM.ejercicio3;

public class MainPruebaLibro {
    public static void main(String[] args) {
        Libro libro = new Libro();
        libro.setTitulo("IT");
        libro.setIsbn(1234565582889L);
        libro.setAutor("King, Stephen");

        libro.prestamo();

        Libro libro2 = new Libro("Harry Potter", 9780545582889L, "Rowling, J. K.");
        libro2.prestamo();

        libro.devolucion();
        libro2.devolucion();
    }
}
