import java.util.ArrayList;
import java.util.List;
import libros.Libro;
import libros.LibroDigital;
import libros.LibroFisico;
import usuarios.Usuario;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Mostrar todos los libros disponibles
    public void mostrarLibrosDisponibles() {
        boolean hayLibrosDisponibles = false;
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                hayLibrosDisponibles = true;
                System.out.println(libro.getTitulo() + " - " + libro.getAutor());
            }
        }
        if (!hayLibrosDisponibles) {
            System.err.println("No hay libros disponibles.");
        }
    }

    // Buscar libro por título
    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        System.err.println("No se encontró un libro con ese título.");
        return null;
    }

    // Buscar libro por autor
    public Libro buscarLibroPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                return libro;
            }
        }
        System.err.println("No se encontró un libro de ese autor.");
        return null;
    }

    // Listar todos los libros mostrando su estado
    public void listarLibrosConEstado() {
        for (Libro libro : libros) {
            String estado = libro.isDisponible() ? "Disponible" : "Prestado";
            String tipo = "";
    
            // Verificar el tipo de libro (Digital o Físico)
            if (libro instanceof LibroDigital) {
                tipo = "Digital";
            } else if (libro instanceof LibroFisico) {
                tipo = "Físico";
            }
    
            // Mostrar el título, autor, estado y tipo de libro
            System.out.println(libro.getTitulo() + " - " + libro.getAutor() + " [" + estado + "] (" + tipo + ")");
        }
    }

    // Método para buscar solo libros físicos
    public List<LibroFisico> buscarLibrosFisicos() {
        List<LibroFisico> librosFisicos = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro instanceof LibroFisico) {
                librosFisicos.add((LibroFisico) libro);
            }
        }
        return librosFisicos;
    }

    // Método para buscar solo libros digitales
    public List<LibroDigital> buscarLibrosDigitales() {
        List<LibroDigital> librosDigitales = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro instanceof LibroDigital) {
                librosDigitales.add((LibroDigital) libro);
            }
        }
        return librosDigitales;
    }
}
