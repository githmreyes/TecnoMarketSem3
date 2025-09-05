package com.tecnomarket.oop.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Pedido {
    public enum Estado { CREADO, CONFIRMADO, ENVIADO, ENTREGADO }

    private final String id;
    private final Cliente cliente;
    private final List<ItemPedido> items = new ArrayList<>();
    private BigDecimal total;
    private Estado estado;
    private final LocalDateTime fechaCreacion = LocalDateTime.now();

    private Pedido(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.estado = Estado.CREADO;
    }

    public static Pedido crearDesdeCarrito(Cliente cliente, Map<Producto, Integer> items, BigDecimal total) {
        Pedido p = new Pedido(UUID.randomUUID().toString(), cliente);
        items.forEach((prod, cant) -> p.items.add(new ItemPedido(prod, cant, prod.getPrecio())));
        p.total = total;
        return p;
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItems() { return List.copyOf(items); }
    public BigDecimal getTotal() { return total; }
    public Estado getEstado() { return estado; }
    public java.time.LocalDateTime getFechaCreacion() { return fechaCreacion; }

    public void confirmar() { this.estado = Estado.CONFIRMADO; }
    public void enviar() { this.estado = Estado.ENVIADO; }
    public void entregar() { this.estado = Estado.ENTREGADO; }
}
