/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

import java.util.ArrayList;

/**
 *
 * @author josed
 */
public class ControladorEmpleados {
    private EmpleadosList listaEmpleados;

    public ControladorEmpleados() {
        listaEmpleados = new EmpleadosList();
    }

    public boolean agregarEmpleado(String identificacion,
            String nombre, String telefono, puestoEmpleado puesto) {

        validarDatos(identificacion, nombre, telefono, puesto);

        Empleado empleado = new Empleado(
                identificacion,
                nombre,
                telefono,
                puesto
        );

        return listaEmpleados.agregar(empleado);
    }

    

    private void validarDatos(String identificacion,
            String nombre, String telefono, puestoEmpleado puesto) {

        if (identificacion.trim().isEmpty()
                || nombre.trim().isEmpty()
                || telefono.trim().isEmpty()
                || puesto == null) {

            throw new IllegalArgumentException(
                    "Debe completar todos los datos."
            );
        }
    }
       public Empleado buscarEmpleado(String identificacion) {
        return listaEmpleados.buscar(identificacion);
    }

    public boolean actualizarEmpleado(String identificacion,
            String nombre, String telefono, puestoEmpleado puesto) {

        validarDatos(identificacion, nombre, telefono, puesto);

        Empleado empleado =
                listaEmpleados.buscar(identificacion);

        if (empleado == null) {
            return false;
        }

        empleado.setNombre(nombre);
        empleado.setTelefono(telefono);
        empleado.cambiarPuesto(puesto);

        return true;
    }

    public boolean eliminarEmpleado(String identificacion) {
        return listaEmpleados.eliminar(identificacion);
    }

    public ArrayList<Empleado> listarEmpleados() {
        return listaEmpleados.listar();
    }
}
    
//queda pendiente revisar mañana

