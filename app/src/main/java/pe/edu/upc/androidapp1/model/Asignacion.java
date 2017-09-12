package pe.edu.upc.androidapp1.model;

public class Asignacion {

    String asignatario;
    String fecha;
    String titulo;
    String contenido;


    public String getAsignatario() {
        return asignatario;
    }

    public void setAsignatario(String asignatario) {
        this.asignatario = asignatario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Asignacion(String asignatario, String fecha, String titulo, String contenido) {
        this.asignatario = asignatario;
        this.fecha = fecha;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public Asignacion() {
        super();
    }

    @Override
    public String toString() {
        return "Asignacion{" +
                "asignatario='" + asignatario + '\'' +
                ", fecha='" + fecha + '\'' +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
