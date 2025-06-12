package org.example.Persona;

import com.itextpdf.kernel.pdf.xobject.PdfXObject;

public class Mecanico extends Persona {

    private String rutEmpresa;
    private String nombreEmpresa;
    private String nivelTitulo;
    private String logoEmpresa;
    private String direccionEmpresa;

    public Mecanico(String nombre, String correoElectronico, String numeroTelefonico, String rutEmpresa, String nombreEmpresa, String nivelTitulo, String logoEmpresa) {
        super(nombre, correoElectronico, numeroTelefonico);
        this.rutEmpresa = rutEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nivelTitulo = nivelTitulo;
        this.logoEmpresa = logoEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

}

