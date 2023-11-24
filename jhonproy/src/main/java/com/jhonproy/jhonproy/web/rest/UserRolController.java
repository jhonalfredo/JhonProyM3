package com.jhonproy.jhonproy.web.rest;

import com.jhonproy.jhonproy.dto.UserRolDTO;
import com.jhonproy.jhonproy.service.UserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRolController {
    private final UserRolService userRolService;

    @Autowired
    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }

    @PostMapping("/{userId}/assign/{roleId}")
    public ResponseEntity<UserRolDTO> assignRoleToUser(@PathVariable Long userId, @PathVariable Integer roleId) {
        UserRolDTO assignedRole = userRolService.assignRoleToUser(userId, roleId);
        return assignedRole != null
                ? new ResponseEntity<>(assignedRole, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{userRolId}")
    public ResponseEntity<UserRolDTO> updateActiveStatus(@PathVariable Long userRolId, @RequestBody UserRolDTO userRolDTO) {
        UserRolDTO updatedUserRol = userRolService.updateActiveStatus(userRolId, userRolDTO.isActive());

        return updatedUserRol != null
                ? new ResponseEntity<>(updatedUserRol, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/by-rol/{rolId}")
    public ResponseEntity<List<UserRolDTO>> getUserRolesByRolId(@PathVariable Long rolId) {
        List<UserRolDTO> userRoles = userRolService.getUserRolesByRolId(rolId);
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }
}
