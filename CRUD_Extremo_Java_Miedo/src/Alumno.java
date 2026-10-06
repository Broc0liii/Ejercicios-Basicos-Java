public class Alumno {
    private String nombreCompleto;
    private int edad;
    private String carrera;
    private String nua;
    private String estatus;

    public Alumno(String nombreCompleto, int edad, String carrera, String nua){
        this.nombreCompleto=nombreCompleto;
        this.edad=edad;
        this.carrera=carrera;
        this.nua=nua;
        this.estatus="ACTIVO";
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    /// /////////////////
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /// /////////////////
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    /// ///////////////
    public String getNua() {
        return nua;
    }
    public void setNua(String nua) {
        this.nua = nua;
    }
    /// ///////////////
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString(){
        return "Nombre: " + nombreCompleto + " | Edad: " + edad + " | Carrera: " + carrera + " | NUA: " + nua + " | Estatus: " + estatus;
    }
}