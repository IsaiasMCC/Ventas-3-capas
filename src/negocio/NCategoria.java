
package negocio;

import datos.DCategoria;
import java.util.ArrayList;

/**
 *
 * @author isais
 */
public class NCategoria {
    public int id;
    public String nombre;
    public DCategoria dcategoria;
    
    public NCategoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        dcategoria = new DCategoria(id, nombre);
    }
    
    public NCategoria findById(int id) {
        dcategoria = this.dcategoria.findById(id);
        return new NCategoria(dcategoria.id, dcategoria.nombre);
    }
    public ArrayList<NCategoria> findAll() {
        ArrayList<NCategoria> ncategoriaList = new ArrayList();
        ArrayList<DCategoria> dcategoriaList = this.dcategoria.findAll();
        for(DCategoria categoria: dcategoriaList) {
            ncategoriaList.add( new NCategoria(categoria.id, categoria.nombre));
        }
        return ncategoriaList;
    }
    public void create(String nombre) {
        this.dcategoria.create(nombre);
    }
    public void update(int id, String nombre) {
        this.dcategoria.update(id, nombre);
    }
    public void delete(int id) {
        this.dcategoria.delete(id);
    }
}
