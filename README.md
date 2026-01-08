# 📱 Sistema de Agenda Telefónica en Java

## 📋 Descripción del Proyecto

Este proyecto implementa una agenda telefónica completa en Java, diseñada para aprender los conceptos fundamentales de la Programación Orientada a Objetos (POO).

---

## 📁 Estructura del Proyecto

```
📁 AgendaTelefonica/
   ├── Contacto.java      (Define qué es un contacto)
   ├── Agenda.java        (Gestiona los contactos)
   ├── Main.java          (Menú y programa principal)
   └── README.md          (Este archivo)
```

---

## 📚 Conceptos Fundamentales Cubiertos

| Concepto | Descripción | Dónde lo ves |
|----------|-------------|--------------|
| **Clases y Objetos** | Una clase es un molde, un objeto es la instancia | `Contacto`, `Agenda` |
| **Atributos** | Variables que pertenecen a un objeto | `nombre`, `apellido`, `telefono` |
| **Encapsulamiento** | Usar `private` para proteger datos | Todos los atributos |
| **Constructores** | Métodos especiales para crear objetos | `Contacto()`, `Agenda()` |
| **Getters/Setters** | Métodos para acceder a atributos privados | `getNombre()`, `setTelefono()` |
| **Sobrecarga** | Dos constructores con diferentes parámetros | `Agenda(int)` y `Agenda()` |
| **Arrays** | Colecciones de tamaño fijo | `Contacto[] contactos` |
| **Bucles** | `for`, `while` para repetir código | Ordenamiento, búsquedas |
| **Condicionales** | `if-else`, `switch` para decisiones | Menú, validaciones |
| **Métodos** | Bloques de código reutilizable | Todas las funciones |

---

## 🚀 Cómo Compilar y Ejecutar

```bash
# 1. Navega a la carpeta del proyecto
cd AgendaTelefonica

# 2. Compila todos los archivos
javac *.java

# 3. Ejecuta el programa
java Main
```

---

## 💡 Flujo del Programa

```
┌─────────────────┐
│   Inicio        │
└────────┬────────┘
         ▼
┌─────────────────┐
│ Crear Agenda    │ ← Elige tamaño personalizado o por defecto
└────────┬────────┘
         ▼
┌─────────────────┐
│ Mostrar Menú    │◄──────────────────┐
└────────┬────────┘                   │
         ▼                            │
┌─────────────────┐                   │
│ Leer Opción     │                   │
└────────┬────────┘                   │
         ▼                            │
┌─────────────────┐    (opción ≠ 0)   │
│ Ejecutar Acción │───────────────────┘
└────────┬────────┘
         ▼ (opción = 0)
┌─────────────────┐
│     Fin         │
└─────────────────┘
```

---

## 📖 Descripción de las Clases

### 1. Clase `Contacto`

Representa un contacto individual con sus datos personales.

#### Atributos:
- `nombre` (String): Nombre del contacto
- `apellido` (String): Apellido del contacto
- `telefono` (String): Número de teléfono

#### Métodos principales:
| Método | Descripción |
|--------|-------------|
| `Contacto(nombre, apellido, telefono)` | Constructor que inicializa el contacto |
| `getNombre()` | Devuelve el nombre |
| `getApellido()` | Devuelve el apellido |
| `getTelefono()` | Devuelve el teléfono |
| `setTelefono(telefono)` | Modifica el teléfono |
| `esIgual(Contacto otro)` | Compara si dos contactos son iguales |
| `esValido()` | Verifica que nombre y apellido no estén vacíos |
| `toString()` | Devuelve el contacto en formato texto |

---

### 2. Clase `Agenda`

Gestiona la colección de contactos.

#### Atributos:
- `contactos` (Contacto[]): Array que almacena los contactos
- `numContactos` (int): Contador de contactos actuales
- `TAMANIO_POR_DEFECTO` (int): Constante con valor 10

#### Métodos principales:
| Método | Descripción |
|--------|-------------|
| `Agenda(tamanioMaximo)` | Crea agenda con tamaño personalizado |
| `Agenda()` | Crea agenda con tamaño por defecto (10) |
| `añadirContacto(Contacto c)` | Añade un contacto a la agenda |
| `existeContacto(Contacto c)` | Verifica si un contacto existe |
| `listarContactos()` | Muestra todos los contactos ordenados |
| `buscaContacto(nombre, apellido)` | Busca un contacto específico |
| `eliminarContacto(Contacto c)` | Elimina un contacto |
| `modificarTelefono(nombre, apellido, nuevoTelefono)` | Cambia el teléfono |
| `agendaLlena()` | Indica si la agenda está llena |
| `espaciosLibres()` | Devuelve cuántos espacios quedan |

---

### 3. Clase `Main`

Contiene el programa principal y el menú interactivo.

#### Menú de Opciones:
```
╔════════════════════════════════════════════╗
║            MENÚ DE OPCIONES                ║
╠════════════════════════════════════════════╣
║  1. Añadir contacto                        ║
║  2. Verificar si existe un contacto        ║
║  3. Listar todos los contactos             ║
║  4. Buscar contacto por nombre y apellido  ║
║  5. Eliminar contacto                      ║
║  6. Modificar teléfono de un contacto      ║
║  7. Verificar si la agenda está llena      ║
║  8. Ver espacios libres                    ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

---

## 🔍 Validaciones Implementadas

1. **Nombre y apellido no vacíos**: No se pueden añadir contactos con campos vacíos
2. **Sin duplicados**: No se permiten dos contactos con mismo nombre y apellido
3. **Agenda llena**: Se notifica cuando no hay espacio disponible
4. **Contacto no encontrado**: Se informa cuando se busca/elimina un contacto inexistente

---

## 📝 Ejemplo de Uso

```
╔════════════════════════════════════════════╗
║     BIENVENIDO A LA AGENDA TELEFÓNICA      ║
╚════════════════════════════════════════════╝

¿Cómo desea crear la agenda?
1. Con tamaño personalizado
2. Con tamaño por defecto (10 contactos)
Seleccione una opción: 2

Agenda creada con tamaño por defecto (10 contactos).

Seleccione una opción: 1

--- AÑADIR NUEVO CONTACTO ---
Ingrese el nombre: Juan
Ingrese el apellido: Pérez
Ingrese el teléfono: 123456789
Contacto añadido correctamente.

Seleccione una opción: 3

===== LISTA DE CONTACTOS =====
1. Juan Pérez - 123456789
==============================
```

---

## 🎯 Diagrama de Clases (UML Simplificado)

```
┌─────────────────────────────────────┐
│            Contacto                 │
├─────────────────────────────────────┤
│ - nombre: String                    │
│ - apellido: String                  │
│ - telefono: String                  │
├─────────────────────────────────────┤
│ + Contacto(nombre, apellido, tel)   │
│ + getNombre(): String               │
│ + getApellido(): String             │
│ + getTelefono(): String             │
│ + setTelefono(telefono): void       │
│ + esIgual(otro: Contacto): boolean  │
│ + esValido(): boolean               │
│ + toString(): String                │
└─────────────────────────────────────┘
              ▲
              │ usa
              │
┌─────────────────────────────────────┐
│             Agenda                  │
├─────────────────────────────────────┤
│ - contactos: Contacto[]             │
│ - numContactos: int                 │
│ - TAMANIO_POR_DEFECTO: int = 10     │
├─────────────────────────────────────┤
│ + Agenda()                          │
│ + Agenda(tamanioMaximo: int)        │
│ + añadirContacto(c: Contacto): bool │
│ + existeContacto(c: Contacto): bool │
│ + listarContactos(): void           │
│ + buscaContacto(nom, ape): void     │
│ + eliminarContacto(c): boolean      │
│ + modificarTelefono(...): boolean   │
│ + agendaLlena(): boolean            │
│ + espaciosLibres(): int             │
└─────────────────────────────────────┘
              ▲
              │ usa
              │
┌─────────────────────────────────────┐
│              Main                   │
├─────────────────────────────────────┤
│ + main(args: String[]): void        │
│ - mostrarMenu(): void               │
│ - añadirContacto(...): void         │
│ - buscarContacto(...): void         │
│ - eliminarContacto(...): void       │
│ - modificarTelefono(...): void      │
└─────────────────────────────────────┘
```

---

## 📌 Notas Importantes

- Los comentarios en el código explican cada línea para facilitar el aprendizaje
- El algoritmo de ordenamiento usado es **Bubble Sort** (burbuja)
- La comparación de contactos ignora mayúsculas/minúsculas
- Se usa `Scanner` para la entrada de datos por teclado

---

## ✨ Mejoras Futuras Sugeridas

1. Persistencia de datos (guardar en archivo)
2. Búsqueda parcial por nombre
3. Validación del formato de teléfono
4. Uso de `ArrayList` en lugar de arrays
5. Interfaz gráfica (GUI)

---

## 👨‍💻 Autor

Proyecto creado con fines educativos para aprender Java desde cero.
