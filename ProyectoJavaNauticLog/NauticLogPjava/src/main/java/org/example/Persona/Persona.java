package org.example.Persona;

public abstract class Persona {

    private String nombre;
    private String correoElectronico;
    private String numeroTelefonico;

    public Persona(String nombre, String correoElectronico, String numeroTelefonico) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.numeroTelefonico = numeroTelefonico;
    }

    public void mostrarInformacion() {

    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", numeroTelefonico='" + numeroTelefonico + '\'' +
                '}';
    }
}
