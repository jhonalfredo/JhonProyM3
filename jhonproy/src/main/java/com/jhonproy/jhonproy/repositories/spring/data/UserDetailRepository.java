package com.jhonproy.jhonproy.repositories.spring.data;

import com.jhonproy.jhonproy.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

}
