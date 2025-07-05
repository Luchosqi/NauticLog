package org.example.Persona;

import org.example.MaquinasBarcos.Maquina;
import org.example.MaquinasBarcos.Barco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente;
    private Cliente cliente2;
    private Maquina barco1;
    private Maquina barco2;

    @BeforeEach
    public void setUp() {
        barco1 = new Barco("Titanic",cliente,"Pasajeros", "100");
        barco2 = new Barco("Poseidon",cliente2,"Carga", "200");
        Collection<Maquina> barcos = new ArrayList<>();
        Collection<Maquina> barcos2 = new ArrayList<>();
        cliente = new Cliente("Luis", "luis@email.com", "123456789", barcos);
        cliente2 = new Cliente("Maxi","maxi@gmail.com","991132454",barcos2);
    }

    @Test
    public void testAgregarMaquina() {
        cliente.agregarMaquina(barco1);
        assertTrue(cliente.getListaBarcos().contains(barco1));
    }

    @Test
    public void testBuscarMaquinaExiste() {
        cliente.agregarMaquina(barco1);
        cliente.buscarMaquina("Titanic");
    }

    @Test
    public void testListarMaquina() {
        cliente.agregarMaquina(barco1);
        cliente.agregarMaquina(barco2);
        cliente.listarMaquina();
    }
}
