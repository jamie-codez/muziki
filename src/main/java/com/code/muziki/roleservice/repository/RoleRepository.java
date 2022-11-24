package com.code.muziki.roleservice.repository;

import com.code.muziki.roleservice.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("select u from role u where u.roleName like lower(concat('%',:term,'%')) " +
            "or u.description like lower(concat('%',:term,'%'))")
    Optional<Page<Role>> search(@Param(value = "term") String term, Pageable pageable);
    Optional<Role> findRoleByRoleName(String roleName);
}
