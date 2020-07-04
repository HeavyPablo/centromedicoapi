package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Agenda;
import com.dosalamos.centromedicoapi.models.Medico;
import com.dosalamos.centromedicoapi.models.Semana;
import com.dosalamos.centromedicoapi.services.AgendaService;
import com.dosalamos.centromedicoapi.services.MedicoService;
import com.dosalamos.centromedicoapi.services.SemanaService;
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
@RequestMapping("/agenda")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;
    @Autowired
    private SemanaService semanaService;
    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Agenda>> getAll() {
        return ResponseEntity.ok(agendaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(agendaService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/medico/{id}")
    public ResponseEntity<List<Agenda>> getByMedicoId(@PathVariable String id) {
        Medico medico;
        try {
            medico = medicoService.findById(Integer.parseInt(id)).get();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(agendaService.findByMedico(medico));
    }

    @PostMapping
    public ResponseEntity<Agenda> postCrearAgenda(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Semana semana = semanaService.findById(Integer.parseInt(body.get("semana"))).get();
            Medico medico = medicoService.findById(Integer.parseInt(body.get("medico"))).get();

            Agenda agenda = new Agenda(
                    body.get("fecha"),
                    body.get("estado"),
                    body.get("dia"),
                    semana,
                    medico,
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(agendaService.save(agenda));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
