package com.jhonproy.jhonproy.web.rest;

import com.jhonproy.jhonproy.domain.entities.UserAccount;
import com.jhonproy.jhonproy.dto.RolDTO;
import com.jhonproy.jhonproy.dto.UserAccountDTO;
import com.jhonproy.jhonproy.dto.UserDetailDTO;
import com.jhonproy.jhonproy.service.UserAccountService;
import com.jhonproy.jhonproy.service.UserDetailService;
import com.jhonproy.jhonproy.service.UserService;
import com.jhonproy.jhonproy.service.implement.UserServiceImpl;
import com.jhonproy.jhonproy.web.rest.request.UserCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/api/users")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserAccountService userAccountService;
    private final UserDetailService userDetailService;

    @Autowired
    public UserController(UserAccountService userAccountService, UserDetailService userDetailService) {
        this.userAccountService = userAccountService;
        this.userDetailService = userDetailService;
    }

    @PostMapping
    public ResponseEntity<UserAccountDTO> createUser(@RequestBody UserCreationRequest userCreationRequest) {
        UserAccountDTO userAccountDTO = userCreationRequest.getUserAccount();
        UserDetailDTO userDetailDTO = userCreationRequest.getUserDetail();

        UserAccountDTO createdUserAccount = userAccountService.createUserAccount(userAccountDTO);
        Long accountId = createdUserAccount.getId();

        userDetailDTO.setUserId(accountId);
        UserDetailDTO createdUserDetail = userDetailService.createUserDetail(userDetailDTO);

        return new ResponseEntity<>(createdUserAccount, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<UserAccountDTO> existingRol = userAccountService.getAccountById(id);

        if (existingRol.isPresent()) {
            userAccountService.deleteUserAccount(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}




/*@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserAccount>> getUsers(){
        return ResponseEntity.ok().body(userService.listUsers());
    }
}*/
