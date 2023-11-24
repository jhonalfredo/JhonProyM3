package com.jhonproy.jhonproy.service.implement;// En el paquete com.diplomado.courses.services

import com.jhonproy.jhonproy.domain.entities.Rol;
import com.jhonproy.jhonproy.dto.RolDTO;
import com.jhonproy.jhonproy.repositories.spring.data.RolRepository;
import com.jhonproy.jhonproy.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImp implements RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolServiceImp(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<RolDTO> getAllRoles() {
        List<Rol> roles = rolRepository.findAll();
        return roles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<RolDTO> getRolById(Integer id) {
        return rolRepository.findById(id).map(this::convertToDTO);
    }

    public RolDTO createOrUpdateRol(RolDTO rolDTO) {
        Rol rol = convertToEntity(rolDTO);
        Rol savedRol = rolRepository.save(rol);
        return convertToDTO(savedRol);
    }

    public void deleteRol(Integer id) {
        rolRepository.deleteById(id);
    }


    private RolDTO convertToDTO(Rol rol) {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setName(rol.getName());
        return rolDTO;
    }

    private Rol convertToEntity(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());
        return rol;
    }
}
