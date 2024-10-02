package libros;

public class LibroFisico extends Libro {
    private String ubicacion;

    public LibroFisico(String titulo, String autor, boolean disponible, String ubicacion) {
        super(titulo, autor, disponible);
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
