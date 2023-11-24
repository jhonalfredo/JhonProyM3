package com.jhonproy.jhonproy.service;

import com.jhonproy.jhonproy.domain.entities.Rol;
import com.jhonproy.jhonproy.dto.RolDTO;
import com.jhonproy.jhonproy.dto.UserRolDTO;
import com.jhonproy.jhonproy.repositories.spring.data.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> getAllRoles();
    Optional<RolDTO> getRolById(Integer id);

    RolDTO createOrUpdateRol(RolDTO rolDTO);
    void deleteRol(Integer id);
}
