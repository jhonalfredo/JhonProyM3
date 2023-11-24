package com.jhonproy.jhonproy.service.implement;

import com.jhonproy.jhonproy.domain.entities.Rol;
import com.jhonproy.jhonproy.domain.entities.UserAccount;
import com.jhonproy.jhonproy.domain.entities.UserRol;
import com.jhonproy.jhonproy.dto.UserRolDTO;
import com.jhonproy.jhonproy.repositories.spring.data.RolRepository;
import com.jhonproy.jhonproy.repositories.spring.data.UserAccountRepository;
import com.jhonproy.jhonproy.repositories.spring.data.UserRolRepository;
import com.jhonproy.jhonproy.service.UserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRolServiceImpl implements UserRolService {
    private final UserRolRepository userRolRepository;
    private final UserAccountRepository userAccountRepository;
    private final RolRepository rolRepository;

    @Autowired
    public UserRolServiceImpl(UserRolRepository userRolRepository, UserAccountRepository userAccountRepository, RolRepository rolRepository) {
        this.userRolRepository = userRolRepository;
        this.userAccountRepository = userAccountRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public UserRolDTO assignRoleToUser(Long userId, Integer roleId) {
        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(userId);
        Optional<Rol> rolOptional = rolRepository.findById(roleId);

        if (userAccountOptional.isPresent() && rolOptional.isPresent()) {
            UserAccount userAccount = userAccountOptional.get();
            Rol rol = rolOptional.get();

            UserRol userRol = new UserRol();
            userRol.setUserAccount(userAccount);
            userRol.setRol(rol);
            userRol.setActive(true);
            userRol.setCreatedAt(LocalDateTime.now());

            UserRol savedUserRol = userRolRepository.save(userRol);
            return convertToDTO(savedUserRol);
        }

        return null; // Manejar el caso en el que el usuario o el rol no existan
    }

    private UserRolDTO convertToDTO(UserRol userRol) {
        UserRolDTO userRolDTO = new UserRolDTO();
        userRolDTO.setId(userRol.getId());
        userRolDTO.setUserId(userRol.getUserAccount().getId());
        userRolDTO.setRoleId(userRol.getRol().getId());
        userRolDTO.setActive(userRol.isActive());
        userRolDTO.setCreatedAt(userRol.getCreatedAt());
        return userRolDTO;
    }

    @Override
    public UserRolDTO updateActiveStatus(Long userRolId, boolean active) {
        Optional<UserRol> userRolOptional = userRolRepository.findById(userRolId);

        if (userRolOptional.isPresent()) {
            UserRol userRol = userRolOptional.get();
            userRol.setActive(active);

            UserRol updatedUserRol = userRolRepository.save(userRol);
            return convertToDTO(updatedUserRol);
        }

        return null;
    }

    @Override
    public List<UserRolDTO> getUserRolesByRolId(Long rolId) {
        List<UserRol> userRoles = userRolRepository.findByRolId(rolId);
        return userRoles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
