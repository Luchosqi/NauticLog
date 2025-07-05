package org.example.MaquinasBarcos;

import org.example.PDF.Boleta;
import org.example.PDF.Informe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class MaquinaMock extends Maquina {
    public MaquinaMock(String nombre) {
        super(nombre);
    }
}

class MaquinaTest {

    private Maquina maquina;

    @BeforeEach
    public void setUp() {
        maquina = new MaquinaMock("Maquina 1");
    }

    @Test
    void registrarTrabajo() {
        Informe informe = new Informe("Informe 1");
        maquina.registrarTrabajo(informe);
    }

    @Test
    void testRegistrarTrabajo() {
        maquina.registrarTrabajo();
    }

    @Test
    void buscarTrabajo() {
        Informe informe = new Informe("BuscarEste");
        maquina.registrarTrabajo(informe);
        maquina.buscarTrabajo("BuscarEste");
    }

    @Test
    void borrarTrabajo() {
        Informe informe = new Informe("BorrarEste");
        maquina.registrarTrabajo(informe);
        maquina.borrarTrabajo("BorrarEste");
    }

    @Test
    void agregarFactura() {
        Boleta boleta = new Boleta();
        boleta.generarNumeroFactura();
        maquina.agregarFactura(boleta);
    }

    @Test
    void eliminarMotor() {
        Motor motor = new Motor("Suzuki", "MT200", "67890", LocalDate.of(2019, 3, 15), "2500 RPM");
        maquina.agregarMotor(motor);
        maquina.eliminarMotor("MT200");
    }

    @Test
    void buscarMotor() {
        Motor motor = new Motor("Yamaha", "MT100", "12345", LocalDate.of(2020, 5, 20), "3000 RPM");
        maquina.agregarMotor(motor);
        maquina.buscarMotor("MT100");
    }

    @Test
    public void testListarMotores() {
        Motor motor1 = new Motor("Yamaha", "X100", "00001", LocalDate.of(2021, 1, 1), "2800 RPM");
        Motor motor2 = new Motor("Honda", "X200", "00002", LocalDate.of(2022, 2, 2), "3200 RPM");
        maquina.agregarMotor(motor1);
        maquina.agregarMotor(motor2);
        maquina.listarMotores();
    }
}