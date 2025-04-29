package com.farhad.tms.repository;

import com.farhad.tms.dto.response.CustomUserResponse;
import com.farhad.tms.dto.response.UserResponseDTO;
import com.farhad.tms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            SELECT u
            FROM User u
            """)
    List<CustomUserResponse> findAllUsers();

    @Query("""
            SELECT u 
            FROM User u
            """)
    List<UserResponseDTO> getAllUsers();

    @Query("""
            SELECT u
            FROM User u 
            WHERE u.id = :id 
            """)
    User getUserById(@Param("id") Long id);

    @Query("""
            SELECT u
            FROM User u 
            """)
    CustomUserResponse findCustomUserById();

    @Query("""
            SELECT u
            FROM User u
            WHERE u.email = :email
            """)
    User findByEmail(@Param("email") String email);
}
