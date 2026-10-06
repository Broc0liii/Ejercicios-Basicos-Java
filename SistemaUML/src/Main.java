public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("L001", "Programación en Java", 2025, "Juan Pérez", 350);
        Libro libro2 = new Libro("L002", "Estructuras de Datos", 2023, "Maria López", 420);

        Revista revista1 = new Revista("R001", "National Geographic", 2024, 150);
        Revista revista2 = new Revista("R002", "Ciencia Hoy", 2025, 45);

        biblioteca.agregarMaterial(libro1);
        biblioteca.agregarMaterial(libro2);
        biblioteca.agregarMaterial(revista1);
        biblioteca.agregarMaterial(revista2);

        biblioteca.listarMateriales();

        System.out.println("\n--- BÚSQUEDA POR TÍTULO ---");
        Material resultado1 = biblioteca.buscarMaterial("Programación en Java");
        if (resultado1 != null) {
            resultado1.mostrarInformacion();
        }

        System.out.println("\n--- BÚSQUEDA POR TÍTULO Y AÑO ---");
        Material resultado2 = biblioteca.buscarMaterial("National Geographic", 2024);
        if (resultado2 != null) {
            resultado2.mostrarInformacion();
        }
    }
}
