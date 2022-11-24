package com.code.muziki.roleservice.service;

import com.code.muziki.roleservice.domain.Role;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface RoleService {
    Optional<Role> saveRole(Role role);
    Optional<Page<Role>> search(String term, int pageNumber);
    Optional<Role> updateRole(Role role);
    void delete(Role role);
    void deleteById(Long id);
}

