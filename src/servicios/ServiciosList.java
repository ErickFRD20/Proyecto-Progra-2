/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;
import interfaces.KeyDynamicsLists;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author josed
 */
public class ServiciosList 
        implements KeyDynamicsLists<servicioExtra, Integer> {
    private ArrayList<servicioExtra> servicios;
    
     public ServiciosList() {
        servicios = new ArrayList<>();
        
    }
    @Override
    public boolean add(servicioExtra servicio) {
        if (get(servicio.getCodigo()) != null) {
            return false;
        }
        servicios.add(servicio);
        return true;
    }
    @Override
    public servicioExtra get(Integer codigo) {
        for (servicioExtra servicio : servicios) {
          if (servicio.getCodigo() == codigo) {
             return servicio;
            }
        }
        return null;
    }
     @Override
    public boolean remove(Integer codigo) {
        servicioExtra servicio = get(codigo);
        if (servicio == null) {
            return false;
        }
        servicios.remove(servicio);
        return true;
    } 
    
    @Override
    public Iterator getAll() {
        return servicios.iterator();
    }
    
    @Override
    public int size() {
        return servicios.size();
    
    }
    @Override
   
       public boolean isEmpty() {
        return servicios.isEmpty();
    }
    
    

    
    
}
