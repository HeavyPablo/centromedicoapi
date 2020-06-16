package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Comuna;
import com.dosalamos.centromedicoapi.services.ComunaService;
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
@RequestMapping("/comuna")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ComunaController {

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<Comuna>> getAll() {
        return ResponseEntity.ok(comunaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(comunaService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Comuna> postCrearComuna(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Comuna comuna = new Comuna(
                    body.get("nombre"),
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(comunaService.save(comuna));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
