public class Alumno {
    private String nua;
    private String nombreCompleto;
    private int edad;
    private String carrera;
    private String estatus; // e.g., "Activo", "Inactivo", "Baja Temporal", "Baja Definitiva"

    // Constructor completo
    public Alumno(String nua, String nombreCompleto, int edad, String carrera, String estatus) {
        this.nua = nua;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.carrera = carrera;
        this.estatus = estatus;
    }

    // Getters y Setters
    public String getNua() {
        return nua;
    }

    public void setNua(String nua) {
        this.nua = nua;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return String.format("NUA: %-10s | Nombre: %-25s | Edad: %-3d | Carrera: %-25s | Estatus: %-10s",
                nua, nombreCompleto, edad, carrera, estatus);
    }
}
