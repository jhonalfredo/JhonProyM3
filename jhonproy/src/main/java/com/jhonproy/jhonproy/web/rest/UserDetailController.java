package com.jhonproy.jhonproy.web.rest;

import com.jhonproy.jhonproy.dto.RolDTO;
import com.jhonproy.jhonproy.dto.UserAccountDTO;
import com.jhonproy.jhonproy.dto.UserDetailDTO;
import com.jhonproy.jhonproy.service.UserAccountService;
import com.jhonproy.jhonproy.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userdetail")
public class UserDetailController {

    private final UserDetailService userDetailService;
    private final UserAccountService userAccountService;

    @Autowired
    public UserDetailController(UserDetailService userDetailService, UserAccountService userAccountService) {
        this.userDetailService = userDetailService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDTO> getDetailById(@PathVariable Long id) {
        Optional<UserDetailDTO> userDetail = userDetailService.getDetailById(id);

        if (userDetail.isPresent()) {
            // Obtener información de la cuenta correspondiente
            Long accountId = userDetail.get().getUserId();
            Optional<UserAccountDTO> userAccount = userAccountService.getAccountById(accountId);

            // Si existe la cuenta, agregar la información a UserDetailDTO
            if (userAccount.isPresent()) {
                UserDetailDTO userDetailDTO = userDetail.get();
                userDetailDTO.setAccount(userAccount.get());
                return new ResponseEntity<>(userDetailDTO, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> getAllUsers() {
        List<UserDetailDTO> cuentas = userDetailService.getAllUsers();
        cuentas.forEach(userDetailDTO -> {
            Long accountId = userDetailDTO.getUserId();
            Optional<UserAccountDTO> userAccount = userAccountService.getAccountById(accountId);

            // Si existe la cuenta
            userAccount.ifPresent(userDetailDTO::setAccount);
        });
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }
}


/*@RestController
@RequestMapping("/api/userdetail")
public class UserDetailController {

    private final UserDetailService userDetailService;

    @Autowired
    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDTO> getDetailById(@PathVariable Long id) {
        Optional<UserDetailDTO> rol = userDetailService.getDetailById(id);
        return rol.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> getAllUsers() {
        List<UserDetailDTO> cuentas = userDetailService.getAllUsers();
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }


}*/