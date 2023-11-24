package com.jhonproy.jhonproy.service;

import com.jhonproy.jhonproy.dto.RolDTO;
import com.jhonproy.jhonproy.dto.UserAccountDTO;
import com.jhonproy.jhonproy.dto.UserDetailDTO;

import java.util.List;
import java.util.Optional;


public interface UserDetailService {

    Optional<UserDetailDTO> getDetailById(Long id);
    List<UserDetailDTO> getAllUsers();
    UserDetailDTO createUserDetail(UserDetailDTO userDetailDTO);
}
