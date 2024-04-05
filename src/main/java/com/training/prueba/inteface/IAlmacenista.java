package com.training.prueba.inteface;

import com.training.prueba.modelo.Almacenista;

import java.util.List;

public interface IAlmacenista {
    void mostrarAlmacenistas();

    void insertarAlmacenistas(List<Almacenista> almacenistas);

    public interface AlmacenistaDAOInterface {
        void mostrarAlmacenistas();
        void insertarAlmacenistas(List<Almacenista> almacenistas);
    }
}
