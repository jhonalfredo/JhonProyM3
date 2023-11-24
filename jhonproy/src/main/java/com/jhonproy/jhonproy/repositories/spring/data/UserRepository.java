package com.jhonproy.jhonproy.repositories.spring.data;

import com.jhonproy.jhonproy.domain.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
}
