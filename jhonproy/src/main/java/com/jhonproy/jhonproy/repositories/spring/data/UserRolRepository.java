package com.jhonproy.jhonproy.repositories.spring.data;

import com.jhonproy.jhonproy.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolRepository extends JpaRepository<UserRol, Long> {
    List<UserRol> findByRolId(Long rolId);
}
