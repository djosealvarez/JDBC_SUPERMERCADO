package com.training.prueba.modelo;

public class RepartidorCodigoPostal {

        private int idRepartidor;
        private String codigoPostal;

        public RepartidorCodigoPostal(int idRepartidor, String codigoPostal) {
            this.idRepartidor = idRepartidor;
            this.codigoPostal = codigoPostal;
        }

        public int getIdRepartidor() {
            return idRepartidor;
        }

        public void setIdRepartidor(int idRepartidor) {
            this.idRepartidor = idRepartidor;
        }

        public String getCodigoPostal() {
            return codigoPostal;
        }

        public void setCodigoPostal(String codigoPostal) {
            this.codigoPostal = codigoPostal;
        }
    }

