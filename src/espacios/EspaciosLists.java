package espacios;

import interfaces.KeyDynamicsLists;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Dylan
 */
public class EspaciosLists implements KeyDynamicsLists<Espacio, String> {

    private HashMap <String, Espacio> espacios;

    public EspaciosLists() {
        this.espacios = new HashMap<>();
    }
    
    
    
    @Override
    public Espacio get(String id) {
        if (!espacios.containsKey(id)) return null;
            return espacios.get(id); 
    }

    @Override
    public boolean remove(String id) {
        if(espacios == null) return false;
        return espacios.remove(id) != null;
    }

    @Override
    public boolean add(Espacio item) {
        if(espacios.containsKey(item.getNumero())) return false;
        return espacios.put(item.getNumero(), item) == null;
    }

    @Override
    public Iterator getAll() {
        if (espacios.isEmpty()) return null;
        return espacios.values().iterator();
    }

    @Override
    public int size() {
        return espacios.size();
    }

    @Override
    public boolean isEmpty() {
        return espacios.isEmpty();
    }   
}
