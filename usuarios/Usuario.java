package usuarios;

import libros.Libro;

public class Usuario {
    protected String nombre;
    protected String id;

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void prestarLibro(Libro libro) {
        if (libro.isDisponible()) {
            libro.prestar();
            System.out.println(nombre + " ha tomado prestado el libro: " + libro.getInfo());
        } else {
            System.out.println("El libro no está disponible.");
        }
    }

    public void devolverLibro(Libro libro) {
        libro.devolver();
        System.out.println(nombre + " ha devuelto el libro: " + libro.getInfo());
    }
}
