/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espacios;

import interfaces.iView;
import java.util.Iterator;
import storagebox.StorageBox;

/**
 *
 * @author Dylan
 */
public class EspacioController {
    
    private EspaciosLists espacios;
    private iView vista;

    public EspacioController(iView vista) {
        this.espacios = StorageBox.getInstance().getEspacio();
        this.vista = vista;
    }
    
    public void agregarEspacio(Espacio espacio){ 
        if(espacios.add(espacio)){
            vista.showMessage("El espacio ha sido guardado");
        }else{
            vista.showError("Ya existe un espacio con ese ID");   
        }   
    }
    
    public Espacio buscarEspacio(String id){
        
        Espacio encontrarEspacio = espacios.get(id);
        
        if(encontrarEspacio == null){
            vista.showError("No existe el espacio con ese ID");
            vista.clear();
        }
        return encontrarEspacio;
    }
    
    public void actualizarEspacio(String id, double precioMes, double tamano, TipoEspacio tipo ){
        
        Espacio encontrarEsp = buscarEspacio(id);
        
        if (encontrarEsp == null) return;
        
        encontrarEsp.setTipo(tipo);
        encontrarEsp.setTamano(tamano);
        encontrarEsp.setPrecioMes(precioMes);  
        
        vista.showMessage("El espacio ha sido actualizado");
    }
    
    public void eliminarEspacio(String id){
        
        try{            
            Espacio encontrarEsp = buscarEspacio(id);        
            if (encontrarEsp == null) return; 
               
            if (!encontrarEsp.validarEliminarEspacio()){
                throw new exceptions.operacionInvalida("Espacio no disponible. Imposible eliminar.");
            }
            
            if (espacios.remove(id)){
                vista.showMessage("Espacio eliminado correctamente");
            }
            
        }   catch (exceptions.operacionInvalida e) {
            vista.showError(e.getMessage());
        }
    }
    
    public Iterator<Espacio> obtenerEspacios(){
        return espacios.getAll();
    }   
}
