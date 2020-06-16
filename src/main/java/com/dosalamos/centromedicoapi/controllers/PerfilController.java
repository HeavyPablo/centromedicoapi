package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Perfil;
import com.dosalamos.centromedicoapi.services.PerfilService;
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
@RequestMapping("/perfil")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<Perfil>> getAll() {
        return ResponseEntity.ok(perfilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(perfilService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Perfil> postCrearPerfil(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Perfil perfil = new Perfil(
                    body.get("nombre"),
                    body.get("apellidoPaterno"),
                    body.get("apellidoMaterno"),
                    body.get("direccion"),
                    body.get("email"),
                    body.get("telefono"),
                    body.get("fechaNacimiento"),
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(perfilService.save(perfil));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
