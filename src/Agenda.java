// ============================================================
// CLASE AGENDA
// Esta clase gestiona una colección de contactos
// Permite añadir, buscar, eliminar y modificar contactos
// ============================================================

// La palabra "class" define una nueva clase llamada "Agenda"
public class Agenda {

    // ============================================================
    // ATRIBUTOS DE LA AGENDA
    // ============================================================

    // Array (arreglo) que almacena los contactos
    // Un array es como una lista de tamaño fijo
    // Contacto[] significa "array de objetos tipo Contacto"
    private Contacto[] contactos;

    // Contador que indica cuántos contactos hay actualmente en la agenda
    // "int" es el tipo de dato para números enteros
    private int numContactos;

    // Constante que define el tamaño por defecto de la agenda
    // "static" significa que pertenece a la clase, no a cada objeto
    // "final" significa que su valor no puede cambiar (es constante)
    private static final int TAMANIO_POR_DEFECTO = 10;

    // ============================================================
    // CONSTRUCTORES (dos formas de crear una agenda)
    // ============================================================

    // Constructor 1: Crea una agenda con tamaño personalizado
    // El parámetro "tamanioMaximo" indica cuántos contactos puede almacenar
    public Agenda(int tamanioMaximo) {
        // Creamos el array con el tamaño indicado
        // "new" reserva espacio en memoria para el array
        contactos = new Contacto[tamanioMaximo];

        // Al inicio, la agenda está vacía (0 contactos)
        numContactos = 0;
    }

    // Constructor 2: Crea una agenda con el tamaño por defecto (10 contactos)
    // Este constructor no recibe parámetros
    public Agenda() {
        // "this()" llama al otro constructor de esta misma clase
        // Le pasamos la constante TAMANIO_POR_DEFECTO (que vale 10)
        this(TAMANIO_POR_DEFECTO);
    }

    // ============================================================
    // MÉTODO: añadirContacto
    // Añade un nuevo contacto a la agenda
    // Devuelve true si se añadió correctamente, false si no
    // ============================================================

    public boolean añadirContacto(Contacto c) {
        // VALIDACIÓN 1: Verificar que el contacto no sea null
        if (c == null) {
            // Mostramos mensaje de error
            System.out.println("Error: El contacto no puede ser nulo.");
            return false;  // Terminamos el método devolviendo false
        }

        // VALIDACIÓN 2: Verificar que nombre y apellido no estén vacíos
        // Llamamos al método esValido() de la clase Contacto
        if (!c.esValido()) {
            System.out.println("Error: El nombre y apellido no pueden estar vacíos.");
            return false;
        }

        // VALIDACIÓN 3: Verificar que la agenda no esté llena
        if (agendaLlena()) {
            System.out.println("Error: La agenda está llena. No se pueden añadir más contactos.");
            return false;
        }

        // VALIDACIÓN 4: Verificar que no exista un contacto duplicado
        if (existeContacto(c)) {
            System.out.println("Error: Ya existe un contacto con ese nombre y apellido.");
            return false;
        }

        // Si pasamos todas las validaciones, añadimos el contacto
        // Lo guardamos en la posición indicada por numContactos
        // (las posiciones del array empiezan en 0)
        contactos[numContactos] = c;

        // Incrementamos el contador de contactos
        // "++" suma 1 al valor de numContactos
        numContactos++;

        // Mostramos mensaje de éxito
        System.out.println("Contacto añadido correctamente.");

        // Devolvemos true para indicar que todo salió bien
        return true;
    }

    // ============================================================
    // MÉTODO: existeContacto
    // Verifica si un contacto ya existe en la agenda
    // Devuelve true si existe, false si no existe
    // ============================================================

    public boolean existeContacto(Contacto c) {
        // Verificamos que el contacto a buscar no sea null
        if (c == null) {
            return false;
        }

        // Recorremos todos los contactos de la agenda
        // "for" es un bucle que se repite un número determinado de veces
        // int i = 0: empezamos en la posición 0
        // i < numContactos: seguimos mientras i sea menor que el número de contactos
        // i++: después de cada vuelta, sumamos 1 a i
        for (int i = 0; i < numContactos; i++) {
            // Comparamos el contacto actual con el que buscamos
            // usando el método esIgual() de la clase Contacto
            if (contactos[i].esIgual(c)) {
                return true;  // Lo encontramos, devolvemos true
            }
        }

        // Si el bucle termina sin encontrarlo, devolvemos false
        return false;
    }

    // ============================================================
    // MÉTODO: listarContactos
    // Muestra todos los contactos ordenados alfabéticamente
    // ============================================================

    public void listarContactos() {
        // Verificamos si la agenda está vacía
        if (numContactos == 0) {
            System.out.println("La agenda está vacía.");
            return;  // "return" sin valor termina el método (porque es void)
        }

        // Creamos una copia del array para ordenar sin modificar el original
        // Esto es importante para mantener el orden de inserción original
        Contacto[] copiaContactos = new Contacto[numContactos];

        // Copiamos los contactos al nuevo array
        for (int i = 0; i < numContactos; i++) {
            copiaContactos[i] = contactos[i];
        }

        // ORDENAMIENTO BURBUJA (Bubble Sort)
        // Es un algoritmo simple para ordenar elementos
        // Compara elementos adyacentes y los intercambia si están desordenados

        // Bucle externo: controla las pasadas por el array
        for (int i = 0; i < copiaContactos.length - 1; i++) {
            // Bucle interno: compara elementos adyacentes
            for (int j = 0; j < copiaContactos.length - 1 - i; j++) {
                // Obtenemos los nombres completos para comparar
                String nombre1 = copiaContactos[j].getNombreCompleto();
                String nombre2 = copiaContactos[j + 1].getNombreCompleto();

                // compareTo() compara dos Strings alfabéticamente
                // Devuelve: positivo si nombre1 > nombre2
                //           negativo si nombre1 < nombre2
                //           0 si son iguales
                if (nombre1.compareTo(nombre2) > 0) {
                    // Intercambiamos los contactos (están desordenados)
                    // Usamos una variable temporal para no perder datos
                    Contacto temporal = copiaContactos[j];
                    copiaContactos[j] = copiaContactos[j + 1];
                    copiaContactos[j + 1] = temporal;
                }
            }
        }

        // Mostramos los contactos ordenados
        System.out.println("\n===== LISTA DE CONTACTOS =====");

        // Recorremos y mostramos cada contacto
        for (int i = 0; i < copiaContactos.length; i++) {
            // toString() se llama automáticamente al imprimir un objeto
            System.out.println((i + 1) + ". " + copiaContactos[i]);
        }

        System.out.println("==============================\n");
    }

    // ============================================================
    // MÉTODO: buscaContacto
    // Busca un contacto por nombre y apellido
    // Si lo encuentra, muestra el teléfono
    // ============================================================

    public void buscaContacto(String nombre, String apellido) {
        // Recorremos todos los contactos
        for (int i = 0; i < numContactos; i++) {
            // Comparamos nombre y apellido (ignorando mayúsculas/minúsculas)
            // Usamos el operador && (AND) para que ambas condiciones sean true
            if (contactos[i].getNombre().equalsIgnoreCase(nombre) &&
                    contactos[i].getApellido().equalsIgnoreCase(apellido)) {

                // Encontramos el contacto, mostramos su información
                System.out.println("Contacto encontrado:");
                System.out.println("Nombre: " + contactos[i].getNombre());
                System.out.println("Apellido: " + contactos[i].getApellido());
                System.out.println("Teléfono: " + contactos[i].getTelefono());
                return;  // Terminamos el método porque ya lo encontramos
            }
        }

        // Si llegamos aquí, no se encontró el contacto
        System.out.println("No se ha encontrado ningún contacto con ese nombre y apellido.");
    }

    // ============================================================
    // MÉTODO: eliminarContacto
    // Elimina un contacto de la agenda
    // Devuelve true si se eliminó, false si no existía
    // ============================================================

    public boolean eliminarContacto(Contacto c) {
        // Verificamos que el contacto no sea null
        if (c == null) {
            System.out.println("Error: El contacto no puede ser nulo.");
            return false;
        }

        // Buscamos el contacto en la agenda
        for (int i = 0; i < numContactos; i++) {
            // Si encontramos el contacto
            if (contactos[i].esIgual(c)) {
                // Desplazamos todos los contactos siguientes una posición hacia atrás
                // Esto "rellena el hueco" que deja el contacto eliminado
                for (int j = i; j < numContactos - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }

                // La última posición ocupada ahora está duplicada
                // La ponemos a null para liberar la referencia
                contactos[numContactos - 1] = null;

                // Decrementamos el contador de contactos
                // "--" resta 1 al valor de numContactos
                numContactos--;

                System.out.println("Contacto eliminado correctamente.");
                return true;
            }
        }

        // Si llegamos aquí, el contacto no existía
        System.out.println("Error: No se encontró el contacto a eliminar.");
        return false;
    }

    // ============================================================
    // MÉTODO: modificarTelefono
    // Modifica el teléfono de un contacto existente
    // ============================================================

    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        // Recorremos todos los contactos buscando coincidencia
        for (int i = 0; i < numContactos; i++) {
            // Comparamos nombre y apellido
            if (contactos[i].getNombre().equalsIgnoreCase(nombre) &&
                    contactos[i].getApellido().equalsIgnoreCase(apellido)) {

                // Encontramos el contacto, modificamos su teléfono
                // Usamos el setter setTelefono() para cambiar el valor
                contactos[i].setTelefono(nuevoTelefono);

                System.out.println("Teléfono modificado correctamente.");
                System.out.println("Nuevo teléfono de " + nombre + " " + apellido + ": " + nuevoTelefono);
                return true;
            }
        }

        // Si no se encontró el contacto
        System.out.println("Error: No se encontró ningún contacto con ese nombre y apellido.");
        return false;
    }

    // ============================================================
    // MÉTODO: agendaLlena
    // Indica si la agenda está llena
    // Devuelve true si está llena, false si hay espacio
    // ============================================================

    public boolean agendaLlena() {
        // La agenda está llena cuando el número de contactos
        // es igual al tamaño del array
        // contactos.length devuelve el tamaño total del array
        return numContactos >= contactos.length;
    }

    // ============================================================
    // MÉTODO: espaciosLibres
    // Devuelve cuántos contactos más se pueden agregar
    // ============================================================

    public int espaciosLibres() {
        // Restamos el número actual de contactos del tamaño máximo
        return contactos.length - numContactos;
    }

    // ============================================================
    // MÉTODO: mostrarEspaciosLibres
    // Muestra en pantalla la información de espacio disponible
    // ============================================================

    public void mostrarEspaciosLibres() {
        // Obtenemos los espacios libres
        int libres = espaciosLibres();

        // Mostramos la información
        System.out.println("\n===== INFORMACIÓN DE LA AGENDA =====");
        System.out.println("Tamaño máximo de la agenda: " + contactos.length);
        System.out.println("Contactos actuales: " + numContactos);
        System.out.println("Espacios libres: " + libres);

        // Verificamos si está llena
        if (agendaLlena()) {
            System.out.println("⚠ La agenda está llena. No hay espacio para nuevos contactos.");
        } else {
            System.out.println("✓ Puedes agregar " + libres + " contacto(s) más.");
        }

        System.out.println("=====================================\n");
    }

    // ============================================================
    // MÉTODO: obtenerNumeroContactos
    // Devuelve el número actual de contactos (útil para el menú)
    // ============================================================

    public int obtenerNumeroContactos() {
        return numContactos;
    }
}