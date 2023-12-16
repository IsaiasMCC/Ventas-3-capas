
package negocio;


import datos.DProducto;
import java.util.ArrayList;

/**
 *
 * @author isais
 */
public class NProducto {
    public int id;
    public String nombre;
    public float precio;
    public int categoriaId;
    private DProducto dproducto;
    
    public NProducto(int id, String nombre, float precio, int categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaId = categoriaId;
        dproducto = new DProducto(id, nombre, precio, categoriaId);
    }
    
    public NProducto findById(int id) {
        DProducto dproductoo = this.dproducto.findById(id);
        return new NProducto(dproductoo.id, dproductoo.nombre, dproductoo.precio, dproductoo.categoriaId);
    }
    
    public ArrayList<NProducto> findAll() {
        ArrayList<NProducto> nproductoList = new ArrayList();
        ArrayList<DProducto> dproductoList = this.dproducto.findAll();
        dproductoList.forEach((producto) -> {
            nproductoList.add( new NProducto(producto.id, producto.nombre, producto.precio, producto.categoriaId));
        });
        return nproductoList;
    }
    public void create(String nombre, float precio, int categoriaId) {
        this.dproducto.create(nombre, precio, categoriaId);
    }
    public void update(int id, String nombre, float precio, int categoriaId) {
        this.dproducto.update(id, nombre, precio, categoriaId);
    }
    public void delete(int id) {
        this.dproducto.delete(id);
    }
}
