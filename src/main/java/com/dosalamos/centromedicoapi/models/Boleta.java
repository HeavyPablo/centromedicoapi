package com.dosalamos.centromedicoapi.models;

import javax.persistence.*;

@Entity
@Table(name = "BOLETAS")
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String monto;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String fechaCreacion;

    @Column(nullable = false)
    private String fechaActualizacion;

    public Boleta() {
    }

    public Boleta(String monto, String estado, String fechaCreacion, String fechaActualizacion) {
        this.monto = monto;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
