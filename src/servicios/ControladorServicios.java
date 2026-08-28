/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import interfaces.iView;
import java.util.Iterator;

/**
 *
 * @author josed
 */
public class ControladorServicios {
    private ServiciosList listaServicios;
    private iView<servicioExtra> view;
    private int siguienteCodigo;
    
    public ControladorServicios(iView<servicioExtra> view) {
        this.view = view;
        this.listaServicios = new ServiciosList();
        this.siguienteCodigo = 1;
    }
    
      public void agregarServicio(String nombre,
            String descripcion, double precio) {

        if (nombre.isEmpty()) {
            view.showError("tiene que ingresar el nombre");
            return;
        }

        if (descripcion.isEmpty()) {
            view.showError("tiene que ingresar la descripcion");
            return;
        }

        if (precio <= 0) {
            view.showError("el precio debe ser mayor a 0");
            return;
        }

        servicioExtra nuevoServicio =new servicioExtra(siguienteCodigo, nombre,descripcion,precio);

        boolean agregado = listaServicios.add(nuevoServicio);
        if (agregado == true) { view.showMessage("se agrego correctamente el servicio." );
            siguienteCodigo = siguienteCodigo + 1;
            view.clear();
        } else {
            view.showError( "no se agrego ningun servicio");
        }
      }
        
        public void buscarServicio(int codigo) {
            servicioExtra servicioBuscado =listaServicios.get(codigo);
        if (servicioBuscado == null) { view.showError( "no existe ningun servicio");
        } else {
            view.showData(servicioBuscado);
        }
    }
        public void actualizarServicio(int codigo,
            String descripcion, double precio) {
        servicioExtra servicioBuscado = listaServicios.get(codigo);
        if (servicioBuscado == null) {view.showError("no existe ningun servicio");
            return;
        }
        if (descripcion.isEmpty()) {view.showError("tiene que poner la descripcion");
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

