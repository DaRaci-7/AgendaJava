// ============================================================
// CLASE CONTACTO
// Esta clase representa un contacto individual de la agenda
// ============================================================

// La palabra "public" significa que esta clase puede ser usada desde otros archivos
// La palabra "class" indica que estamos definiendo una clase (plantilla para crear objetos)
// "Contacto" es el nombre de nuestra clase
public class Contacto {

    // ============================================================
    // ATRIBUTOS (características que tiene cada contacto)
    // ============================================================

    // "private" significa que estos datos solo pueden accederse desde dentro de esta clase
    // Esto se llama "encapsulamiento" y protege los datos
    // "String" es el tipo de dato para almacenar texto

    private String nombre;    // Almacena el nombre del contacto
    private String apellido;  // Almacena el apellido del contacto
    private String telefono;  // Almacena el teléfono del contacto

    // ============================================================
    // CONSTRUCTOR
    // Es un método especial que se ejecuta cuando creamos un nuevo contacto
    // Tiene el mismo nombre que la clase y NO tiene tipo de retorno
    // ============================================================

    // Los parámetros (nombre, apellido, telefono) son los datos que recibimos al crear el contacto
    public Contacto(String nombre, String apellido, String telefono) {
        // "this" hace referencia al objeto actual (el contacto que estamos creando)
        // this.nombre = el atributo de la clase
        // nombre = el parámetro que recibimos
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // ============================================================
    // GETTERS (métodos para OBTENER los valores de los atributos)
    // Como los atributos son "private", necesitamos estos métodos
    // para poder leer sus valores desde otras clases
    // ============================================================

    // Método que devuelve el nombre del contacto
    // "public" = puede llamarse desde otras clases
    // "String" = el tipo de dato que devuelve
    // "getNombre" = nombre del método (convención: get + NombreAtributo)
    public String getNombre() {
        return nombre;  // "return" devuelve el valor al código que llamó este método
    }

    // Método que devuelve el apellido del contacto
    public String getApellido() {
        return apellido;
    }

    // Método que devuelve el teléfono del contacto
    public String getTelefono() {
        return telefono;
    }

    // ============================================================
    // SETTERS (métodos para MODIFICAR los valores de los atributos)
    // Permiten cambiar los valores de forma controlada
    // ============================================================

    // Método para cambiar el nombre
    // "void" significa que este método NO devuelve ningún valor
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para cambiar el apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Método para cambiar el teléfono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // ============================================================
    // MÉTODO EQUALS (para comparar si dos contactos son iguales)
    // Dos contactos son iguales si tienen el mismo nombre y apellido
    // (sin importar mayúsculas/minúsculas)
    // ============================================================

    // Este método compara el contacto actual (this) con otro contacto (otro)
    // Devuelve "true" si son iguales, "false" si son diferentes
    public boolean esIgual(Contacto otro) {
        // Primero verificamos que el otro contacto no sea null (no exista)
        // "==" compara si son exactamente el mismo objeto en memoria
        if (otro == null) {
            return false;  // Si es null, no pueden ser iguales
        }

        // equalsIgnoreCase() compara dos Strings ignorando mayúsculas/minúsculas
        // "&&" es el operador AND (Y lógico) - ambas condiciones deben ser true
        // Comparamos nombre con nombre Y apellido con apellido
        return this.nombre.equalsIgnoreCase(otro.nombre) &&
                this.apellido.equalsIgnoreCase(otro.apellido);
    }

    // ============================================================
    // MÉTODO PARA VALIDAR QUE NOMBRE Y APELLIDO NO ESTÉN VACÍOS
    // ============================================================

    // Devuelve true si el contacto tiene datos válidos
    public boolean esValido() {
        // Verificamos que nombre y apellido no sean null Y no estén vacíos
        // "!=" significa "diferente de"
        // trim() elimina espacios al inicio y final del texto
        // isEmpty() devuelve true si el String está vacío ""
        // "!" es el operador NOT (negación) - invierte el valor booleano

        // El contacto es válido si:
        // - nombre no es null Y nombre (sin espacios) no está vacío
        // - Y apellido no es null Y apellido (sin espacios) no está vacío
        return nombre != null && !nombre.trim().isEmpty() &&
                apellido != null && !apellido.trim().isEmpty();
    }

    // ============================================================
    // MÉTODO TOSTRING (para convertir el contacto a texto)
    // Se usa cuando queremos mostrar el contacto en pantalla
    // ============================================================

    // @Override indica que estamos reemplazando un método de la clase padre (Object)
    @Override
    public String toString() {
        // Devolvemos el formato: "Nombre Apellido - Teléfono"
        return nombre + " " + apellido + " - " + telefono;
    }

    // ============================================================
    // MÉTODO PARA OBTENER NOMBRE COMPLETO (útil para ordenar)
    // ============================================================

    public String getNombreCompleto() {
        // Concatenamos nombre y apellido en minúsculas para ordenar
        // toLowerCase() convierte todo el texto a minúsculas
        return (nombre + " " + apellido).toLowerCase();
    }
}