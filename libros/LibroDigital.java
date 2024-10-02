package libros;

public class LibroDigital extends Libro {
    private String urlDescarga;

    public LibroDigital(String titulo, String autor, boolean disponible, String urlDescarga) {
        super(titulo, autor, disponible);
        this.urlDescarga = urlDescarga;
    }

    public String getUrlDescarga() {
        return urlDescarga;
    }
}