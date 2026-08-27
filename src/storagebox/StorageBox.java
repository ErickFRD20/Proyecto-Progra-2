package storagebox;

import clientes.ClientsList;
import contratos.ContratosList;
import empleados.EmpleadosList;
import espacios.EspaciosLists;

/**
 *
 * @author Dylan
 */
public class StorageBox {
    
    private static StorageBox instance;
    
    private ClientsList cliente;
    private EspaciosLists espacio;
    private EmpleadosList empleados;
    private ServiciosList servicios;
    private ContratosList contratos;

    public static StorageBox getInstance() {
        if (instance == null){
            instance = new StorageBox();
        }           
        return instance;
    }

    public ClientsList getCliente() {
        return cliente;
    }

    public EspaciosLists getEspacio() {
        return espacio;
    }

    public EmpleadosList getEmpleados() {
        return empleados;
    }

    public ServiciosList getServicios() {
        return servicios;
    }

    public ContratosList getContratos() {
        return contratos;
    }

    private StorageBox() {
        cliente = new ClientsList();
        espacio = new EspaciosLists();
        empleados = new EmpleadosList();
        servicios = new ServiciosList();
        contratos = new ContratosList();
    }
    
    
}
