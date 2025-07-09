package org.example.Persona;

import com.itextpdf.kernel.pdf.xobject.PdfXObject;

public class Mecanico extends Persona {

    private String rutEmpresa;
    private String nombreEmpresa;
    private String nivelTitulo;
    private String logoEmpresa;
    private String direccionEmpresa;
    private final int id=1;

    public Mecanico(String nombre, String correoElectronico, String numeroTelefonico) {
        super(nombre, correoElectronico, numeroTelefonico);
    }

    public Mecanico(String nombre, String correoElectronico, String numeroTelefonico, String rutEmpresa,
                    String nombreEmpresa, String nivelTitulo, String logoEmpresa, String direccionEmpresa) {
        super(nombre, correoElectronico, numeroTelefonico);
        this.rutEmpresa = rutEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nivelTitulo = nivelTitulo;
        this.logoEmpresa = logoEmpresa;
        this.direccionEmpresa = direccionEmpresa;
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

