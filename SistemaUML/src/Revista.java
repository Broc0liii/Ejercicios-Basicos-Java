public class Revista extends Material {

    private int numeroEdicion;

    public Revista(String codigo, String titulo, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Año: " + getAnioPublicacion());
        System.out.println("Número de edición: " + numeroEdicion);
    }
}
