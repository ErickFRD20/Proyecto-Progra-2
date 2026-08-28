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
    public void eliminarContrato(Contrato contrato){
        contratos.eliminar(contrato);
    }
    
    public Contrato buscarContrato(int numero){
        return contratos.buscarPorNumero(numero);
    } 
    public void activarContrato(Contrato contrato){
        contrato.activar();
    }
    public void cancelarContrato(Contrato contrato) {
        contrato.cancelar();
    }
    public void finalizarContrato(Contrato contrato){
        contrato.finalizar();
    }
}
