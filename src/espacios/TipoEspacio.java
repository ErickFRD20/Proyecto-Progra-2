package espacios;

/**
 *
 * @author Dylan
 */
public enum TipoEspacio {
    
    PEQUENO("Pequeño"),
    MEDIANO("Mediano"),
    GRANDE("Grande");
    
    private String tamano;

    public String getTamano() {
        return tamano;
    }

    private TipoEspacio(String tamano) {
        this.tamano = tamano;
    }  
}
