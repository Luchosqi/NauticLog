package org.example;

import org.example.PDF.Boleta;
import org.example.PDF.Informe;
import org.example.Persona.Cliente;
import org.example.MaquinasBarcos.BarcoFactory;
import org.example.MaquinasBarcos.CreadorMaquinas;
import org.example.MaquinasBarcos.Maquina;
import org.example.MaquinasBarcos.Motor;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Collection<Informe> informes = new ArrayList<>();
        Collection<Motor> motores = new ArrayList<>();
        Collection<Maquina> listaBarcos = new ArrayList<>();
        Collection<Boleta> listaBoletas = new ArrayList<>();


        Cliente cliente = new Cliente("Juan Pérez", "AA@qq.vl", "567", listaBarcos);
        CreadorMaquinas fabrica = new BarcoFactory(cliente, "X200", "Yamaha", listaBoletas);
        Maquina barco = fabrica.crearMaquina(informes, motores, "Barco de Juan", listaBoletas);
        System.out.println(barco.mostrarInformacion());

        Motor motor1 = new Motor("Mitsubishi", "Modelo 120003", "SDF135", LocalDate.of(2005, 2, 5), "1201");
        cliente.agregarMaquina(barco);
        Boleta boleta1 = new Boleta();
        boleta1.generarFactura(barco);
        barco.agregarFactura(boleta1);

        System.out.println(boleta1);
        System.out.println("aaaaaaaaaaaaaaaaaa");


    }
}
