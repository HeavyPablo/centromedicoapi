package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Rol;
import com.dosalamos.centromedicoapi.services.RolService;
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
@RequestMapping("/rol")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getAll() {
        return ResponseEntity.ok(rolService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(rolService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Rol> postCrearRol(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Rol rol = new Rol(
                    body.get("nombre"),
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(rolService.save(rol));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
