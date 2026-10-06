import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Material> materiales;

    public Biblioteca() {
        this.materiales = new ArrayList<>();
    }

    public void agregarMaterial(Material material) {
        materiales.add(material);
    }

    public void listarMateriales() {
        for (Material material : materiales) {
            material.mostrarInformacion();
            System.out.println();
        }
    }

    public Material buscarMaterial(String titulo) {
        for (Material material : materiales) {
            if (material.getTitulo().equalsIgnoreCase(titulo)) {
                return material;
            }
        }
        return null;
    }

    public Material buscarMaterial(String titulo, int anio) {
        for (Material material : materiales) {
            if (material.getTitulo().equalsIgnoreCase(titulo) && material.getAnioPublicacion() == anio) {
                return material;
            }
        }
        return null;
    }
}
