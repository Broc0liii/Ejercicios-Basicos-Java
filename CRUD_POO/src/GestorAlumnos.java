import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorAlumnos {
    private final List<Alumno> listaAlumnos;

    public GestorAlumnos() {
        this.listaAlumnos = new ArrayList<>();
    }

    // CREATE: Registrar un nuevo alumno
    public boolean agregarAlumno(Alumno alumno) {
        if (buscarPorNua(alumno.getNua()).isPresent()) {
            return false; // El NUA ya existe
        }
        return listaAlumnos.add(alumno);
    }

    // READ: Buscar alumno por NUA
    public Optional<Alumno> buscarPorNua(String nua) {
        return listaAlumnos.stream()
                .filter(a -> a.getNua().equalsIgnoreCase(nua.trim()))
                .findFirst();
    }

    // READ: Obtener lista completa de alumnos
    public List<Alumno> obtenerTodos() {
        return new ArrayList<>(listaAlumnos);
    }

    // UPDATE: Actualizar datos de un alumno
    public boolean actualizarAlumno(String nua, String nuevoNombre, int nuevaEdad, String nuevaCarrera, String nuevoEstatus) {
        Optional<Alumno> optAlumno = buscarPorNua(nua);
        if (optAlumno.isPresent()) {
            Alumno alumno = optAlumno.get();
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) alumno.setNombreCompleto(nuevoNombre);
            if (nuevaEdad > 0) alumno.setEdad(nuevaEdad);
            if (nuevaCarrera != null && !nuevaCarrera.trim().isEmpty()) alumno.setCarrera(nuevaCarrera);
            if (nuevoEstatus != null && !nuevoEstatus.trim().isEmpty()) alumno.setEstatus(nuevoEstatus);
            return true;
        }
        return false;
    }

    // DELETE (Baja física): Eliminar alumno del sistema por NUA
    public boolean eliminarAlumno(String nua) {
        return listaAlumnos.removeIf(a -> a.getNua().equalsIgnoreCase(nua.trim()));
    }

    // DELETE / UPDATE (Baja lógica): Cambiar el estatus del alumno (ej. a "Inactivo" o "Baja")
    public boolean cambiarEstatusAlumno(String nua, String nuevoEstatus) {
        Optional<Alumno> optAlumno = buscarPorNua(nua);
        if (optAlumno.isPresent()) {
            optAlumno.get().setEstatus(nuevoEstatus);
            return true;
        }
        return false;
    }
}
