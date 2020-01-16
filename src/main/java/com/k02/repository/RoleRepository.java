package com.k02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.k02.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
