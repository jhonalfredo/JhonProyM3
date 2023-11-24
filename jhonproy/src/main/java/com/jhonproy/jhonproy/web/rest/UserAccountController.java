package com.jhonproy.jhonproy.web.rest;

import com.jhonproy.jhonproy.dto.UserAccountDTO;
import com.jhonproy.jhonproy.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/useraccount")
public class UserAccountController {

    private final UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public ResponseEntity<List<UserAccountDTO>> getAllUsers() {
        List<UserAccountDTO> cuentas = userAccountService.getAllUserAccounts();
        return new ResponseEntity<>(cuentas, HttpStatus.OK);
    }

}