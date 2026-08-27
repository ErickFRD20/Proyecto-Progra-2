/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;
import java.util.ArrayList;
import exceptions.registroDuplicado;
import exceptions.fechaInvalida;
import java.time.LocalDate;
/**
 *
 * @author erick
 */
public class ClientsList {
    private ArrayList<Cliente> clientes;
    public ClientsList(){
        clientes = new ArrayList<>();
    }
    public Cliente buscarId(String id){
        for (Cliente cliente : clientes){
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }
    
    public void agregarCliente(Cliente cliente)
            throws registroDuplicado, fechaInvalida{
        if(buscarId(cliente.getId()) != null){
            throw new registroDuplicado("Ya existe un cliente con ese id");
        }
        if(cliente.getfechaNacimiento() == null || cliente.getfechaNacimiento().isAfter(LocalDate.now())){
            throw new fechaInvalida("La fecha no es valida");
        }
        clientes.add(cliente);
    }
    
   
    public boolean actualizarCliente(String id, String nombre, String telefono, String correo){
        Cliente cliente = buscarId(id);
        if (cliente != null){
            cliente.setNombre(nombre);
            cliente.setTelefono(telefono);
            cliente.setCorreo(correo);
            return true;
        }
        return false;
    }
    
    public boolean eliminarCliente(String id){
        Cliente cliente = buscarId(id);
        if(cliente != null){
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
}
