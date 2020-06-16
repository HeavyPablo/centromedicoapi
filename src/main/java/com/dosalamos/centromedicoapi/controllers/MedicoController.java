package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Agenda;
import com.dosalamos.centromedicoapi.models.Medico;
import com.dosalamos.centromedicoapi.models.Usuario;
import com.dosalamos.centromedicoapi.services.AgendaService;
import com.dosalamos.centromedicoapi.services.MedicoService;
import com.dosalamos.centromedicoapi.services.UsuarioService;
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
@RequestMapping("/medico")
@Slf4j
public class MedicoController {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public ResponseEntity<List<Medico>> getAll() {
        return ResponseEntity.ok(medicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(medicoService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Medico> postCrearMedico(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Usuario usuario = usuarioService.findById(Integer.parseInt(body.get("usuario"))).get();
            Agenda agenda = agendaService.findById(Integer.parseInt(body.get("agenda"))).get();

            Medico medico = new Medico(
                    body.get("profesion"),
                    usuario,
                    agenda,
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(medicoService.save(medico));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
