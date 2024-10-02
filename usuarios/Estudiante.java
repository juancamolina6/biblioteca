package usuarios;

import libros.Libro;

public class Estudiante extends Usuario {
    private int maxLibros = 3;

    public Estudiante(String nombre, String id) {
        super(nombre, id);
    }

    @Override
    public void prestarLibro(Libro libro) {
        if (maxLibros > 0) {
            super.prestarLibro(libro);
            maxLibros--;
        } else {
            System.out.println("Estudiante " + nombre + " ha alcanzado el máximo de préstamos.");
        }
    }

    @Override
    public void devolverLibro(Libro libro) {
        super.devolverLibro(libro);
        maxLibros++;
    }
}
