package com.ronalds.inventory_project.dao;

import com.ronalds.inventory_project.entity.Product;
import com.ronalds.inventory_project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
