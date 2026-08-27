package espacios;

/**
 *
 * @author Dylan
 */
public enum EstadoEspacio {
    
    DISPONIBLE ("Disponible"),
    OCUPADO ("Ocupado");
    
    private String estado;

    public String getEstado() {
        return estado;
    }

    private EstadoEspacio(String estado) {
        this.estado = estado;
    }
  
}
