
package datos;

import com.mysql.jdbc.Connection;
import database.Db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author isais
 */
public class DCategoria {
    public int id;
    public String nombre;
    private String table;
    private Db db;
    
    public DCategoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        table = "categorias";
        db = new Db();
        
    }
    
    public DCategoria findById(int id) {
        String sql = "select * from " + table + "where id=" + id ;
        DCategoria dcategoria = null;
        try {
            Connection connection = db.CreateConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            dcategoria = new DCategoria(rs.getInt(1), rs.getString(2));
        } catch (SQLException e) {
            System.out.println("Error"+ e);
        }
        return dcategoria;
    }
    
    public ArrayList<DCategoria> findAll() {
        ArrayList<DCategoria> dcategoriaList = new ArrayList();
        String sql = "select * from " + table;
        try {
            Connection connection = db.CreateConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next()) {
                dcategoriaList.add( new DCategoria(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+ e);
        }
        return dcategoriaList;
    }
    public void create(String nombre) {
        String sql = "insert into " + table + "(nombre) values(?)";
        try {
            PreparedStatement ps = this.db.getConnection().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    public void update(int id, String nombre) {
        String sql = "update " + table + " set nombre=? where id=?";
        try {
            PreparedStatement ps = this.db.getConnection().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
    }
    public void delete(int id) {
        String sql = "delete from " + table + " where id=" + id;
        try {
            PreparedStatement ps = this.db.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
    }
}
