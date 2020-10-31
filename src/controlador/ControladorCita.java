/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.DBConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cita;


/**
 *
 * @author LENOVO
 */
public class ControladorCita {

    private PreparedStatement ps;
    private ResultSet rs;
    private boolean flag;

    DefaultTableModel modelo;

    public void HistorialCitas(String id, JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        String[] datos = new String[8];
        DBConexion c = new DBConexion();
        String query = "select c.id_cita, p.nombre_paciente,c.fecha_cita,c.hora_cita,c.motivo_cita\n"
                + "from cita c inner join paciente p on (p.id_paciente=c.id_paciente)\n"
                + "where p.id_paciente = ?;";
        try {
            ps = c.conectarme().prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
               
                datos[0] = rs.getString(2);//nombre_paciente
                datos[1] = rs.getString(3);//fecha
                datos[2] = rs.getString(4);//hora
                datos[3] = rs.getString(5);//motivo
                modelo.addRow(datos);
            }

            // d.setNombrePaciente(datos[0]);
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ps = null;
            //    c.desconectarme();
        }

    }

    public boolean insertar(Object o) {
        Cita d = (Cita) o;
        flag = false;
        DBConexion c = new DBConexion();
        String query = "insert into cita(id_paciente, fecha_cita, hora_cita,motivo_cita) values(?,?,?,?);";
        try {
            ps = c.conectarme().prepareStatement(query);
            ps.setInt(1, d.getIdPaciente());
            ps.setString(2, d.getFechaCita());
            ps.setString(3, d.getHoraCita());
            ps.setString(4, d.getMotivoCita());

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
