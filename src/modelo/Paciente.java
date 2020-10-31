package modelo;




public class Paciente {

    private int idPaciente;
    private String nombrePaciente;
    private String raza;
    private String fechaNacimiento;
    private String nombreDueno;
    private String apellidoDueno;
    private int telefono;
    private String direccion;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nombrePaciente, String raza, String fechaNacimiento, String nombreDueno, String apellidoDueno, int telefono, String direccion) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.nombreDueno = nombreDueno;
        this.apellidoDueno = apellidoDueno;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getApellidoDueno() {
        return apellidoDueno;
    }

    public void setApellidoDueno(String apellidoDueno) {
        this.apellidoDueno = apellidoDueno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
