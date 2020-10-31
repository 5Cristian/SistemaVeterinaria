
package modelo;

import java.util.Date;


public class Cita {
   private int idCita;
   private int idPaciente;
   private String fechaCita;
   private String horaCita;
   private String motivoCita;

    public Cita() {
    }

    public Cita(int idCita, int idPaciente, String fechaCita, String horaCita, String motivoCita) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.motivoCita = motivoCita;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }
   
}
