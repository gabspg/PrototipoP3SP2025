/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author visitante
 */
public class Marca {

String idMarca; //atributos variables de mi base de datos (conservar)
String nombre_marca; 
String descripcion_marca;

    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + idMarca + ", nombre_marca=" + nombre_marca + ", descripcion_marca=" + descripcion_marca + '}';
    }

    public Marca(String idMarca, String nombre_marca, String descripcion_marca) {
        this.idMarca = idMarca;
        this.nombre_marca = nombre_marca;
        this.descripcion_marca = descripcion_marca;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public String getDescripcion_marca() {
        return descripcion_marca;
    }

    public void setDescripcion_marca(String descripcion_marca) {
        this.descripcion_marca = descripcion_marca;
    }


    

    
    
    public Marca() { //sin nada, sin parametros
    }

    public String getidMarca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
