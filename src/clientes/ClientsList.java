/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;
import java.util.ArrayList;
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
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
}
