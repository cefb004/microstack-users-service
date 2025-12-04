package com.microstack.microstack_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microstack.microstack_users.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}

