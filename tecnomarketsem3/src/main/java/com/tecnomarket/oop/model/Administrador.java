package com.tecnomarket.oop.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.tecnomarket.oop.service.InventarioService;
import com.tecnomarket.oop.service.PromocionService;

public class Administrador extends Usuario {
    public Administrador(String id, String nombre, String email, String contrasenaPlano) {
        super(id, nombre, email, contrasenaPlano);
    }

    public void ajustarStock(Producto p, int delta, InventarioService inventarioService) {
        Objects.requireNonNull(p);
        Objects.requireNonNull(inventarioService);
        inventarioService.ajustarStock(p, delta);
    }

    public Promocion crearPromocion(Producto p, double porcentaje, LocalDate finVigencia, PromocionService promocionService) {
        Objects.requireNonNull(p);
        Objects.requireNonNull(promocionService);
        return promocionService.crearPromocion(p, porcentaje, finVigencia);
    }

    public BigDecimal aplicarPromocion(Producto p, Promocion promo, PromocionService promocionService) {
        Objects.requireNonNull(p);
        Objects.requireNonNull(promocionService);
        return promocionService.aplicarPromocion(p, promo);
    }
}
