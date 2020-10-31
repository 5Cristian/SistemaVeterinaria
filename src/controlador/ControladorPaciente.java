/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.DBConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Paciente;

/**
 *
 * @author LENOVO
 */
public class ControladorPaciente {

    private PreparedStatement ps;
    private ResultSet rs;
    private boolean flag;
    
    
      public String [] Buscar(String buscar) {    //Metodo
          
        String[] datos = new String[8];
        DBConexion c = new DBConexion();
        String query = "select * from paciente where nombre_paciente like '%" + buscar + "%';";
        try {
            ps = c.conectarme().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = String.valueOf(rs.getInt(7));  // Parce de int a string
                datos[7] = rs.getString(8);
            }

           // d.setNombrePaciente(datos[0]);
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ps = null;
            //    c.desconectarme();
        }
         
        return datos;

    }
    
    

    public boolean insertar(Object o) {
        Paciente d = (Paciente) o;
        flag = false;
        DBConexion c = new DBConexion();
        String query = "insert into paciente (nombre_paciente, raza, fecha_nacimiento, nombre_dueno, apellido_dueno, telefono, direccion) values (?,?,?,?,?,?,?)";
        try {
            ps = c.conectarme().prepareStatement(query);
            ps.setString(1, d.getNombrePaciente());
            ps.setString(2, d.getRaza());
            ps.setString(3, d.getFechaNacimiento());
            ps.setString(4, d.getNombreDueno());
            ps.setString(5, d.getApellidoDueno());
            ps.setInt(6, d.getTelefono());
            ps.setString(7, d.getDireccion());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ps = null;
            //    c.desconectarme();
        }
        return flag;
    }
    
       public boolean actualizar(Object o) {
        Paciente d = (Paciente) o;
        flag = false;
        DBConexion c = new DBConexion();
        String query = "update paciente set nombre_paciente=?, raza=?, fecha_nacimiento=?, nombre_dueno=?, apellido_dueno=?, telefono=?, direccion=? where id_paciente=?";
        try {
            ps = c.conectarme().prepareStatement(query);
            
            ps.setString(1, d.getNombrePaciente());
            ps.setString(2, d.getRaza());
            ps.setString(3, d.getFechaNacimiento());
            ps.setString(4, d.getNombreDueno());
            ps.setString(5, d.getApellidoDueno());
            ps.setInt(6, d.getTelefono());
            ps.setString(7, d.getDireccion());
            ps.setInt(8, d.getIdPaciente());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ps = null;
            //    c.desconectarme();
        }
        return flag;
    }
       
       
       public boolean eliminar(String id) {
        
        flag = false;
        DBConexion c = new DBConexion();
        String query = "delete from paciente where id_paciente=?";
        try {
            ps = c.conectarme().prepareStatement(query);
         
            ps.setString(1,id);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ps = null;
            //    c.desconectarme();
        }
        return flag;
    }

}
