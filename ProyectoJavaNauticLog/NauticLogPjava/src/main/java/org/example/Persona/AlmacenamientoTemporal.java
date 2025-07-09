package org.example.Persona;


public class AlmacenamientoTemporal {
    private static AlmacenamientoTemporal instancia;
    private String nombre;
    private String rut;
    private String correo;
    private String celular;

    private String nombreCliente;
    private String rutCliente;
    private String empresaCliente;
    private String celularCliente;
    private String correoCliente;

    private String nombreBarco;
    private String modeloBarco;
    private String marcaBarco;
    private String motorBarco;

    private AlmacenamientoTemporal() {}

    public static AlmacenamientoTemporal getInstancia() {
        if (instancia == null) {
            instancia = new AlmacenamientoTemporal();
        }
        return instancia;
    }

    public void setDatos(String nombre, String rut, String correo, String celular) {
        this.nombre = nombre;
        this.rut = rut;
        this.correo = correo;
        this.celular = celular;
    }


    public void setDatosCliente(String nombre, String rut, String empresa, String celular, String correo) {
        this.nombreCliente = nombre;
        this.rutCliente = rut;
        this.empresaCliente = empresa;
        this.celularCliente = celular;
        this.correoCliente = correo;
    }


    public void setDatosBarco(String nombreBarco, String modeloBarco, String marcaBarco, String motorBarco) {
        this.nombreBarco = nombreBarco;
        this.modeloBarco = modeloBarco;
        this.marcaBarco = marcaBarco;
        this.motorBarco = motorBarco;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }


    public String getNombreCliente() { return nombreCliente; }
    public String getRutCliente() { return rutCliente; }
    public String getEmpresaCliente() { return empresaCliente; }
    public String getCelularCliente() { return celularCliente; }
    public String getCorreoCliente() { return correoCliente; }


    public String getNombreBarco() { return nombreBarco; }
    public String getModeloBarco() { return modeloBarco; }
    public String getMarcaBarco() { return marcaBarco; }
    public String getMotorBarco() { return motorBarco; }
}
