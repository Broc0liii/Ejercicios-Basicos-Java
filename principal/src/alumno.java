public class alumno {
    String nombre;
    int edad;
    int nua;

    String imprimir(){
        return String.format("%d %s %d\n", nua, nombre, edad);
    }
}
