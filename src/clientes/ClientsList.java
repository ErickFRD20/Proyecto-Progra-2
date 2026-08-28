/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;
import java.util.ArrayList;
import exceptions.registroDuplicado;
import exceptions.fechaInvalida;
import java.time.LocalDate;
import exceptions.operacionInvalida;
import interfaces.KeyDynamicsLists;
import java.util.Iterator;
/**
 *
 * @author erick
 */
public class ClientsList implements KeyDynamicsLists<Cliente, String> {
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
            throws registroDuplicado, fechaInvalida, operacionInvalida{
        
        if(cliente.getId() == null || cliente.getId().isBlank() 
                || cliente.getNombre() == null || cliente.getNombre().isBlank() 
                || cliente.getTelefono() == null || cliente.getTelefono().isBlank() 
                || cliente.getCorreo() == null || cliente.getCorreo().isBlank()){
            throw new operacionInvalida("Debe completar los datos solicitados");
        }
        
        if(buscarId(cliente.getId()) != null){
            throw new registroDuplicado("Ya existe un cliente con ese id");
        }
        if(cliente.getfechaNacimiento() == null || cliente.getfechaNacimiento().isAfter(LocalDate.now())){
            throw new fechaInvalida("La fecha no es valida");
        }
        if(!cliente.correoValido()){
            throw new operacionInvalida("El correo electronico no tiene un formato valido");
        }
        
        clientes.add(cliente);
    }
   
    
    public boolean actualizarCliente(String id, String nombre, String telefono, String correo)
        throws operacionInvalida{
        if(nombre == null || nombre.isBlank() || telefono == null || telefono.isBlank() || correo == null || correo.isBlank()){
            throw new operacionInvalida("Debe completar los datos solicitados");
        }
        
        if(!correo.matches("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$")){
        throw new operacionInvalida("El correo electronico no tiene un formato valido");
        }
        
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
    
    public ArrayList<Cliente> buscarPorFiltro(String texto){
        ArrayList<Cliente> resultado = new ArrayList<>();
        if(texto == null || texto.isBlank()){
            return new ArrayList<>(clientes);
        }
        String filtro = texto.toLowerCase();
        for(Cliente cliente : clientes){
            if(cliente.getId().toLowerCase().contains(filtro)
                    || cliente.getNombre().toLowerCase().contains(filtro)
                    || cliente.getCorreo().toLowerCase().contains(filtro)){
                resultado.add(cliente);
            }
        }
        return resultado;
    }
    
    public ArrayList<Cliente> getClientes(){
        return new ArrayList<>(clientes);
    }

    @Override
    public Cliente get(String id) {
        return buscarId(id);
    }

    @Override
    public boolean remove(String id) {
        return eliminarCliente(id);
    }

    @Override
    public boolean add(Cliente cliente) {
        try {
            agregarCliente(cliente);
            return true;
        } catch (registroDuplicado | fechaInvalida | operacionInvalida ex) {
            return false;
        }
    }

    @Override
    public Iterator getAll() {
        return clientes.iterator();
    }

    @Override
    public int size() {
        return clientes.size();
    }

    @Override
    public boolean isEmpty() {
        return clientes.isEmpty();
    }
}
