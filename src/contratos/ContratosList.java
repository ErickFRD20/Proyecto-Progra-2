/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contratos;

import java.util.ArrayList;

/**
 *
 * @author mr117
 */
public class ContratosList {
    private ArrayList<Contrato> contratos;
    
    public ContratosList(){
        contratos = new ArrayList<>();      
    }
    
    public boolean agregar(Contrato contrato){
       if(contratos.contains(contrato)){
           return false;
       }
       contratos.add(contrato);
       return true;
    }
    
    public boolean eliminar(Contrato contrato){
    if (!contratos.contains(contrato)){
        return false;
    }
    
    contratos.remove(contrato);
    return true;
    }
    
    public ArrayList<Contrato> getContratos(){
        return contratos;
    }
    
    public int cantidad(){
        return contratos.size();  
    }
    
    public Contrato buscarPorNumero(int numero){
        for (Contrato contrato : contratos){
            if (contrato.getNumeroContrato() == numero){
                return contrato;
            }
        }
        return null;
    }
}
