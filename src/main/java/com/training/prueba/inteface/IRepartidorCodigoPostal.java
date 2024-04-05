package com.training.prueba.inteface;

import com.training.prueba.modelo.RepartidorCodigoPostal;

import java.util.List;

public interface IRepartidorCodigoPostal {
    public void mostrarRepartidoresCodigosPostales();
    public void insertarRepartidoresCodigosPostales(List<RepartidorCodigoPostal> repartidoresCodigosPostales);
}
