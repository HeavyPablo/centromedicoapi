package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.*;
import com.dosalamos.centromedicoapi.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/solicitud")
@Slf4j
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private SucursalService sucursalService;
    @Autowired
    private BoletaService boletaService;

    @GetMapping
    public ResponseEntity<List<Solicitud>> getAll() {
        return ResponseEntity.ok(solicitudService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(solicitudService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Solicitud> postCrearSolicitud(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Usuario paciente = usuarioService.findById(Integer.parseInt(body.get("paciente"))).get();
            Medico medico = medicoService.findById(Integer.parseInt(body.get("medico"))).get();
            Sucursal sucursal = sucursalService.findById(Integer.parseInt(body.get("sucursal"))).get();

            Boleta boleta = new Boleta(
                    body.get("monto"),
                    body.get("estado"),
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            boleta = boletaService.save(boleta);

            Solicitud solicitud = new Solicitud(
                    body.get("descripcion"),
                    paciente,
                    medico,
                    sucursal,
                    boleta,
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(solicitudService.save(solicitud));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
