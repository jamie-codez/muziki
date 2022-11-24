package com.code.muziki.roleservice.service;

import com.code.muziki.roleservice.domain.Role;
import com.code.muziki.roleservice.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Optional<Role> saveRole(Role role) {
        return Optional.of(roleRepository.save(role));
    }

    @Override
    public Optional<Page<Role>> search(String term, int pageNumber) {
        if (term.isBlank()) {
            return Optional.of(roleRepository.findAll(PageRequest.of(pageNumber, 30)));
        } else {
            return roleRepository.search(term,PageRequest.of(pageNumber,30));
        }
    }

    @Override
    @Transactional
    public Optional<Role> updateRole(Role role) {
        Optional<Role> mRole = roleRepository.findRoleByRoleName(role.getRoleName());
        mRole.ifPresent(r->{
            role.setRoleName(role.getRoleName());
            role.setDescription(role.getDescription());
        });
        return mRole;
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
