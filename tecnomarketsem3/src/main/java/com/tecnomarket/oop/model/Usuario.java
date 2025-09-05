package com.tecnomarket.oop.model;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class Usuario {
    private static final Pattern EMAIL_RE = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");

    private final String id;
    private String nombre;
    private String email;
    private String contrasenaHash;

    protected Usuario(String id, String nombre, String email, String contrasenaPlano) {
        this.id = Objects.requireNonNull(id, "id no puede ser nulo");
        setNombre(nombre);
        setEmail(email);
        setContrasena(contrasenaPlano);
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre inválido");
        this.nombre = nombre;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || !EMAIL_RE.matcher(email).matches())
            throw new IllegalArgumentException("email inválido");
        this.email = email;
    }
    public String getContrasenaHash() { return contrasenaHash; }

    public void setContrasena(String contrasenaPlano) {
        if (contrasenaPlano == null || contrasenaPlano.length() < 6)
            throw new IllegalArgumentException("contraseña débil");
        this.contrasenaHash = Integer.toHexString(contrasenaPlano.hashCode());
    }
}
