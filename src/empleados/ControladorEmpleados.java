/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

import interfaces.iView;
import java.util.ArrayList;
import java.util.Iterator;
import storagebox.StorageBox;

/**
 *
 * @author josed
 */
public class ControladorEmpleados {
    private EmpleadosList listaEmpleados;
    private iView<Empleado> view; 
    public ControladorEmpleados(iView<Empleado> view) {
        listaEmpleados = new EmpleadosList();
        this.view = view;
        this.listaEmpleados = StorageBox.getInstance().getEmpleados();
    }
    
     private boolean validarDatos(String identificacion,String nombre, String telefono,puestoEmpleado puesto) {
        if (identificacion.isEmpty()
                || nombre.isEmpty()
                || telefono.isEmpty()
                || puesto == null) {
            view.showError("se deben llenar todos los datos");
            return false;
        }
        return true;
    }

    public boolean agregarEmpleado(String identificacion,
            String nombre, String telefono, puestoEmpleado puesto) {

        if (!validarDatos(
                identificacion,
                nombre,
                telefono,
                puesto)) {

            return false;
        }

        Empleado empleado = new Empleado(
                identificacion,
                nombre,
                telefono,
                puesto
        );
        if (!listaEmpleados.add(empleado)) {
            view.showError("ya hay un empleado con esa identificacion" );

            return false;
        }
        view.showMessage("se registro correctamente");
        view.clear();
        return true;

    }

       public Empleado buscarEmpleado(String identificacion) {
        if (identificacion.isEmpty()) {view.showError("debe poner la identificacion");
            return null;
        }
        Empleado empleado =listaEmpleados.get(identificacion);
        if (empleado == null) {view.showError("el empleado no existe" );

            return null;
        }
        view.showData(empleado);
        return empleado;
    
  
       
    }

    public boolean actualizarEmpleado(String identificacion,
            String nombre, String telefono, puestoEmpleado puesto) {

        if (!validarDatos(
                identificacion,
                nombre,
                telefono,
                puesto)) { return false;
        }

        Empleado empleado = listaEmpleados.get(identificacion);
        if (empleado == null) {view.showError("el empleado no existe");

            return false;
        }

        empleado.setNombre(nombre);
        empleado.setTelefono(telefono);
        empleado.cambiarPuesto(puesto);

        view.showMessage("se actualizo correctamente");

        view.clear();
        return true;
    }

    
    public boolean eliminarEmpleado(String identificacion) {
        if (identificacion.isEmpty()) {
            view.showError("debe poner la identificacion");

            return false;
        }
        if (!listaEmpleados.remove(identificacion)) {
            view.showError("el empleado no existe");
            return false;
        }

        view.showMessage("se borro correctamente");

        view.clear();
        return true;
    }

 
    public Iterator listarEmpleados() {
    return listaEmpleados.getAll();
}
}
    


