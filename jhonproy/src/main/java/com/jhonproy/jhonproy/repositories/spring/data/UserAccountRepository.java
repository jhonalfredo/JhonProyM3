package com.jhonproy.jhonproy.repositories.spring.data;

import com.jhonproy.jhonproy.domain.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
