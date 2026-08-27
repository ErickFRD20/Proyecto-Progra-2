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
}
    

