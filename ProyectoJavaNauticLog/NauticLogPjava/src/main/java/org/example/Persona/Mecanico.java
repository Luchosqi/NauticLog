package org.example.Persona;

public class Mecanico extends Persona {

    private String rutEmpresa;
    private String nombreEmpresa;
    private String nivelTitulo;
    private String logoEmpresa;

    public Mecanico(String nombre, String correoElectronico, String numeroTelefonico, String rutEmpresa, String nombreEmpresa, String nivelTitulo, String logoEmpresa) {
        super(nombre, correoElectronico, numeroTelefonico);
        this.rutEmpresa = rutEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nivelTitulo = nivelTitulo;
        this.logoEmpresa = logoEmpresa;
    }

}
