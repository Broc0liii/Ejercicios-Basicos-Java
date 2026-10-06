import java.util.ArrayList;

public class GestorAlumnos {
    private ArrayList<Alumno> listaAlumnos;

    public GestorAlumnos() {
        this.listaAlumnos = new ArrayList<>();
    }

    public void agregarAlumno(Alumno nuevoAlumno){

        listaAlumnos.add(nuevoAlumno);

    }
}
