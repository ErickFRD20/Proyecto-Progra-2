/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espacios;

import static espacios.TipoEspacio.GRANDE;
import static espacios.TipoEspacio.MEDIANO;
import static espacios.TipoEspacio.PEQUENO;

/**
 *
 * @author Dylan
 */
public class Espacio {
    
    private String numero;
    private double precioMes;
    private double tamano;    
    private TipoEspacio tipo;
    private EstadoEspacio estado;

    public String getNumero() {
        return numero;
    }

    public double getPrecioMes() {
        return precioMes;
    }

    public double getTamano() {
        return tamano;
    }

    public TipoEspacio getTipo() {
        return tipo;
    }

    public EstadoEspacio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEspacio estado) {
        this.estado = estado;
    }

    public void setPrecioMes(double precioMes) {
        this.precioMes = precioMes;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public void setTipo(TipoEspacio tipo) {
        this.tipo = tipo;
    }

    public Espacio(String numero, double precioMes, double tamano, TipoEspacio tipo) {
        this.numero = numero;
        this.precioMes = precioMes;
        this.tamano = tamano;
        this.tipo = tipo;
        this.estado = EstadoEspacio.DISPONIBLE;
    }
    
        public static double precioTipo(TipoEspacio tipo){
        
        if (tipo == null) return 0;       
        if (tipo == PEQUENO) return 25000;
        if (tipo == MEDIANO) return 45000;
        if (tipo == GRANDE) return 70000;       
        return 0;        
    }
    
    public boolean validarEliminarEspacio(){       
        return estado == EstadoEspacio.DISPONIBLE;
    }  
}
