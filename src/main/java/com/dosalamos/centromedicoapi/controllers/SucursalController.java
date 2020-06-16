package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Comuna;
import com.dosalamos.centromedicoapi.models.Sucursal;
import com.dosalamos.centromedicoapi.services.ComunaService;
import com.dosalamos.centromedicoapi.services.SucursalService;
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
@RequestMapping("/sucursal")
@Slf4j
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<Sucursal>> getAll() {
        return ResponseEntity.ok(sucursalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(sucursalService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Sucursal> postCrearSucursal(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Comuna comuna = comunaService.findById(Integer.parseInt(body.get("comuna"))).get();

            Sucursal sucursal = new Sucursal(
                    body.get("nombre"),
                    body.get("direccion"),
                    comuna,
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(sucursalService.save(sucursal));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
