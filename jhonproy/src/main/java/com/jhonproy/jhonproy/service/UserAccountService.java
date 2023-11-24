package com.jhonproy.jhonproy.service;

import com.jhonproy.jhonproy.dto.UserAccountDTO;
import com.jhonproy.jhonproy.dto.UserDetailDTO;


import java.util.List;
import java.util.Optional;


public interface UserAccountService {

    Optional<UserAccountDTO> getAccountById(Long id);
    List<UserAccountDTO> getAllUserAccounts();
    UserAccountDTO createUserAccount(UserAccountDTO userAccountDTO);

    void deleteUserAccount(Long id);
}