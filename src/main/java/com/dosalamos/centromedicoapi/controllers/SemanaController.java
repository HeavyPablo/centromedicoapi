package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Semana;
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
@RequestMapping("/semana")
@Slf4j
public class SemanaController {

    @Autowired
    private SemanaService semanaService;

    @GetMapping
    public ResponseEntity<List<Semana>> getAll() {
        return ResponseEntity.ok(semanaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semana> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(semanaService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Semana> postCrearSemana(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Semana semana = new Semana(
                    body.get("fechaInicio"),
                    body.get("fechaTermino"),
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(semanaService.save(semana));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().build();
        }
    }
}
