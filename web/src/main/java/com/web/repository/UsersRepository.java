package com.web.repository;

import com.web.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUserIdAndPassword(String userId, String password);
}
