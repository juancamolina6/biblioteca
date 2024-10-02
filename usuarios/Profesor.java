package usuarios;

import libros.Libro;

public class Profesor extends Usuario {
    private int maxLibros = 5;

    public Profesor(String nombre, String id) {
        super(nombre, id);
    }

    @Override
    public void prestarLibro(Libro libro) {
        if (maxLibros > 0) {
            super.prestarLibro(libro);
            maxLibros--;
        } else {
            System.out.println("Profesor " + nombre + " ha alcanzado el máximo de préstamos.");
        }
    }

    @Override
    public void devolverLibro(Libro libro) {
        super.devolverLibro(libro);
        maxLibros++;
    }
}
