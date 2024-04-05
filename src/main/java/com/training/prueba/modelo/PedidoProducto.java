package com.training.prueba.modelo;

public class PedidoProducto {

        private int idPedido;
        private int idProducto;
        private int cantidad;
        private long precioUnitario;


        public PedidoProducto(int idPedido, int idProducto, int cantidad, long precioUnitario) {
            this.idPedido = idPedido;
            this.idProducto = idProducto;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
        }


        public int getIdPedido() {
            return idPedido;
        }

        public void setIdPedido(int idPedido) {
            this.idPedido = idPedido;
        }

        public int getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(int idProducto) {
            this.idProducto = idProducto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public long getPrecioUnitario() {
            return precioUnitario;
        }

        public void setPrecioUnitario(long precioUnitario) {
            this.precioUnitario = precioUnitario;
        }
}
