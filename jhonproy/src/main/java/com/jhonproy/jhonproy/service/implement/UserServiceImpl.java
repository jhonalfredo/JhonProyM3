package com.jhonproy.jhonproy.service.implement;

import com.jhonproy.jhonproy.domain.entities.UserAccount;
import com.jhonproy.jhonproy.domain.entities.UserDetail;
import com.jhonproy.jhonproy.dto.UserAccountDTO;
import com.jhonproy.jhonproy.dto.UserDetailDTO;
import com.jhonproy.jhonproy.repositories.spring.data.UserAccountRepository;
import com.jhonproy.jhonproy.repositories.spring.data.UserDetailRepository;
import com.jhonproy.jhonproy.repositories.spring.data.UserRepository;
import com.jhonproy.jhonproy.service.UserAccountService;
import com.jhonproy.jhonproy.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Service
public class UserServiceImpl{ /*implements UserService {

    private final UserAccountRepository userAccountRepository;
    private final UserDetailRepository userDetailRepository;
    private final ModelMapper modelMapper; // Necesitarás esta dependencia para mapear entidades a DTOs

    @Autowired
    public UserServiceImpl(UserAccountRepository userAccountRepository, UserDetailRepository userDetailRepository, ModelMapper modelMapper) {
        this.userAccountRepository = userAccountRepository;
        this.userDetailRepository = userDetailRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserAccountDTO> getAllUserAccounts() {
        List<UserAccount> userAccounts = userAccountRepository.findAll();
        return userAccounts.stream()
                .map(this::convertToUserAccountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetailDTO getUserDetailByAccountId(Long accountId) {
        Optional<UserAccount> userAccount = userAccountRepository.findById(accountId);
        return null;//userAccount.map(account -> convertToUserDetailDTO(account.getUserDetail())).orElse(null);
    }

    private UserAccountDTO convertToUserAccountDTO(UserAccount userAccount) {
        UserAccountDTO userAccountDTO = modelMapper.map(userAccount, UserAccountDTO.class);
        //userAccountDTO.setUserDetail(convertToUserDetailDTO(userAccount.getUserDetail()));
        return userAccountDTO;
    }

    private UserDetailDTO convertToUserDetailDTO(UserDetail userDetail) {
        return modelMapper.map(userDetail, UserDetailDTO.class);
    }*/
}
