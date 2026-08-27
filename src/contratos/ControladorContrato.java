/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contratos;

/**
 *
 * @author mr117
 */
public class ControladorContrato {
    private ContratosList contratos;
    
    public ControladorContrato(){
        contratos = new ContratosList();
    }
    public ContratosList getContratos(){
        return contratos;
    }
    public void agregarContrato(Contrato contrato){
        contratos.agregar(contrato);
    }
    public Contrato buscarContrato(int numero){
        return contratos.buscarPorNumero(numero);
    } 
}
