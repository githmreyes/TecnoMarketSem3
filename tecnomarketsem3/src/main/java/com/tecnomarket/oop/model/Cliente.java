package com.tecnomarket.oop.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Cliente extends Usuario {
    private final List<Pedido> historialCompras = new ArrayList<>();
    private final Set<String> preferencias = new HashSet<>();

    public Cliente(String id, String nombre, String email, String contrasenaPlano) {
        super(id, nombre, email, contrasenaPlano);
    }

    public void agregarPreferencia(String etiqueta) {
        if (etiqueta != null && !etiqueta.isBlank()) preferencias.add(etiqueta.toLowerCase());
    }
    public Set<String> getPreferencias() { return Set.copyOf(preferencias); }

    public void registrarCompra(Pedido pedido) { historialCompras.add(Objects.requireNonNull(pedido)); }
    public List<Pedido> getHistorialCompras() { return List.copyOf(historialCompras); }
}
