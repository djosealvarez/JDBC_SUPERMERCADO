package com.training.prueba.modelo;

public class Producto {
        private int id;
        private String nombre;
        private String marca;
        private String origen;
        private String volumen;
        private String peso;
        private String fotografia;
        private long precio;
        private long stock;
        private String nombreCategoria;


        public Producto(int id, String nombre, String marca, String origen, String volumen, String peso, String fotografia, long precio, long stock, String nombreCategoria) {
            this.id = id;
            this.nombre = nombre;
            this.marca = marca;
            this.origen = origen;
            this.volumen = volumen;
            this.peso = peso;
            this.fotografia = fotografia;
            this.precio = precio;
            this.stock = stock;
            this.nombreCategoria = nombreCategoria;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getOrigen() {
            return origen;
        }

        public void setOrigen(String origen) {
            this.origen = origen;
        }

        public String getVolumen() {
            return volumen;
        }

        public void setVolumen(String volumen) {
            this.volumen = volumen;
        }

        public String getPeso() {
            return peso;
        }

        public void setPeso(String peso) {
            this.peso = peso;
        }

        public String getFotografia() {
            return fotografia;
        }

        public void setFotografia(String fotografia) {
            this.fotografia = fotografia;
        }

        public long getPrecio() {
            return precio;
        }

        public void setPrecio(long precio) {
            this.precio = precio;
        }

        public long getStock() {
            return stock;
        }

        public void setStock(long stock) {
            this.stock = stock;
        }

        public String getNombreCategoria() {
            return nombreCategoria;
        }

        public void setNombreCategoria(String nombreCategoria) {
            this.nombreCategoria = nombreCategoria;
        }
}
