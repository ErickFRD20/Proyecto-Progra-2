/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contratos;
import storagebox.StorageBox;

/**
 *
 * @author mr117
 */
public class ControladorContrato {
    private ContratosList contratos;
    
    public ControladorContrato(){
        contratos = StorageBox.getInstance().getContratos();
    }
    public ContratosList getContratos(){
        return contratos;
    }
    private void validarDatos(Contrato contrato){
        if (contrato == null){
            throw new IllegalArgumentException(
            "No puede estar vacio");
        }
    }
    
    public boolean agregarContrato(Contrato contrato){
        validarDatos(contrato);
        return contratos.agregar(contrato);
    }
    public boolean eliminarContrato(Contrato contrato){
       return contratos.eliminar(contrato);
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
