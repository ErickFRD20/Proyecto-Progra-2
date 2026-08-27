/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

/**
 *
 * @author josed
 */
public class Empleado {
    
     private String identificacion;
    private String nombre;
    private String telefono;
    private puestoEmpleado puesto;
    private double salario;
    
     public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public puestoEmpleado getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void cambiarPuesto(puestoEmpleado puesto) {

        this.puesto = puesto;

        switch (puesto) {

            case ADMINISTRADOR:
                salario = 950000;
                break;

            case RECEPCIONISTA:
                salario = 700000;
                break;

            case ENCARGADO_BODEGA:
                salario = 650000;
                break;

            case MANTENIMIENTO:
                salario = 600000;
                break;

            case OPERARIO_CARGA:
                salario = 575000;
                break;
        }
    }
        public Empleado(String identificacion, String nombre,
            String telefono, puestoEmpleado puesto) {
            this.identificacion = identificacion;
            this.nombre = nombre;
            this.telefono = telefono;
            cambiarPuesto(puesto);
           
           }
    
}
