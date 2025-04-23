package com.farhad.tms.repository;

import com.farhad.tms.dto.response.CustomUserResponse;
import com.farhad.tms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            select user
            from User user
            """)
    Set<CustomUserResponse> findAllUsers();

    @Query(value = "select * from User where email = :email", nativeQuery = true)
    User findByEmail(@Param("email") String email);
}
