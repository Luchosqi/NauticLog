package org.example;

import org.example.Inventario.Insumo;
import org.example.Inventario.Pieza;
import org.example.Inventario.EstadoUso;
import org.example.Inventario.Originalidad;
import org.example.MaquinasBarcos.*;
import org.example.PDF.Boleta;
import org.example.PDF.Informe;
import org.example.Persona.Cliente;
import org.example.Persona.Mecanico;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<Informe> informes = new ArrayList<>();
        Collection<Motor> motores = new ArrayList<>();
        Collection<Maquina> listaBarcos = new ArrayList<>();
        Collection<Boleta> listaBoletas = new ArrayList<>();


        Cliente cliente = new Cliente("Juan Perez", "juanperez@mail.com", "987654321", listaBarcos);


        Mecanico mecanico = new Mecanico("Pedro Lopez", "pedro@taller.cl", "123456789", "77.123.456-7", "Taller Lopez", "Ingeniero naval", "zarla-la-popa-1x1-2400x2400-20211210-hp67yd7kccw9cd9779w8.webp");
        mecanico.setDireccionEmpresa("arturoprat 775");


        CreadorMaquinas fabrica = new BarcoFactory(cliente, "X200", "Yamaha", listaBoletas);
        Maquina barco = fabrica.crearMaquina(informes, motores, "Barco de Juan", listaBoletas);
        cliente.agregarMaquina(barco);


        List<Insumo> insumos = new ArrayList<>();
        insumos.add(new Pieza("Filtro Aceite", "5000", "6000", "Filtro de aceitoe motor", EstadoUso.nuevo, Originalidad.original, "Chile", "aaaaa", LocalDate.of(2022, 1, 10)));
        insumos.add(new Pieza("Bomba sssss", "15000", "18000", "Bomba para sss", EstadoUso.buenEstado, Originalidad.Alternativo, "EE.UU", "wwww", LocalDate.of(2020, 5, 5)));


        Boleta boleta1 = new Boleta();
        barco.agregarFactura(boleta1);
        boleta1.generarFactura(mecanico, (Barco) barco, cliente, insumos);
    }
}

