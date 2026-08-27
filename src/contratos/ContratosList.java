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
    
    public void agregar(Contrato contrato){
        contratos.add(contrato);
    }
    
    public void eliminar(Contrato contrato){
        contratos.remove(contrato);
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
