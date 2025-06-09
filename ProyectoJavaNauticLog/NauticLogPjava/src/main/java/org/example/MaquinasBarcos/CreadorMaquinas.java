package org.example.MaquinasBarcos;
import org.example.PDF.Boleta;
import org.example.PDF.Informe;

import java.util.Collection;

public abstract class CreadorMaquinas {
    public abstract Maquina crearMaquina(Collection<Informe> informes, Collection<Motor> motores, String nombre, Collection<Boleta> boletas);
}


