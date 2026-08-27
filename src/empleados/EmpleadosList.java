/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

import interfaces.KeyDynamicsLists;
import java.util.HashMap;
import java.util.Iterator;
/**
 *
 * @author josed
 */
public class EmpleadosList 
        implements KeyDynamicsLists<Empleado, String> {

    private HashMap<String, Empleado> empleados;

    public EmpleadosList() {
        empleados = new HashMap<>();
    }

 @Override
    public boolean add(Empleado empleado) {

        if (empleados.containsKey(empleado.getIdentificacion())) {
            return false;
        }

        empleados.put(
                empleado.getIdentificacion(),
                empleado
        );

        return true;
    }
    
    @Override

    public Empleado get(String identificacion) {
        return empleados.get(identificacion);
    }
    
    @Override
     public boolean remove(String identificacion) {

        Empleado empleado = get(identificacion);

        if (empleado == null) {
            return false;
        }

        empleados.remove(identificacion);
        return true;
    }
     @Override
     public Iterator getAll(){
         return empleados.values().iterator();
     }
     
     @Override
     public int size(){
         return empleados.size();
         
     }
     
     @Override
     public boolean isEmpty(){
         return empleados.isEmpty();
     }

  
}

    

