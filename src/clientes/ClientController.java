/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;
import exceptions.fechaInvalida;
import exceptions.operacionInvalida;
import exceptions.registroDuplicado;
import java.time.LocalDate;
import java.util.ArrayList;
import storagebox.StorageBox;
/**
 *
 * @author erick
 */
public class ClientController {
    private ClientsList listaClientes;
    public ClientController(){
        listaClientes = StorageBox.getInstance().getCliente();
    }
    
    public void agregarCliente(String id, String nombre, String telefono, LocalDate fechaNacimiento, String correo)
            throws registroDuplicado, fechaInvalida, operacionInvalida{
        Cliente cliente = new Cliente(id, nombre, telefono, fechaNacimiento, correo);
        listaClientes.agregarCliente(cliente);
    }
    
    public Cliente buscarCliente(String id){
        return listaClientes.buscarId(id);
    }
    
    public boolean actualizarCliente(String id, String nombre, String telefono, String correo)
            throws operacionInvalida{
        return listaClientes.actualizarCliente(id, nombre, telefono, correo);
    }
    
    public ArrayList<Cliente> buscarClientes(String filtro){
        return listaClientes.buscarPorFiltro(filtro);
    }
    
    public boolean eliminarCliente(String id)
            throws operacionInvalida{
        if(listaClientes.buscarId(id) == null ){
            throw new operacionInvalida("No existe un cliente con ese id");
        }
        return listaClientes.eliminarCliente(id);
    }
    
    public ArrayList<Cliente> getlistaClientes(){
        return listaClientes.getClientes();
    }
}
