package com.commercial_website.Repositories;

import com.commercial_website.Entities.Role;
import com.commercial_website.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByFullname(String fullname);

    Boolean existsByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    @Query(value = "SELECT DISTINCT u.* FROM users u " +
            "JOIN user_role ur ON u.userId = ur.userId " +
            "JOIN role r ON ur.roleId = r.roleId " +
            "WHERE r.roleName = :roleName", nativeQuery = true)
    Set<User> findUsersByRoleNameNative(@Param("roleName") String roleName);


    Set<User> findByFullnameContaining(String fullname);

    Set<User> findByWardContaining(String ward);

    Set<User> findByDistrictContaining(String district);

    Set<User> findByProvinceContaining(String province);

    Set<User> findByAddressDetailContaining(String addressDetail);

}
