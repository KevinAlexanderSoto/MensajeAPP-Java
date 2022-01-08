public class Mensajes {// modelo

    private int id_mensaje;
    private String mensaje;
    private String autor_mensaje;
    private String fecha_mensaje;

    public Mensajes() {

    }

    public Mensajes(String mensaje, String autor_mensaje, int id_mensaje) {
        this.mensaje = mensaje;
        this.autor_mensaje = autor_mensaje;
        this.id_mensaje= id_mensaje;
    }

    public int getIdMensaje() {
        return id_mensaje;
    }

    public void setIdMensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor_mensaje() {
        return autor_mensaje;
    }

    public void setAutor_mensaje(String autor_mensaje) {
        this.autor_mensaje = autor_mensaje;
    }

    public String getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(String fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }
}
