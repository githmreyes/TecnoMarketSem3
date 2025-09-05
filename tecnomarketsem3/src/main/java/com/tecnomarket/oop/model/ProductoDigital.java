package com.tecnomarket.oop.model;

public class ProductoDigital extends Producto {
    private String formatoArchivo;
    private double tamanoMB;
    private String urlDescarga;
    private String licencia;

    public ProductoDigital(String id, String nombre, String descripcion, java.math.BigDecimal precio, int stock,
                           String formatoArchivo, double tamanoMB, String urlDescarga, String licencia) {
        super(id, nombre, descripcion, precio, stock);
        setFormatoArchivo(formatoArchivo);
        setTamanoMB(tamanoMB);
        setUrlDescarga(urlDescarga);
        setLicencia(licencia);
    }

    @Override
    public boolean requiereEnvio() { return false; }

    public String getFormatoArchivo() { return formatoArchivo; }
    public void setFormatoArchivo(String formatoArchivo) {
        if (formatoArchivo == null || formatoArchivo.isBlank())
            throw new IllegalArgumentException("formatoArchivo inválido");
        this.formatoArchivo = formatoArchivo;
    }
    public double getTamanoMB() { return tamanoMB; }
    public void setTamanoMB(double tamanoMB) {
        if (tamanoMB < 0) throw new IllegalArgumentException("tamanoMB inválido");
        this.tamanoMB = tamanoMB;
    }
    public String getUrlDescarga() { return urlDescarga; }
    public void setUrlDescarga(String urlDescarga) {
        this.urlDescarga = java.util.Objects.requireNonNull(urlDescarga, "urlDescarga no puede ser nulo");
    }
    public String getLicencia() { return licencia; }
    public void setLicencia(String licencia) { this.licencia = (licencia == null) ? "" : licencia; }

    public String generarLinkDescarga(String clienteEmail) {
        return urlDescarga + "?user=" + clienteEmail + "&lic=" + (licencia == null ? "" : licencia);
    }
}
