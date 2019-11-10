package com.training.RepairAgency.repository;

import com.training.RepairAgency.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password = ?1 WHERE u.id = ?2")
    void updatePasswordById(String password, Long userId);

    @Query(value = "SELECT user.* FROM user RIGHT JOIN  user_roles ON user.id=user_roles.user_id INNER JOIN role ON user_roles.roles_id=role.id WHERE role.name=:role",
    nativeQuery = true)
    Optional<List<User>>findByRole(@Param("role")String role);

    Optional<Long>findIdByEmail(String email);

    @Query(value = "SELECT user.email FROM user RIGHT JOIN user_roles ON user.id=user_roles.user_id INNER JOIN role ON user_roles.roles_id=role.id WHERE role.name=:role",
            nativeQuery = true)
    Optional<List<String>> findEmailByRole(@Param("role")String role);


}


