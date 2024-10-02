import java.util.Scanner;
import libros.Libro;
import libros.LibroDigital;
import libros.LibroFisico;
import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Usuario;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Creación de libros (LibroDigital y LibroFisico)
        LibroDigital libroDigital = new LibroDigital("El Quijote", "Miguel de Cervantes", true, "http://descarga-quijote.com");
        LibroFisico libroFisico = new LibroFisico("Cien años de soledad", "Gabriel García Márquez", true, "Estante A3");

        // Registro de libros en la biblioteca
        biblioteca.agregarLibro(libroDigital);
        biblioteca.agregarLibro(libroFisico);

        // Creación de usuarios
        Estudiante usuario1 = new Estudiante("Juan", "001");
        Profesor usuario2 = new Profesor("Angui", "002");

        // Registro de usuarios en la biblioteca
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        // Menú
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después del entero

            switch (opcion) {
                case 1:
                    // Buscar libro por autor
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    Libro libroEncontradoPorAutor = biblioteca.buscarLibroPorAutor(autor);
                    if (libroEncontradoPorAutor != null) {
                        System.out.println("Libro encontrado: " + libroEncontradoPorAutor.getTitulo() + " - " + libroEncontradoPorAutor.getAutor());
                    } else {
                        System.out.println("No se encontró un libro de ese autor.");
                    }
                    break;

                case 2:
                    // Buscar libro por título
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    Libro libroEncontradoPorTitulo = biblioteca.buscarLibroPorTitulo(titulo);
                    if (libroEncontradoPorTitulo != null) {
                        System.out.println("Libro encontrado: " + libroEncontradoPorTitulo.getTitulo() + " - " + libroEncontradoPorTitulo.getAutor());
                    } else {
                        System.out.println("No se encontró un libro con ese título.");
                    }
                    break;

                case 3:
                    // Prestar libro
                    System.out.println("Seleccione un usuario (1. Juan, 2. Angui): ");
                    int usuarioSeleccionado = scanner.nextInt();
                    scanner.nextLine();  // Consumir nueva línea

                    Usuario usuarioPrestamo = (usuarioSeleccionado == 1) ? usuario1 : usuario2;

                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    Libro libroAPrestar = biblioteca.buscarLibroPorTitulo(tituloPrestar);
                    if (libroAPrestar != null && libroAPrestar.isDisponible()) {
                        usuarioPrestamo.prestarLibro(libroAPrestar);
                        System.out.println("El libro ha sido prestado.");
                    } else {
                        System.out.println("El libro no está disponible.");
                    }
                    break;

                case 4:
                    // Devolver libro
                    System.out.println("Seleccione un usuario (1. Juan, 2. Angui): ");
                    int usuarioSeleccionadoDevolucion = scanner.nextInt();
                    scanner.nextLine();  // Consumir nueva línea

                    Usuario usuarioDevolucion = (usuarioSeleccionadoDevolucion == 1) ? usuario1 : usuario2;

                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolver = scanner.nextLine();
                    Libro libroADevolver = biblioteca.buscarLibroPorTitulo(tituloDevolver);
                    if (libroADevolver != null) {
                        usuarioDevolucion.devolverLibro(libroADevolver);
                        System.out.println("El libro ha sido devuelto.");
                    } else {
                        System.out.println("El libro no está en préstamo.");
                    }
                    break;

                case 5:
                    // Mostrar libros disponibles
                    System.out.println("Libros disponibles en la biblioteca:");
                    biblioteca.mostrarLibrosDisponibles();
                    break;

                case 6:
                    // Agregar un nuevo libro
                    System.out.println("Agregar un nuevo libro a la biblioteca.");
                    System.out.print("Ingrese el título del libro: ");
                    String nuevoTitulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String nuevoAutor = scanner.nextLine();
                    
                    // Aquí decides si es un libro físico o digital
                    System.out.print("¿Es un libro físico o digital? (f/d): ");
                    String tipoLibro = scanner.nextLine();
                    Libro nuevoLibro;
                    if (tipoLibro.equalsIgnoreCase("f")) {
                        System.out.print("Ingrese la ubicación física: ");
                        String ubicacion = scanner.nextLine();
                        nuevoLibro = new LibroFisico(nuevoTitulo, nuevoAutor, true, ubicacion);
                    } else {
                        System.out.print("Ingrese la URL de descarga: ");
                        String urlDescarga = scanner.nextLine();
                        nuevoLibro = new LibroDigital(nuevoTitulo, nuevoAutor, true, urlDescarga);
                    }

                    biblioteca.agregarLibro(nuevoLibro);
                    System.out.println("Libro agregado exitosamente: " + nuevoTitulo);
                    break;

                case 7:
                    // Listar libros y mostrar su estado
                    System.out.println("Lista de libros en la biblioteca:");
                    biblioteca.listarLibrosConEstado();
                    break;

                case 0:
                    // Salir del menú
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }

            // Mostrar opción de volver al menú principal o salir
            if (opcion != 0) {
                mostrarOpcionMenu(scanner);
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Función para mostrar el menú principal
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú Biblioteca ---");
        System.out.println("1. Buscar libro por autor");
        System.out.println("2. Buscar libro por título");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("5. Mostrar libros disponibles");
        System.out.println("6. Agregar un libro");
        System.out.println("7. Listar todos los libros (con estado)");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    // Función para mostrar el menú de opciones después de ejecutar una funcionalidad
    private static void mostrarOpcionMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n¿Qué deseas hacer ahora?");
            System.out.println("1. Volver al menú principal");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            if (opcion == 0) {
                System.out.println("Saliendo del sistema...");
                System.exit(0);  // Finaliza el programa
            } else if (opcion != 1) {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 1);  // Volver al menú principal si la opción es 1
    }
}
