/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author josed
 */
public class EmpleadosList {
    private HashMap<String, Empleado> empleados;

    public EmpleadosList() {
        empleados = new HashMap<>();
    }

    public boolean agregar(Empleado empleado) {

        if (empleados.containsKey(empleado.getIdentificacion())) {
            return false;
        }

        empleados.put(
                empleado.getIdentificacion(),
                empleado
        );

        return true;
    }

    public Empleado buscar(String identificacion) {
        return empleados.get(identificacion);
    }

    public boolean eliminar(String identificacion) {

        Empleado empleado = buscar(identificacion);

        if (empleado == null) {
            return false;
        }

        empleados.remove(identificacion);
        return true;
    }

    public ArrayList<Empleado> listar() {

        ArrayList<Empleado> lista = new ArrayList<>();

        for (Empleado empleado : empleados.values()) {
            lista.add(empleado);
        }

        return lista;
    }

    public int cantidad() {
        return empleados.size();
    }
}
    

