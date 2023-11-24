package com.jhonproy.jhonproy.service;


import com.jhonproy.jhonproy.dto.UserRolDTO;

import java.util.List;

public interface UserRolService {
    UserRolDTO assignRoleToUser(Long userId, Integer roleId);

    UserRolDTO updateActiveStatus(Long userRolId, boolean active);
    List<UserRolDTO> getUserRolesByRolId(Long rolId);
}
