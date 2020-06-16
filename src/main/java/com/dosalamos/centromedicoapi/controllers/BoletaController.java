package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Boleta;
import com.dosalamos.centromedicoapi.services.BoletaService;
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
@RequestMapping("/boleta")
@Slf4j
public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    @GetMapping
    public ResponseEntity<List<Boleta>> getAll() {
        return ResponseEntity.ok(boletaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boleta> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(boletaService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Boleta> postCrearBoleta(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Boleta boleta = new Boleta(
                    body.get("monto"),
                    body.get("estado"),
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(boletaService.save(boleta));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
