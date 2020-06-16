package com.dosalamos.centromedicoapi.models;

import javax.persistence.*;

@Entity
@Table(name = "SOLICITUDES")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String descripcion;

    @ManyToOne
    private Usuario paciente;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Sucursal sucursal;

    @ManyToOne
    private Boleta boleta;

    @Column(nullable = false)
    private String fechaCreacion;

    @Column(nullable = false)
    private String fechaActualizacion;

    public Solicitud() {
    }

    public Solicitud(String descripcion, Usuario paciente, Medico medico, Sucursal sucursal, Boleta boleta, String fechaCreacion, String fechaActualizacion) {
        this.descripcion = descripcion;
        this.paciente = paciente;
        this.medico = medico;
        this.sucursal = sucursal;
        this.boleta = boleta;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
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
