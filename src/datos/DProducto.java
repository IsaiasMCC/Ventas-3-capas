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
public class DProducto {

    public int id;
    public String nombre;
    public float precio;
    public int categoriaId;
    private String table;
    private Db db;

    public DProducto(int id, String nombre, float precio, int categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaId = categoriaId;
        table = "productos";
        db = new Db();
    }

    public DProducto findById(int id) {
        String sql = "select * from " + table + " where id=" + id;
        DProducto dproducto = null;
        try {
            Connection connection = db.CreateConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            dproducto = new DProducto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return dproducto;
    }

    public ArrayList<DProducto> findAll() {
        ArrayList<DProducto> dproductoList = new ArrayList();
        String sql = "select * from " + table;
        try {
            Connection connection = db.CreateConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dproductoList.add(new DProducto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
        return dproductoList;
    }

    public void create(String nombre, float precio, int categoriaId) {
        String sql = "insert into " + table + "(nombre, precio, categoria_id) values (?,?,?)";
        try {
            Connection con = db.CreateConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setFloat(2, precio);
            ps.setInt(3, categoriaId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
    }

    public void update(int id, String nombre, float precio, int categoriaId) {
        String sql = "update " + table + " set nombre=?, precio=?, categoria_id=? where id=?";
        try {
            Connection con = db.CreateConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setFloat(2, precio);
            ps.setInt(3, categoriaId);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
    }

    public void delete(int id) {
        String sql = "delete from " + table + " where id=" + id;
        try {
            Connection con = db.CreateConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        }
    }
}
