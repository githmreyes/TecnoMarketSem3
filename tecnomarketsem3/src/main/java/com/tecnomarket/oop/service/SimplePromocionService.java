package com.tecnomarket.oop.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.tecnomarket.oop.model.Promocion;
import com.tecnomarket.oop.model.Producto;

public class SimplePromocionService implements PromocionService {
    @Override
    public Promocion crearPromocion(Producto p, double porcentaje, LocalDate finVigencia) {
        return new Promocion(porcentaje, finVigencia);
    }
    @Override
    public BigDecimal aplicarPromocion(Producto p, Promocion promo) {
        if (promo.finVigencia().isBefore(LocalDate.now())) return p.getPrecio();
        return p.precioConDescuento(promo.porcentaje());
    }
}
