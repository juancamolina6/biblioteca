package libros;

public class Libro {
    private String titulo;
    private String autor;
    protected String isbn;
    private boolean disponible;
    

    public Libro(String titulo, String autor, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
        //this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getInfo() {
        return titulo + " de " + autor + " (ISBN: " + isbn + ")";
    }

    public String getAutor() {
        return autor;
    }
    public void prestar() {
        if (disponible) {
            disponible = false;
        } else {
            System.out.println("El libro ya está prestado.");
        }
    }
    public void devolver() {
        if (!disponible) {
            disponible = true;
        } else {
            System.out.println("El libro ya está disponible.");
        }
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}