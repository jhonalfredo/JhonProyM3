package com.jhonproy.jhonproy.service.implement;

import com.jhonproy.jhonproy.domain.entities.Rol;
import com.jhonproy.jhonproy.domain.entities.UserAccount;
import com.jhonproy.jhonproy.domain.entities.UserDetail;
import com.jhonproy.jhonproy.dto.RolDTO;
import com.jhonproy.jhonproy.dto.UserAccountDTO;
import com.jhonproy.jhonproy.dto.UserDetailDTO;
import com.jhonproy.jhonproy.repositories.spring.data.RolRepository;
import com.jhonproy.jhonproy.repositories.spring.data.UserAccountRepository;
import com.jhonproy.jhonproy.service.UserAccountService;
import com.jhonproy.jhonproy.service.UserDetailService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserAccountDTO> getAccountById(Long id) {
        return userAccountRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserAccountDTO> getAllUserAccounts() {
        List<UserAccount> roles = userAccountRepository.findAll();
        return roles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserAccountDTO createUserAccount(UserAccountDTO userAccountDTO) {
        UserAccount userAccount = convertToEntity(userAccountDTO);
        UserAccount savedAccount = userAccountRepository.save(userAccount);
        return convertToDTO(savedAccount);
    }

    @Override
    @Transactional
    public void deleteUserAccount(Long id) {
        userAccountRepository.deleteById(id);
    }


    private UserAccountDTO convertToDTO(UserAccount userAccount) {
        UserAccountDTO userAccountDTO= new UserAccountDTO();
        userAccountDTO.setId(userAccount.getId());
        userAccountDTO.setUsername(userAccount.getUsername());
        userAccountDTO.setPassword(userAccount.getPassword());
        userAccountDTO.setEmail(userAccount.getEmail());
        userAccountDTO.setCreatedAt(userAccount.getCreatedAt());
        return userAccountDTO;
    }

    private UserAccount convertToEntity(UserAccountDTO userAccountDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(userAccountDTO.getId());
        userAccount.setUsername(userAccountDTO.getUsername());
        userAccount.setEmail(userAccountDTO.getEmail());
        userAccount.setPassword(userAccountDTO.getPassword());
        userAccount.setCreatedAt(userAccountDTO.getCreatedAt());
        return userAccount;
    }
}