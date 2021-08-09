package java_2.practicaTM.ejercicio3;

public class Libro {
    /*
        Ejercicio 3
        ● Crea una clase Libro con los métodos: préstamo, devolución y toString, cuyo prototipo
        debe ser: public String toString(). Este método debe retornar una cadena que
        represente al objeto. Por ejemplo: si la clase tiene los atributos: título, isbn y autor, una
        cadena que represente a un libro podría ser: “Harry Potter, 9780545582889, Rowling,
        J. K.”. La clase contendrá un constructor por defecto, un constructor con parámetros y
        los métodos de acceso.
     */
    private String titulo;
    private Long isbn;
    private String autor;

    public Libro() {

    }

    public Libro(String titulo, Long isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIsbn() {
        return this.isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return this.titulo + ", " + this.isbn + ", " + this.autor;
    }

    public void prestamo() {
        System.out.println("Se ha prestado correctamente el libro " + this.toString());
    }

    public void devolucion() {
        System.out.println("Se ha devuelto correctamente el libro " + this.toString());
    }


}
