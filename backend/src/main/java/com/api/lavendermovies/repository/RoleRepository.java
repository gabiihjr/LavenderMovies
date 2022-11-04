package com.api.lavendermovies.repository;

import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByRoleName(RoleName roleName);
}
