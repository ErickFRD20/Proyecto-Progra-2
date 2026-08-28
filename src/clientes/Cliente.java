/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;
import java.time.LocalDate;
import java.time.Period;
import personas.Persona;
/**
 *
 * @author erick
 */
public class Cliente extends Persona{
    private LocalDate fechaNacimiento;
    private String correo;
    
    public Cliente(String id, String nombre, String telefono, LocalDate fechaNacimiento, String correo){
        super(id, nombre, telefono);
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
    }

    public LocalDate getfechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int calcularEdad(){
       return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public boolean correoValido() {
    return correo != null && correo.matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$");
    }

    @Override
    public String toString() {
        return "Cliente{" + "fechaNacimiento=" + fechaNacimiento + ", correo=" + correo + '}';
    }
    
    
}
