import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final GestorAlumnos gestor = new GestorAlumnos();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cargar algunos datos iniciales de prueba
        cargarDatosPrueba();

        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    registrarAlumno();
                    break;
                case "2":
                    menuConsultas();
                    break;
                case "3":
                    actualizarAlumno();
                    break;
                case "4":
                    menuBajas();
                    break;
                case "5":
                    System.out.println("\n--- LISTA COMPLETA DE ALUMNOS ---");
                    mostrarLista(gestor.obtenerTodos());
                    break;
                case "6":
                    salir = true;
                    System.out.println("\n¡Gracias por usar el sistema CRUD de Alumnos UG!");
                    break;
                default:
                    System.out.println("\n[!] Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n============================================");
        System.out.println("     SISTEMA DE GESTIÓN DE ALUMNOS (CRUD)   ");
        System.out.println("============================================");
        System.out.println("1. Alta de Alumno (Registrar)");
        System.out.println("2. Consulta de Alumno(s)");
        System.out.println("3. Actualizar Datos de Alumno");
        System.out.println("4. Baja de Alumno");
        System.out.println("5. Mostrar Todos los Alumnos");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarAlumno() {
        System.out.println("\n--- ALTA DE ALUMNO ---");

        String nua;
        while (true) {
            System.out.print("Ingrese NUA (Código de estudiante): ");
            nua = scanner.nextLine().trim();
            if (nua.isEmpty()) {
                System.out.println("[!] El NUA no puede estar vacío.");
                continue;
            }
            if (gestor.buscarPorNua(nua).isPresent()) {
                System.out.println("[!] El NUA '" + nua + "' ya se encuentra registrado. Intente con otro.");
                return;
            }
            break;
        }

        System.out.print("Ingrese Nombre Completo: ");
        String nombreCompleto = scanner.nextLine().trim();

        int edad = pedirEnteroPositivo("Ingrese Edad: ");

        System.out.print("Ingrese Carrera: ");
        String carrera = scanner.nextLine().trim();

        System.out.println("Seleccione Estatus inicial:");
        System.out.println("1. Activo");
        System.out.println("2. Inactivo");
        System.out.println("3. Baja Temporal");
        System.out.print("Opción (por defecto 1): ");
        String opcEstatus = scanner.nextLine().trim();
        String estatus = "Activo";
        if (opcEstatus.equals("2")) estatus = "Inactivo";
        else if (opcEstatus.equals("3")) estatus = "Baja Temporal";

        Alumno nuevo = new Alumno(nua, nombreCompleto, edad, carrera, estatus);
        if (gestor.agregarAlumno(nuevo)) {
            System.out.println("\n[✓] Alumno registrado exitosamente con NUA: " + nua);
        } else {
            System.out.println("\n[!] Error al registrar el alumno.");
        }
    }

    private static void menuConsultas() {
        System.out.println("\n--- CONSULTA DE ALUMNOS ---");
        System.out.println("1. Buscar por NUA");
        System.out.println("2. Listar todos los Alumnos");
        System.out.print("Seleccione una opción: ");
        String opc = scanner.nextLine().trim();

        if (opc.equals("1")) {
            System.out.print("Ingrese el NUA a buscar: ");
            String nua = scanner.nextLine().trim();
            Optional<Alumno> res = gestor.buscarPorNua(nua);
            if (res.isPresent()) {
                System.out.println("\n[✓] Alumno encontrado:");
                System.out.println(res.get());
            } else {
                System.out.println("\n[!] No se encontró ningún alumno con NUA: " + nua);
            }
        } else if (opc.equals("2")) {
            mostrarLista(gestor.obtenerTodos());
        } else {
            System.out.println("[!] Opción inválida.");
        }
    }

    private static void actualizarAlumno() {
        System.out.println("\n--- ACTUALIZACIÓN DE ALUMNO ---");
        System.out.print("Ingrese el NUA del alumno a modificar: ");
        String nua = scanner.nextLine().trim();

        Optional<Alumno> res = gestor.buscarPorNua(nua);
        if (res.isEmpty()) {
            System.out.println("[!] No existe un alumno registrado con NUA: " + nua);
            return;
        }

        Alumno actual = res.get();
        System.out.println("Datos actuales -> " + actual);
        System.out.println("(Deje en blanco y presione ENTER para conservar el valor actual)");

        System.out.print("Nuevo Nombre Completo [" + actual.getNombreCompleto() + "]: ");
        String nuevoNombre = scanner.nextLine().trim();

        System.out.print("Nueva Edad [" + actual.getEdad() + "]: ");
        String edadStr = scanner.nextLine().trim();
        int nuevaEdad = actual.getEdad();
        if (!edadStr.isEmpty()) {
            try {
                nuevaEdad = Integer.parseInt(edadStr);
            } catch (NumberFormatException e) {
                System.out.println("[!] Edad inválida. Se conserva el valor anterior.");
            }
        }

        System.out.print("Nueva Carrera [" + actual.getCarrera() + "]: ");
        String nuevaCarrera = scanner.nextLine().trim();

        System.out.print("Nuevo Estatus (Activo/Inactivo/Baja Temporal/Baja Definitiva) [" + actual.getEstatus() + "]: ");
        String nuevoEstatus = scanner.nextLine().trim();

        boolean exito = gestor.actualizarAlumno(nua, nuevoNombre, nuevaEdad, nuevaCarrera, nuevoEstatus);
        if (exito) {
            System.out.println("\n[✓] Datos del alumno actualizados correctamente.");
            System.out.println("Nuevo estado -> " + gestor.buscarPorNua(nua).get());
        } else {
            System.out.println("\n[!] No se pudo actualizar la información.");
        }
    }

    private static void menuBajas() {
        System.out.println("\n--- BAJA DE ALUMNO ---");
        System.out.print("Ingrese el NUA del alumno: ");
        String nua = scanner.nextLine().trim();

        Optional<Alumno> res = gestor.buscarPorNua(nua);
        if (res.isEmpty()) {
            System.out.println("[!] No se encontró ningún alumno registrado con NUA: " + nua);
            return;
        }

        System.out.println("Alumno seleccionado: " + res.get());
        System.out.println("Tipo de baja:");
        System.out.println("1. Baja Lógica (Cambiar estatus a 'Baja Definitiva' o 'Inactivo')");
        System.out.println("2. Baja Física (Eliminar permanentemente del registro)");
        System.out.print("Seleccione una opción: ");
        String opc = scanner.nextLine().trim();

        if (opc.equals("1")) {
            System.out.print("Ingrese nuevo estatus (ej. 'Inactivo', 'Baja Definitiva'): ");
            String nuevoEstatus = scanner.nextLine().trim();
            if (nuevoEstatus.isEmpty()) nuevoEstatus = "Baja Definitiva";

            if (gestor.cambiarEstatusAlumno(nua, nuevoEstatus)) {
                System.out.println("\n[✓] Baja lógica realizada con éxito. Estatus actualizado a: " + nuevoEstatus);
            }
        } else if (opc.equals("2")) {
            System.out.print("¿Está seguro de eliminar definitivamente al alumno? (s/n): ");
            String confirmacion = scanner.nextLine().trim();
            if (confirmacion.equalsIgnoreCase("s")) {
                if (gestor.eliminarAlumno(nua)) {
                    System.out.println("\n[✓] El alumno con NUA " + nua + " ha sido eliminado permanentemente.");
                } else {
                    System.out.println("\n[!] No se pudo eliminar el registro.");
                }
            } else {
                System.out.println("\n[i] Operación cancelada.");
            }
        } else {
            System.out.println("[!] Opción no válida.");
        }
    }

    private static void mostrarLista(List<Alumno> alumnos) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Total de registros: " + alumnos.size());
    }

    private static int pedirEnteroPositivo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(input);
                if (val > 0) return val;
                System.out.println("[!] La edad debe ser un número mayor a 0.");
            } catch (NumberFormatException e) {
                System.out.println("[!] Entrada inválida. Ingrese un número entero.");
            }
        }
    }

    private static void cargarDatosPrueba() {
        gestor.agregarAlumno(new Alumno("415263", "Carlos Eduardo Delgado", 21, "Ing. Sistemas Computacionales", "Activo"));
        gestor.agregarAlumno(new Alumno("409812", "Ana María Ramírez", 20, "Lic. en Matemáticas", "Activo"));
        gestor.agregarAlumno(new Alumno("398124", "Luis Fernando Gómez", 22, "Ing. Software", "Baja Temporal"));
    }
}
