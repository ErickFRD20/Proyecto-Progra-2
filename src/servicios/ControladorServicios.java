/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import interfaces.iView;
import java.util.Iterator;
import storagebox.StorageBox;

/**
 *
 * @author josed
 */
public class ControladorServicios {
    private ServiciosList listaServicios;
    private iView<servicioExtra> view;
    
    
    public ControladorServicios(iView<servicioExtra> view) {
        this.view = view;
        this.listaServicios = new ServiciosList();
        this.listaServicios = StorageBox.getInstance().getServicios();
        
    }
    public void agregarServicio(int codigo, String nombre, String descripcion, double precio) {
    servicioExtra nuevoServicio = new servicioExtra(codigo, nombre, descripcion, precio);
    boolean agregado = listaServicios.add(nuevoServicio);
    if (agregado == true) {
        view.showMessage("se agrego correctamente");
        view.clear();
    }else{
        view.showError("ya existe ese codigo");
    }
}
    
        public void buscarServicio(int codigo) {
            servicioExtra servicioBuscado =listaServicios.get(codigo);
        if (servicioBuscado == null) { view.showError( "no hay ningun servicio");
        } else {
            view.showData(servicioBuscado);
        }
    }
        public void actualizarServicio(int codigo,
            String descripcion, double precio) {
        servicioExtra servicioBuscado = listaServicios.get(codigo);
        if (servicioBuscado == null) {view.showError("no hay ningun servicio");
            return;
        }
        if (descripcion.isEmpty()) {view.showError("teiene que escribir una descripcion");
            return;
        }
        if (precio <= 0) {view.showError( "el precio tiene que ser mayor a 0");
            return;
        }
        servicioBuscado.setDescripcion(descripcion);
        servicioBuscado.setPrecio(precio);
        view.showMessage("se actualizo el servicio");
        view.clear();
    }
        public void eliminarServicio(int codigo) {
            boolean eliminado =listaServicios.remove(codigo);
         if (eliminado == true) {view.showMessage("se elimino el servicio");
            view.clear();
        } else {
            view.showError("este servicio no existe");
        }
    }
         public Iterator listarServicios() {
        return listaServicios.getAll();
    }

}

