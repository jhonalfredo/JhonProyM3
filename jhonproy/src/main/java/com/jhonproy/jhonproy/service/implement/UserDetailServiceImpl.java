package com.jhonproy.jhonproy.service.implement;

import com.jhonproy.jhonproy.domain.entities.Rol;
import com.jhonproy.jhonproy.domain.entities.UserAccount;
import com.jhonproy.jhonproy.domain.entities.UserDetail;
import com.jhonproy.jhonproy.dto.RolDTO;
import com.jhonproy.jhonproy.dto.UserAccountDTO;
import com.jhonproy.jhonproy.dto.UserDetailDTO;
import com.jhonproy.jhonproy.repositories.spring.data.UserDetailRepository;
import com.jhonproy.jhonproy.service.UserDetailService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    private final UserDetailRepository userDetailRepository;

    @Autowired
    public UserDetailServiceImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public Optional<UserDetailDTO> getDetailById(Long id) {
        return userDetailRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public List<UserDetailDTO> getAllUsers() {
        List<UserDetail> roles = userDetailRepository.findAll();
        return roles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);
    @Override
    public UserDetailDTO createUserDetail(UserDetailDTO userDetailDTO) {
        UserDetail userAccount = convertToEntity(userDetailDTO);
        UserDetail savedAccount = userDetailRepository.save(userAccount);
        //logger.info("*********************************IDDDDDDDD: "+savedAccount.getId());
        return convertToDTO(savedAccount);
    }

    private UserDetailDTO convertToDTO(UserDetail userDetail) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setUserId(userDetail.getId());
        userDetailDTO.setFirstName(userDetail.getFirstName());
        userDetailDTO.setLastName(userDetail.getLastName());
        userDetailDTO.setBirthDay(userDetail.getBirthDay());
        userDetailDTO.setAge(userDetail.getAge());

        return userDetailDTO;
    }

    private UserDetail convertToEntity(UserDetailDTO userAccountDTO) {
        UserDetail userAccount = new UserDetail();
        userAccount.setId(userAccountDTO.getUserId());
        userAccount.setAge(userAccountDTO.getAge());
        userAccount.setBirthDay(userAccountDTO.getBirthDay());
        userAccount.setFirstName(userAccountDTO.getFirstName());
        userAccount.setLastName(userAccountDTO.getLastName());
        return userAccount;
    }

}


