// ============================================================
// CLASE MAIN (PROGRAMA PRINCIPAL)
// Esta clase contiene el método main y el menú interactivo
// Es el punto de entrada de nuestro programa
// ============================================================

// Importamos la clase Scanner que permite leer datos del teclado
// "import" trae clases de otras librerías para poder usarlas
// java.util es un paquete (carpeta) de Java con utilidades
import java.util.Scanner;

// Clase principal del programa
public class Main {

    // ============================================================
    // MÉTODO MAIN
    // Es el punto de entrada del programa
    // Cuando ejecutamos el programa, Java busca este método
    // ============================================================

    // "public static void main(String[] args)" es la firma estándar del método main
    // - public: puede ser accedido desde cualquier lugar
    // - static: pertenece a la clase, no necesita crear un objeto
    // - void: no devuelve ningún valor
    // - String[] args: array de argumentos que se pueden pasar al programa
    public static void main(String[] args) {

        // Creamos un objeto Scanner para leer datos del teclado
        // System.in representa la entrada estándar (teclado)
        Scanner scanner = new Scanner(System.in);

        // Variable para almacenar nuestra agenda
        // La inicializamos como null (sin valor)
        Agenda agenda = null;

        // Variable para controlar si el programa sigue ejecutándose
        boolean continuar = true;

        // ============================================================
        // PASO 1: CREAR LA AGENDA
        // Preguntamos al usuario cómo quiere crear la agenda
        // ============================================================

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║     BIENVENIDO A LA AGENDA TELEFÓNICA      ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("¿Cómo desea crear la agenda?");
        System.out.println("1. Con tamaño personalizado");
        System.out.println("2. Con tamaño por defecto (10 contactos)");
        System.out.print("Seleccione una opción: ");

        // Leemos la opción del usuario
        // nextInt() lee un número entero del teclado
        int opcionCreacion = scanner.nextInt();

        // nextLine() consume el salto de línea que queda después de nextInt()
        // Esto evita problemas al leer texto después
        scanner.nextLine();

        // Estructura if-else para decidir qué hacer según la opción
        if (opcionCreacion == 1) {
            // Opción 1: Tamaño personalizado
            System.out.print("Ingrese el tamaño máximo de la agenda: ");
            int tamanio = scanner.nextInt();
            scanner.nextLine();  // Consumimos el salto de línea

            // Validamos que el tamaño sea positivo
            if (tamanio <= 0) {
                System.out.println("Tamaño inválido. Se usará el tamaño por defecto (10).");
                agenda = new Agenda();  // Usamos constructor sin parámetros
            } else {
                agenda = new Agenda(tamanio);  // Usamos constructor con tamaño
            }
        } else {
            // Opción 2 o cualquier otra: Tamaño por defecto
            agenda = new Agenda();
            System.out.println("Agenda creada con tamaño por defecto (10 contactos).");
        }

        System.out.println();

        // ============================================================
        // PASO 2: MENÚ PRINCIPAL
        // Bucle que se repite hasta que el usuario quiera salir
        // ============================================================

        // El bucle while se repite mientras la condición sea true
        while (continuar) {
            // Mostramos el menú de opciones
            mostrarMenu();

            // Leemos la opción del usuario
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumimos el salto de línea

            // Estructura switch para ejecutar la opción seleccionada
            // switch es similar a múltiples if-else, pero más limpio
            switch (opcion) {

                case 1:  // Añadir contacto
                    // Llamamos al método que maneja esta opción
                    añadirContacto(scanner, agenda);
                    break;  // "break" sale del switch

                case 2:  // Verificar si existe contacto
                    verificarExisteContacto(scanner, agenda);
                    break;

                case 3:  // Listar contactos
                    agenda.listarContactos();
                    break;

                case 4:  // Buscar contacto
                    buscarContacto(scanner, agenda);
                    break;

                case 5:  // Eliminar contacto
                    eliminarContacto(scanner, agenda);
                    break;

                case 6:  // Modificar teléfono
                    modificarTelefono(scanner, agenda);
                    break;

                case 7:  // Ver si agenda está llena
                    if (agenda.agendaLlena()) {
                        System.out.println("⚠ La agenda está LLENA.");
                    } else {
                        System.out.println("✓ La agenda NO está llena.");
                    }
                    break;

                case 8:  // Ver espacios libres
                    agenda.mostrarEspaciosLibres();
                    break;

                case 0:  // Salir
                    continuar = false;  // Cambiamos a false para salir del while
                    System.out.println("¡Gracias por usar la Agenda Telefónica!");
                    System.out.println("¡Hasta pronto!");
                    break;

                default:  // Cualquier otra opción
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            // Pequeña pausa visual entre opciones
            System.out.println();
        }

        // Cerramos el Scanner para liberar recursos
        // Es buena práctica cerrar los recursos que abrimos
        scanner.close();
    }

    // ============================================================
    // MÉTODO: mostrarMenu
    // Muestra el menú de opciones en pantalla
    // "static" porque se llama desde main (que también es static)
    // ============================================================

    private static void mostrarMenu() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║            MENÚ DE OPCIONES                ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║  1. Añadir contacto                        ║");
        System.out.println("║  2. Verificar si existe un contacto        ║");
        System.out.println("║  3. Listar todos los contactos             ║");
        System.out.println("║  4. Buscar contacto por nombre y apellido  ║");
        System.out.println("║  5. Eliminar contacto                      ║");
        System.out.println("║  6. Modificar teléfono de un contacto      ║");
        System.out.println("║  7. Verificar si la agenda está llena      ║");
        System.out.println("║  8. Ver espacios libres                    ║");
        System.out.println("║  0. Salir                                  ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    // ============================================================
    // MÉTODO: añadirContacto
    // Solicita datos al usuario y añade un contacto a la agenda
    // ============================================================

    private static void añadirContacto(Scanner scanner, Agenda agenda) {
        System.out.println("\n--- AÑADIR NUEVO CONTACTO ---");

        // Solicitamos el nombre
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();  // nextLine() lee toda la línea de texto

        // Solicitamos el apellido
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        // Solicitamos el teléfono
        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();

        // Creamos un nuevo objeto Contacto con los datos ingresados
        Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);

        // Intentamos añadir el contacto a la agenda
        // El método añadirContacto() ya muestra los mensajes correspondientes
        agenda.añadirContacto(nuevoContacto);
    }

    // ============================================================
    // MÉTODO: verificarExisteContacto
    // Verifica si un contacto existe en la agenda
    // ============================================================

    private static void verificarExisteContacto(Scanner scanner, Agenda agenda) {
        System.out.println("\n--- VERIFICAR SI EXISTE CONTACTO ---");

        // Solicitamos nombre y apellido para buscar
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        // Creamos un contacto temporal para la búsqueda
        // El teléfono no importa para la comparación (usamos cadena vacía)
        Contacto contactoBuscar = new Contacto(nombre, apellido, "");

        // Verificamos si existe
        if (agenda.existeContacto(contactoBuscar)) {
            System.out.println("✓ El contacto " + nombre + " " + apellido + " SÍ existe en la agenda.");
        } else {
            System.out.println("✗ El contacto " + nombre + " " + apellido + " NO existe en la agenda.");
        }
    }

    // ============================================================
    // MÉTODO: buscarContacto
    // Busca un contacto y muestra su información
    // ============================================================

    private static void buscarContacto(Scanner scanner, Agenda agenda) {
        System.out.println("\n--- BUSCAR CONTACTO ---");

        // Solicitamos nombre y apellido
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        // Llamamos al método de búsqueda de la agenda
        // Este método ya muestra el resultado
        agenda.buscaContacto(nombre, apellido);
    }

    // ============================================================
    // MÉTODO: eliminarContacto
    // Elimina un contacto de la agenda
    // ============================================================

    private static void eliminarContacto(Scanner scanner, Agenda agenda) {
        System.out.println("\n--- ELIMINAR CONTACTO ---");

        // Solicitamos nombre y apellido del contacto a eliminar
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        // Creamos un contacto temporal para la eliminación
        Contacto contactoEliminar = new Contacto(nombre, apellido, "");

        // Intentamos eliminar el contacto
        // El método eliminarContacto() ya muestra los mensajes
        agenda.eliminarContacto(contactoEliminar);
    }

    // ============================================================
    // MÉTODO: modificarTelefono
    // Modifica el teléfono de un contacto existente
    // ============================================================

    private static void modificarTelefono(Scanner scanner, Agenda agenda) {
        System.out.println("\n--- MODIFICAR TELÉFONO ---");

        // Solicitamos los datos para identificar al contacto
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del contacto: ");
        String apellido = scanner.nextLine();

        // Solicitamos el nuevo teléfono
        System.out.print("Ingrese el nuevo teléfono: ");
        String nuevoTelefono = scanner.nextLine();

        // Llamamos al método de modificación
        // El método ya muestra los mensajes correspondientes
        agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
    }
}
