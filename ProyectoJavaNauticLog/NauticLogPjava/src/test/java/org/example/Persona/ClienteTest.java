import org.example.Persona.Cliente;
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
    public void testAgregarMaquinaMultiple() {
        cliente.agregarMaquina(barco1);
        cliente.agregarMaquina(barco2);
        assertEquals(2, cliente.getListaBarcos().size());
    }

    @Test
    public void testBuscarMaquinaExiste() {
        cliente.agregarMaquina(barco1);
        cliente.buscarMaquina("Titanic");
    }

    @Test
    public void testBuscarMaquinaNoExiste() {
        cliente.agregarMaquina(barco1);
        cliente.buscarMaquina("NoExiste");
    }

    @Test
    public void testListarMaquina() {
        cliente.agregarMaquina(barco1);
        cliente.agregarMaquina(barco2);
        cliente.listarMaquina();
    }

    @Test
    public void testConstructorCliente() {
        assertEquals("Luis", cliente.getNombre());
    }

    @Test
    public void testCorreoCliente() {
        assertEquals("luis@email.com", cliente.getCorreoElectronico());
    }

    @Test
    public void testTelefonoCliente() {
        assertEquals("123456789", cliente.getNumeroTelefonico());
    }

    @Test
    public void testListaInicialVacia() {
        assertTrue(cliente.getListaBarcos().isEmpty());
    }

    @Test
    public void testAgregarBarcoNull() {
        assertThrows(NullPointerException.class, () -> {
            cliente.agregarMaquina(null);
        });
    }
}
