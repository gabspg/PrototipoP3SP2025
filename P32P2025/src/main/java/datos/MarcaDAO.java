/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Marca; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class MarcaDAO {

    private static final String SQL_SELECT = "SELECT idMarca, Nombre_marca, Descripcion_marca FROM marca";
    private static final String SQL_INSERT = "INSERT INTO marca(idMarca, Nombre_marca, Descripcion_marca) VALUES(?, ?, ?)";//insertar un registro
    private static final String SQL_UPDATE = "UPDATE marca SET Nombre_marca=?, Descripcion_marca=?  WHERE idMarca=?"; //comodines son los =?
    private static final String SQL_DELETE = "DELETE FROM marca WHERE idMarca=?"; //para eliminar un registro
    private static final String SQL_QUERY = "SELECT idMarca, Nombre_marca, Descripcion_marca WHERE idMarca = ?";

    public List<Marca> select() { //primer mantenimiento, va a consultar
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Marca marca = null; //vendedor = alumno, Vendedor = Alumno
        List<Marca> marcas = new ArrayList<Marca>(); //vendedores = alumnos

        try { //try es un if, permite condicionar y captar un error
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idMarca = rs.getString("idMarca");
                String Nombre_marca = rs.getString("Nombre_marca");
                String Descripcion_marca = rs.getString("Descripcion_marca");
               
                
                marca = new Marca();
                marca.setIdMarca(idMarca);
                marca.setNombre_marca(Nombre_marca);
                marca.setDescripcion_marca(Descripcion_marca);
                
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return marcas;
    }

    public int insert(Marca marca) { //segundo metodo, permite establecer informacion
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            //stmt.setString(1, alumno.getCarnet_alumno());
            stmt.setString(1, marca.getIdMarca());
            stmt.setString(2, marca.getNombre_marca());
            stmt.setString(3, marca.getDescripcion_marca());


            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Marca marca) { //tercer mantenimiento, actualiza
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, marca.getIdMarca());
            stmt.setString(2, marca.getNombre_marca());
            stmt.setString(3, marca.getDescripcion_marca());
            
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Marca marca) {//cuarto metodo, borra
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, marca.getIdMarca());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Marca query(Marca marca) {    //Select enfocado
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; // Se declara el ResultSet, que contendrá los resultados de la consulta
        List<Marca> marcas = new ArrayList<Marca>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, marca.getIdMarca());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idMarca = rs.getString("idMarca");
                String Nombre_marca = rs.getString("Nombre_marca");
                String Descripcion_marca = rs.getString("Descripcion_marca");
                
                marca = new Marca();// Se crea una nueva instancia del objeto Marca. Esto inicializa un nuevo objeto de la clase Marca.
                marca.setIdMarca(idMarca);// Se establece el valor del atributo 'idMarca' 
                marca.setNombre_marca(Nombre_marca);// Se establece el valor del atributo 'Nombre_marca'
                marca.setDescripcion_marca(Descripcion_marca);// Se establece el valor del atributo 'Descripcion_marca'

                //con los set, enviamos los objetos
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return marca; //retorna el objeto unico
    }
        
}
