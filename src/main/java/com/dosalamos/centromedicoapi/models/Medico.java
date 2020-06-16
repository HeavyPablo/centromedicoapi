package com.dosalamos.centromedicoapi.models;

import javax.persistence.*;

@Entity
@Table(name = "MEDICOS")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String profesion;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Agenda agenda;

    @Column(nullable = false)
    private String fechaCreacion;

    @Column(nullable = false)
    private String fechaActualizacion;

    public Medico() {
    }

    public Medico(String profesion, Usuario usuario, Agenda agenda, String fechaCreacion, String fechaActualizacion) {
        this.profesion = profesion;
        this.usuario = usuario;
        this.agenda = agenda;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
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
