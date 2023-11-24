package com.jhonproy.jhonproy.web.rest;// En el paquete com.diplomado.courses.web.rest

import com.jhonproy.jhonproy.domain.entities.Rol;
import com.jhonproy.jhonproy.dto.RolDTO;
import com.jhonproy.jhonproy.service.implement.RolServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolServiceImp rolServiceImp;

    @Autowired
    public RolController(RolServiceImp rolServiceImp) {
        this.rolServiceImp = rolServiceImp;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> getAllRoles() {
        List<RolDTO> roles = rolServiceImp.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable Integer id) {
        Optional<RolDTO> rol = rolServiceImp.getRolById(id);
        return rol.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<RolDTO> createRol(@RequestBody RolDTO rolDTO) {
        RolDTO createdRol = rolServiceImp.createOrUpdateRol(rolDTO);
        return new ResponseEntity<>(createdRol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> updateRol(@PathVariable Integer id, @RequestBody RolDTO rolDTO) {
        Optional<RolDTO> existingRol = rolServiceImp.getRolById(id);

        if (existingRol.isPresent()) {
            rolDTO.setId(id);
            RolDTO updatedRol = rolServiceImp.createOrUpdateRol(rolDTO);
            return new ResponseEntity<>(updatedRol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        Optional<RolDTO> existingRol = rolServiceImp.getRolById(id);

        if (existingRol.isPresent()) {
            rolServiceImp.deleteRol(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


/*
@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.getRolById(id);
        return rol.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Rol> createOrUpdateRol(@RequestBody Rol rol) {
        Rol savedRol = rolService.createOrUpdateRol(rol);
        return new ResponseEntity<>(savedRol, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        rolService.deleteRol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
*/