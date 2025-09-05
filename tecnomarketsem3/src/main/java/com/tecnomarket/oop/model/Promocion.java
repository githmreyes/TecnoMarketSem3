package com.tecnomarket.oop.model;

import java.time.LocalDate;

public record Promocion(double porcentaje, LocalDate finVigencia) {
    public Promocion {
        if (porcentaje <= 0 || porcentaje >= 100) throw new IllegalArgumentException("porcentaje inválido");
        if (finVigencia == null || finVigencia.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("vigencia inválida");
    }
}
