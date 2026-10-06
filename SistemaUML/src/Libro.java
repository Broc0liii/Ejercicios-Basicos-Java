public class Libro extends Material {

    private String autor;
    private int numeroPaginas;

    public Libro(String codigo, String titulo, int anioPublicacion, String autor, int numeroPaginas) {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Código: " + getCodigo());
        System.out.println("Título: " + getTitulo());
        System.out.println("Año: " + getAnioPublicacion());
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + numeroPaginas);
    }
}
