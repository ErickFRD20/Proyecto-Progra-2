/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contratos;

import clientes.Cliente;
import espacios.Espacio;
import java.time.LocalDate;
import java.util.ArrayList;
import servicios.servicioExtra;
/**
 *
 * @author mr117
 */
public class Contrato {
    private int numeroContrato;
    private Cliente cliente;
    private Espacio espacio;
    private LocalDate fechaInicio;
    private LocalDate fechaFinalizacion;
    private EstadoContrato estado;
    private ArrayList<servicioExtra> servicios;
    
    private double subtotal;
    private double impuestos;
    private double total;
    private static int contadorContratos = 1;

    public int getNumeroContrato() {
        return numeroContrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public EstadoContrato getEstado() {
        return estado;
    }

    public ArrayList<servicioExtra> getServicios() {
        return servicios;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public double getTotal() {
        return total;
    }

    public static int getContadorContratos() {
        return contadorContratos;
    }


    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public void setEstado(EstadoContrato estado) {
        this.estado = estado;
    }
    
    public void agregarServicio(servicioExtra servicio){
            servicios.add(servicio); 
    }
    
    public void eliminarServicio(servicioExtra servicio){
        servicios.remove(servicio);
        
    }

    public void calcularCosto(){

    }
    public void activar(){
        if (estado == EstadoContrato.PENDIENTE){
            estado = EstadoContrato.ACTIVO;
        }
    }
    public void cancelar(){
        if (estado == EstadoContrato.PENDIENTE){
            estado = EstadoContrato.CANCELADO;
        }
    }
    public void finalizar(){
        if (estado == EstadoContrato.ACTIVO){
            estado = EstadoContrato.FINALIZADO;
        }
    }

    public Contrato(Cliente cliente, Espacio espacio, LocalDate fechaInicio, 
            LocalDate fechaFinalizacion) {
        this.numeroContrato = contadorContratos;
        contadorContratos++;
        this.cliente = cliente;
        this.espacio = espacio;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        
        this.servicios = new ArrayList<>();
        this.estado = EstadoContrato.PENDIENTE;
        this.subtotal = 0;
        this.impuestos = 0;
        this.total = 0;
    }
    
    

    @Override
    public String toString() {
          return "Contrato #" + numeroContrato
            + "  Cliente: " + cliente.getNombre()
            + "  Estado: " + estado;
    }
    
}
